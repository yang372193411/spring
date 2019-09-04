package com.ityang.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
        return mapper.selectById(id);
    }

    /**
     * 根据userName查询用户
     *
     * @param phone±
     * @return
     */
    @Override
    public User getUserByPhone(String phone) {
        QueryWrapper<User> query = new QueryWrapper();
        query.eq("phone",phone);
        return mapper.selectOne(query);
    }

    /**
     * 根据phone查询用户
     *
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserName(String userName) {
        QueryWrapper<User> query = new QueryWrapper();
        query.eq("userName",userName);

        return mapper.selectOne(query);
    }


    public void updateByUserName(User user){
        UpdateWrapper<User> update = new UpdateWrapper<>();
        update.eq("userName",user.getUsername());
        mapper.update(user,update);
    }

    /**
     * 保存user类
     *
     * @param user
     * @return
     */
    @Override
    public int saveUser(User user) {
        return mapper.insert(user);
    }

    @Override
    public String test() {
        return new String(mapper.getId());
    }
}
