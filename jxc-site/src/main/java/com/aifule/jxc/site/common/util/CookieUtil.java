package com.aifule.jxc.site.common.util;

import com.aifule.jxc.site.common.constant.SysConstant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by libiao on 2016/5/26.
 */
public class CookieUtil {
    public static String getUserCookieValue(Cookie[] cookies) {
        if (cookies == null) return null;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(SysConstant.COOKIE_USER_NAME)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public static void updateUserCookie(HttpServletResponse response, String sessionId) {
        Cookie cookie = getUserCookie(sessionId, SysConstant.COOKIE_USER_MAX_AGE);
        response.addCookie(cookie);
    }

    public static void clearUserCookie(HttpServletResponse response, String sessionId) {
        Cookie cookie = getUserCookie(sessionId, 0);
        response.addCookie(cookie);
    }

    public static String genUUID() {
        return UUID.randomUUID().toString();
    }

    private static Cookie getUserCookie(String sessionId, int maxAge) {
        Cookie cookie = new Cookie(SysConstant.COOKIE_USER_NAME, sessionId);
        cookie.setDomain(SysConstant.COOKIE_USER_DOMAIN);
        cookie.setPath(SysConstant.COOKIE_USER_PATH);
        cookie.setMaxAge(maxAge);
        return cookie;
    }
}
