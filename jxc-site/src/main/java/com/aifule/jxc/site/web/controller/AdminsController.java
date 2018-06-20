package com.aifule.jxc.site.web.controller;

import com.aifule.jxc.core.domain.Admins;
import com.aifule.jxc.site.service.AdminsService;
import com.aifule.jxc.site.web.WebController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AdminsController extends WebController {
    @Resource
    private AdminsService adminsService;

    /**
     * 登陆
     *
     * @param admins
     * @param httpSession
     * @return
     */

    @RequestMapping(value = "/adminsLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> Login(@RequestBody Admins admins, HttpSession httpSession) {
        boolean denlu = adminsService.login(admins, httpSession);
        return getResultMap(denlu);
    }

    /**
     * 修改密码
     *
     * @param admins
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/admins/xg", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> xg(@RequestBody Admins admins, HttpSession httpSession) {

        boolean xg1 = adminsService.xiougai(admins, httpSession);
        return getResultMap(xg1);
    }

    /**
     * 获取管理员姓名
     *
     * @param admins
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/admins/huq", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> huq(@RequestBody Admins admins, HttpSession httpSession) {
        Object name = httpSession.getAttribute("_ADMINS_ANAME");
        return getResultMap(name);
    }


    /**
     * 监听
     *
     * @param admins
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/admins/id", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> AdminsId(@RequestBody Admins admins, HttpSession httpSession) {
        if (httpSession.getAttribute("_ADMINS_ID") == null) {
            return getResultMap(false);
        } else {
            return getResultMap(true);
        }
    }

}
