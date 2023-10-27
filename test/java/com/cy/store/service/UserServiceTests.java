package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//自己写的测试类需要两个注解
//SpringBootTest:表示标注当前的类是一个测试类，不会随同项目一块打包
@SpringBootTest
//RunWith:表示启动这个单元测试类（不写，这个单元测试类是不能运行的），需要传递一个参数，必须是SpringRunner实例类型
@RunWith(SpringRunner.class)
public class UserServiceTests {
    //idea有检测的功能，接口是不能直接创建Bean对象（动态代理技术来解决）
    @Autowired
    private IUserService userService;
    /**
     *满足一下四个方法，就可以成为单元测试方法，就可以独立运行，不用启动整个项目就可以做单元测试，提升了代码的
     * 测试效率
     * 1.必须被Test注解修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不能值定任何类型
     * 4.方法的访问修饰符必须是public
    */
    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("trc");
            user.setPhone("15726372669");
            user.setPassword("124");
            userService.reg(user);
            System.out.println("Ok");
        } catch (ServiceException e) {
            //获取类的对象，在获取类的名称
            System.out.println(e.getClass().getSimpleName());
            // 获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
        User user = userService.login("15726372669" , "123");
        System.out.println(user);
    }
}
