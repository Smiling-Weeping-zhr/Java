package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

//自己写的测试类需要两个注解
//SpringBootTest:表示标注当前的类是一个测试类，不会随同项目一块打包
@SpringBootTest
//RunWith:表示启动这个单元测试类（不写，这个单元测试类是不能运行的），需要传递一个参数，必须是SpringRunner实例类型
@RunWith(SpringRunner.class)
public class UserMapperTests {
    //idea有检测的功能，接口是不能直接创建Bean对象（动态代理技术来解决）
    @Autowired
    private UserMapper userMapper;
    /**
     *满足一下四个方法，就可以成为单元测试方法，就可以独立运行，不用启动整个项目就可以做单元测试，提升了代码的
     * 测试效率
     * 1.必须被Test注解修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不能值定任何类型
     * 4.方法的访问修饰符必须是public
    */
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("abCd");
        user.setPhone("15726372668");
        user.setPassword("128");
        Integer rows =  userMapper.insert(user);
        System.out.println(rows);
    }
    @Test
    public void findByUserphone()
    {
        User user = userMapper.findByUserphone("15726372668");
        System.out.println(user);
    }
}
