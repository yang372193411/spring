package com.ityang.basic.service.impl;

import com.ityang.basic.controller.KafkaController;
import com.ityang.basic.entity.User;
import com.ityang.basic.mapper.UserMapper;
import com.ityang.basic.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Resource
    private UserMapper mapper;

    /**
     * 根据ID查询用户
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(String id) {
        return mapper.getUserById(id);
    }

    /**
     * 根据userName查询用户
     *
     * @param phone±
     * @return
     */
    @Override
    public User getUserByPhone(String phone) {
        return mapper.getUserByPhone(phone);
    }

    /**
     * 根据phone查询用户
     *
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserName(String userName) {
        return mapper.getUserByUserName(userName);
    }

    /**
     * 保存user类
     *
     * @param user
     * @return
     */
    @Override
    public int saveUser(User user) {
        int returnInt = -1;
        try {
            returnInt = mapper.insert(user);
        } catch (Exception e) {
            returnInt = 0;
            logger.error(e+"");
        } finally {
            return returnInt;
        }
    }

}
