package com.aifule.jxc.site.web.listener;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.aifule.jxc.core.domain.User;
import com.aifule.jxc.site.common.constant.SysConstant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.Hashtable;

public class SessionListener implements HttpSessionListener {
    private Logger log = LoggerFactory.getLogger(SessionListener.class);
    private static Hashtable<Integer, User> users = new Hashtable<Integer, User>();

    public void sessionCreated(HttpSessionEvent event) {
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
//        MessageService messageService = (MessageService)wac.getBean("messageService");

        HttpSession session = event.getSession();
        Object o = session.getAttribute(SysConstant.CURRENT_USER);
        if (o != null) {
            User user = (User) o;
            users.put(user.getId(), user);
//            messageService.initRedisMsgData(user.getId());
        }
//		else  if (!"true".equals(PropertiesUtil.getValue("validLogin"))) {
//			User user = new User();
//			user.setId(1);
//            user.setType(Constant.USER_TYPE_MOTHER);
//			user.setNickName("test");
//			session.setAttribute(SysConstant.CURRENT_USER, user);
////            messageService.initRedisMsgData(1);
//		}
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        // 获取存储管理员的session
        Object o = session.getAttribute(SysConstant.CURRENT_USER);
        if (o != null) {
            User user = (User) o;
            // 登陆的用户都存储在Hashtable中，用户退出，从Hashtable中删除该用户
            users.remove(user.getId());
            WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
//			MessageService messageService = (MessageService)wac.getBean("messageService");
            log.info("destroy message info start");
//			messageService.removeRedisMsgData(user.getId());
            log.info("destroy message info end");
        }
    }

    public static void addSession(User user) {
        if (user == null) return;

        users.put(user.getId(), user);
    }

    public static void removeSession(Integer uid) {
        if (uid == null) return;

        users.remove(uid);
    }

    public static void addTestSession(Integer uid) {
        User user = new User();
        user.setId(uid);
        users.put(uid, user);
    }
}
