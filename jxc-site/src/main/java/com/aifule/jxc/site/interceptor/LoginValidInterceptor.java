package com.aifule.jxc.site.interceptor;


import com.aifule.jxc.core.domain.User;
import com.aifule.jxc.site.common.constant.SysConstant;
import com.aifule.jxc.site.common.util.PropertiesUtil;
import com.aifule.jxc.site.web.WebController;
import com.aifule.jxc.site.web.auth.LoginValid;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 这里就是配置登录拦截
 */
public class LoginValidInterceptor extends HandlerInterceptorAdapter {
    private String failPage;

    private Logger log = LoggerFactory.getLogger(LoginValidInterceptor.class);

//    private UrlFilterService urlFilterService;

    public String getFailPage() {
        return failPage;
    }

    public void setFailPage(String failPage) {
        this.failPage = failPage;
    }

    private void setFalseResponse(HttpServletResponse response, String msg) throws IOException {
        WebController webController = new WebController();
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(webController.getFailResultMap(msg)));
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        LoginValid annotation = method.getAnnotation(LoginValid.class);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SysConstant.USER_ID);
        String uri = request.getRequestURI();//不含问号后的带参部分
        if (annotation != null && "true".equals(PropertiesUtil.getValue("validLogin"))) {
            if (user == null) {
                log.info("用户未登录,跳转未登录页面");
                WebController web = new WebController();
                web.setFailInfo("用户未登录");
                web.setRspCode(SysConstant._JSON_RETURN_RSPCODE_LOGINFAIL);
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                response.getWriter().write(JSON.toJSONString(web.getResultMap()));
                response.sendRedirect(request.getContextPath() + " ../kaoqin/denglu.html");
                System.out.println("???");
                return false;
            }
        }


        if (!"true".equals(PropertiesUtil.getValue("validLogin")) && user == null) {
            User user1 = new User();
            user1.setId(1);
            request.getSession().setAttribute(SysConstant.USER_ID, user1);
            user = (User) request.getSession().getAttribute(SysConstant.USER_ID);
        }


        //register allowed logic
        if ("0".equals(PropertiesUtil.getValue("register.allowed"))) {
            if (uri.contains("register") || uri.contains("login")) {
                setFalseResponse(response, "无权访问该接口");
                return false;
            }
        }


//        if (urlFilterService == null) {
//            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
//            urlFilterService = (UrlFilterService) factory.getBean("urlFilterService");
//        }

        // 没有注解通过拦截
        return true;
    }

    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }
}