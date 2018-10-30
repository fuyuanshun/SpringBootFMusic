package com.fys.music.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 *  自定义拦截器
 */
public class MyInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 查看session中是否有数据
         */
        HttpSession httpSession = request.getSession();
        String username = (String)httpSession.getAttribute("username");
        if(null != username) {
            return true;
        }

        if(request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
            response.setHeader("REDIRECT", "REDIRECT");
            response.setHeader("CONTENTPATH", "localhost:8080/FMusic/login");
        }

        /**
         * 如果执行到这里说明需要身份验证
         */
        request.getServletContext().getRequestDispatcher("/login").forward(request, response);
        return false;
    }
}
