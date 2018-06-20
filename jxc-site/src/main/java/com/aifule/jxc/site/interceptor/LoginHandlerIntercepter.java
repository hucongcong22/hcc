package com.aifule.jxc.site.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandlerIntercepter implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1,
                             Object arg2) throws Exception {
        String requestURI = request.getRequestURI();

        //说明处在编辑的页面
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("_USER_ID");
        if (username != null) {
            //登陆成功的用户
            return true;
        } else {
            //没有登陆，转向登陆界面
            request.getRequestDispatcher("../kaoqin/denglu.html").forward(request, arg1);
            return false;
        }
    }
}
