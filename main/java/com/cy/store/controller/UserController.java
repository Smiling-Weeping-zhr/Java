package com.cy.store.controller;

import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import com.cy.store.util.JsonResult;
import com.cy.store.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**注解的作用打抵是把Controller交给Spring来管理*/
//@Controller
@RestController // 组合注解：其作用相当于@Controller+ResponseBody
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;

    /**
     * 1.接收数据的方式：请求处理方法的数据列表设置为pojo类型来接收前端数据
     * SpringBoot会将前端的URL地址中的参数名和pojo类的属性名进行比较，如果这两个名称相同，则将pojo类中对应的属性
     * @param user
     * @return
     */
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<>(Okk);
    }
    /**
     * 1.接收数据的方式：请求处理方法的数据列表设置为String类型(非pojo类型)来接收前端数据
     * SpringBoot会直接将请求的参数名和方法的参数名直接进行比较如果名称相同，则自动完成值的的依赖注入
     */
    @RequestMapping("login")
    public JsonResult<User> login(String phone , String password) {
        User data = userService.login(phone , password);
        if(data != null){
            // 创建Token: token 保存user对象
            data.setToken(JwtUtil.getToken(data.getPhone() , data.getUid().toString()));
            //return new JsonResult<User>(Okk , data);
        }
        return new JsonResult<User>(Okk , data);
    }
    @RequestMapping("verify_token")
    public boolean verify_Token(String token){
        return JwtUtil.verify(token);
    }
    @RequestMapping("decode_token")
    public String decodeToken(HttpServletRequest request){
        String token = request.getHeader("token"); // key -> token
        return JwtUtil.decodeUser(token);
    }
//    @RequestMapping("reg")
//    // @ResponseBody // 表示此方法的响应结果以Json格式进行数据的响应给到前端
//    public JsonResult<Void> reg(User user)
//    {
//        //创建响应结果对象
//        JsonResult<Void> result = new JsonResult<>();
//        result.setState(200);
//        result.setMessage("用户注册成功");
//        try {
//            userService.reg(user);
//        } catch (UsernameDuplicatedException e) {
//            result.setState(4000);
//            result.setMessage("用户名被占用");
//        } catch (InsertException e) {
//            result.setState(5000);
//            result.setMessage("注册时产生未知的异常");
//        }
//        return result;
//    }
}
