package com.ityang.basic.service.impl;

import com.ityang.basic.entity.User;
import com.ityang.basic.mapper.UserMapper;
import com.ityang.basic.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper mapper;

    @Override
    public User getUserId(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }


}
