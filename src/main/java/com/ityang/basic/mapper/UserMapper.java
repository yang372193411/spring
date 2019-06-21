/*
 *
 * UserMapper.java
 * Copyright(C) 2017-2020 yang
 * @date 2018-12-18
 */
package com.ityang.basic.mapper;

import com.ityang.basic.entity.User;
import org.apache.ibatis.annotations.Mapper;

public interface UserMapper {
    /**
     * 根据主键删除数据库的记录,user
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新写入数据库记录,user
     *
     * @param record
     */
    int insert(User record);

    /**
     * 动态字段,写入数据库记录,user
     *
     * @param record
     */
    int insertSelective(User record);

    /**
     * 根据指定主键获取一条数据库记录,user
     *
     * @param id
     */
    User getUserById(String id);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录,user
     *
     * @param record
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据主键来更新符合条件的数据库记录,user
     *
     * @param record
     */
    int updateById(User record);

    /**
     * 根据userName查询用户
     *
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);

    /**
     * 根据phone查询用户
     *
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    String getId();
}