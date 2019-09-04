/*
 *
 * UserMapper.java
 * Copyright(C) 2017-2020 yang
 * @date 2018-12-18
 */
package com.ityang.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ityang.basic.entity.User;

public interface UserMapper extends BaseMapper<User> {

    String getId();
}