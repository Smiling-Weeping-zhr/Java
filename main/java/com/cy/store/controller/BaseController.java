package com.cy.store.controller;

import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** 表示控制层类的基类*/
public class BaseController {
    /** 表示操作成功的状态码*/
    public static final int Okk = 200;

    //请求处理方法，这个方法的返回值需要传递给前端的数据
    //自动将异常对象传递给此方法的参数列表上
    //当项目中产生了异常，被统一拦截到此方法中，这个方法此时
    @ExceptionHandler(ServiceException.class)     //用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("电话号码已经被占用");
        }else if(e instanceof  ProductNotFoundException){
            result.setState(4006);
            result.setMessage("商品数据不存在的异常");
        }
        else if(e instanceof UserNotFoundException)
        {
            result.setState(5001);
            result.setMessage("用户数据不存在的异常");
        }else if(e instanceof PasswordNotMatchException)
        {
            result.setState(5002);
            result.setMessage("用户名的密码错误的异常");
        }else if(e instanceof InsertException)
        {
            result.setState(5000);
            result.setMessage("注册时产生未知的异常");
        } else if(e instanceof  CartNotFoundException)
        {
            result.setState(5003);
            result.setMessage("购物车数据不存在");
        }
        return result;
    }
}
