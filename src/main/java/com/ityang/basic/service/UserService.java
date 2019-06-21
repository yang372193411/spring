package com.ityang.basic.service;

import com.ityang.basic.entity.User;

public interface UserService {
    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    User getUserById(String id);

    /**
     * 根据userName查询用户
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);

    /**
     * 根据phone查询用户
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 保存user类
     * @param user
     * @return
     */
    int saveUser(User user);

    String test();
}
