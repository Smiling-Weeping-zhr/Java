package com.cy.store.config;

import com.cy.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器拦截器的注册
 * */
@Configuration // 自动加载当前的拦截器并进行注册
public class LoginInterceptorConfig implements WebMvcConfigurer {
    // 自定义一个拦截器对象
    HandlerInterceptor interceptor = new LoginInterceptor();
    /**配置拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置白名单：存放在一个List集合
        List<String> patterns = new ArrayList<>();
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/products/**");
        //完成拦截器的注册
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")  //"/**"代表所有都要拦截
                .excludePathPatterns(patterns);   //表示要拦截的url是什么
        //配置白名单
    }
}
