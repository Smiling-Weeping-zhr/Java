package com.cy.store.service;

import com.cy.store.entity.User;

/**用户模块业务层接口*/
public interface IUserService {
    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void reg(User user);

    /**
     * 用户登录功能
     * @param phone 用户名
     * @param password 用户的密码
     * @return 当前匹配的用户数据，没有则返回null值
     */
    User login(String phone , String password);
}
