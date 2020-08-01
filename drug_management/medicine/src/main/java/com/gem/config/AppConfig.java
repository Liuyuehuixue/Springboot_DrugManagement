package com.gem.config;

import com.gem.interceptor.AdminInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Springboot配置类
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
    /**
     * 配置默认跳转
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/register").setViewName("register");

    }

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/", "/admin/login","/admin/register","/register","/assets/**");
    }
}
