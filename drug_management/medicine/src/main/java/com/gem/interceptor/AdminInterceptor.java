package com.gem.interceptor;

import com.gem.entity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登陆拦截器
 */
public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("--拦截器---");
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if (admin != null) {
            return true;
        }
        //强制跳转到登陆页面...
        response.sendRedirect(request.getContextPath() + "/");
        return false;
    }
}
