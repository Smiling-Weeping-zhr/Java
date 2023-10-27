package com.cy.store.interceptor;

import com.cy.store.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

/** 定义一个拦截器 */

/**
 * preHandle:在调用所有处理请求的方法之前被自动调用执行的方法
 * postHandle:在ModelAndView对象返回之后被调用的方法
 * afterHandle:在整个请求所有关联的资源被执行完毕之后所执行的方法
 */
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 检测全局对象中是否有uid数据如果没有重定向到登录页面
     * @param request 请求对象
     * @param response  响应对象
     * @param handler  处理器（url+Controller：映射）
     * @return 如果返回值为true表示放行当前的请求，如果返回值为false则表示拦截当前请求
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String method = request.getMethod();
        if("OPTIONS".equalsIgnoreCase(method)){
            return true;
        }
        //HttpServletRequest对象来获取token对象
        String token = request.getHeader("token"); //必须把token放在请求头Header上
        if(!JwtUtil.verify(token)){
            //验证失败
            // 重定向：失败之后直接送到新的页面
            response.sendRedirect("/users/login");
            //结束后续调用
            return false;
        }
        //请求放行
        return true;
    }
}
