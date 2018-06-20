package com.aifule.jxc.site.web.controller;

import com.aifule.jxc.core.domain.Users;
import com.aifule.jxc.site.service.UsersService;
import com.aifule.jxc.site.web.WebController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UsersController extends WebController {
    @Resource
    private UsersService usersService;

    /**
     * 登陆
     *
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/usersLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> Login(@RequestBody Users users, HttpSession httpSession) {
        boolean login = usersService.login(users, httpSession);
        return getResultMap(login);
    }


    /**
     * 检查是否重名
     *
     * @param users
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/users/congmin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> reci(@RequestBody Users users, HttpSession httpSession) {
        boolean login = usersService.cass(users);
        return getResultMap(login);
    }

    /**
     * 注册
     *
     * @param users
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/users/registered", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> registered(@RequestBody Users users, HttpSession httpSession) {
        boolean login = usersService.registered(users, httpSession);
        return getResultMap(login);
    }

    /**
     * 取用户姓名
     *
     * @param httpSession
     * @return
     */

    @RequestMapping(value = "/users/uname", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uname(HttpSession httpSession) {
        Object uname = httpSession.getAttribute("_UNAME");
        return getResultMap(uname);
    }


    @RequestMapping(value = "/Users/id", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> UsersId(@RequestBody Users users, HttpSession httpSession) {
        if (httpSession.getAttribute("_UID") == null) {
            return getResultMap(false);
        } else {
            return getResultMap(true);
        }
    }
}
