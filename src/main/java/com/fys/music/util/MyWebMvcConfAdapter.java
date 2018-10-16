package com.fys.music.util;

import com.fys.music.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfAdapter implements WebMvcConfigurer {
    /**
     *  拦截器
     *      不拦截主页、登陆页面、登陆处理逻辑、注册及处理逻辑、忘记密码、修改密码
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/login", "/loginDeal", "/register", "/registerDeal", "/mailConf", "/verfCode", "/forgetPassword", "/forgetPasswordDeal", "/resetPassword", "/updatePassword", "/drawImage", "/css/**", "/js/**", "/auto/**", "/images/**");
    }
}
