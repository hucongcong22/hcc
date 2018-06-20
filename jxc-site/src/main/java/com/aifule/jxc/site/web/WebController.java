package com.aifule.jxc.site.web;

import java.util.HashMap;
import java.util.Map;


import com.aifule.jxc.core.domain.User;
import com.aifule.jxc.site.common.constant.SysConstant;

import javax.servlet.http.HttpServletRequest;


import com.aifule.jxc.core.mybatispage.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class WebController {

    private Logger log = LoggerFactory.getLogger(WebController.class);

    private Map<String, Object> resultMap = null;

    private RspHeader rspHeader = new RspHeader();

//    public static Map<String, Object>

    protected enum ErrMsg {
        HAS_NO_AUTH_TO_VISIT("has no auth to visit"),
        HAS_NO_EXIST_RESOURCE("has no exist the resource"),;
        private String msg;

        private ErrMsg(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }


    public void putData(Object data) {
        resultMap = new HashMap<String, Object>();
        resultMap.put(SysConstant._JSON_RETURN_DATA, data);
        resultMap.put("t", new java.util.Date(System.currentTimeMillis()));
        rspHeader.setRspCode(SysConstant._JSON_RETURN_RSPCODE_SUCCESS);
        rspHeader.setRspMsg(null);
        resultMap.put(SysConstant._JSON_RETURN_RSPHEADER, rspHeader);
    }


    public void putPage(Page page) {
        if (page.getEnd() > page.getTotalRecord()) {
            page.setEnd(page.getTotalRecord());
        }
        if (page.getTotalRecord() > page.getEnd() && page.getEnd() == 0) {
            page.setEnd(page.getTotalRecord());
        }
        resultMap.put(SysConstant._JSON_RETURN_PAGE, page);
    }

    public void setRspCode(String rspCode) {
        rspHeader.setRspCode(rspCode);
    }

    public void setRspMsg(String msg) {
        rspHeader.setRspMsg(msg);
    }

    public void setFailInfo(String code, String msg) {
        resultMap = new HashMap<String, Object>();
        rspHeader.setRspCode(code);
        rspHeader.setRspMsg(msg);
        resultMap.put("t", new java.util.Date(System.currentTimeMillis()));
        resultMap.put(SysConstant._JSON_RETURN_RSPHEADER, rspHeader);
    }


    public void setPopInfo(String msg) {
        setFailInfo(SysConstant._JSON_RETURN_RSPCODE_POP, msg);
    }

    public Map<String, Object> getPopResultMap(String msg) {
        setPopInfo(msg);
        return resultMap;
    }

    public Map<String, Object> getPopResultMap(ErrMsg errMsg) {
        return getPopResultMap(errMsg.getMsg());
    }


    public void setFailInfo(String msg) {
        setFailInfo(SysConstant._JSON_RETURN_RSPCODE_FAIL, msg);
    }

    public Map<String, Object> getFailResultMap(String msg) {
        setFailInfo(msg);
        return resultMap;
    }

    public Map<String, Object> getFailResultMap(ErrMsg errMsg) {
        return getFailResultMap(errMsg.getMsg());
    }

    public Map<String, Object> getOverdueResultMap(String msg) {
        setFailInfo(SysConstant._JSON_RETURN_RSPCODE_OVERDUE, msg);
        return resultMap;
    }


    public Map<String, Object> getAmountLessResultMap(String msg) {
        setFailInfo(SysConstant._JSON_RETURN_RSPCODE_AMOUNTLESS, msg);
        return resultMap;
    }

    public Map<String, Object> getAmountLessResultMap(String msg, Object data) {
        resultMap = new HashMap<String, Object>();
        rspHeader.setRspCode(SysConstant._JSON_RETURN_RSPCODE_AMOUNTLESS);
        rspHeader.setRspMsg(msg);
        resultMap.put("t", new java.util.Date(System.currentTimeMillis()));
        resultMap.put(SysConstant._JSON_RETURN_DATA, data);
        resultMap.put(SysConstant._JSON_RETURN_RSPHEADER, rspHeader);
        return resultMap;
    }

    public void setExceptionInfo(String msg, Object data) {
        resultMap = new HashMap<String, Object>();
        rspHeader.setRspCode(SysConstant._JSON_RETURN_RSPCODE_EXCEPTION);
        rspHeader.setRspMsg(msg);
        resultMap.put("t", new java.util.Date(System.currentTimeMillis()));
        resultMap.put(SysConstant._JSON_RETURN_RSPHEADER, rspHeader);
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public Map<String, Object> getResultMap(Object data) {
        putData(data);
        return resultMap;
    }

    public Map<String, Object> getResultKVMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        putData(map);
        return resultMap;
    }

    public Map<String, Object> getResultMap(Object data, Page page) {
        putData(data);
        putPage(page);
        return resultMap;
    }

    public Map<String, Object> getSuccessMap() {
        putData("success");
        return resultMap;
    }

    public Map<String, Object> getExceptionMap() {
        setExceptionInfo(SysConstant._RETURN_RSPMSG_ERR, null);
        return resultMap;
    }

    public Map<String, Object> getExceptionMap(String expMsg) {
        setExceptionInfo(expMsg, null);
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    public String getErrJsp(HttpServletRequest request, String errMsg) {
        request.setAttribute("error", errMsg);
        return "redirect:/error.jsp";
    }

    public MultipartHttpServletRequest getMultiRequest(HttpServletRequest request) {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            return (MultipartHttpServletRequest) request;
        }
        return null;
    }

    public static Integer getSessionUid(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(SysConstant.CURRENT_USER);
        if (user == null) {
            return null;
        } else {
            return user.getId();
        }
    }

    public static User getSessionUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(SysConstant.CURRENT_USER);
    }

    public Map<String, Object> getValidErrMsg(BindingResult result) {
        String errMsg = null;
        Object errData = null;
        for (ObjectError error : result.getAllErrors()) {
            errMsg = error.getDefaultMessage();
            errData = error.getObjectName();
            break;
        }
        return getFailResultMap(errMsg);
    }

    class RspHeader {
        private String rspCode;
        private String rspMsg;

        public String getRspCode() {
            return rspCode;
        }

        public void setRspCode(String rspCode) {
            this.rspCode = rspCode;
        }

        public String getRspMsg() {
            return rspMsg;
        }

        public void setRspMsg(String rspMsg) {
            this.rspMsg = rspMsg;
        }
    }

    public Map<String, Object> getAuthFail() {
        log.info("resource auth fail");
        setFailInfo("auth fail", null);
        return getResultMap();
    }
}
