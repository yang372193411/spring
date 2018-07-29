/*
 *
 * UserMapper.java
 * Copyright(C) 2017-2020 yang
 * @date 2018-07-29
 */
package com.ityang.basic.mapper;

import com.ityang.basic.entity.User;

public interface UserMapper {
    /**
     * 根据主键删除数据库的记录,user
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新写入数据库记录,user
     *
     * @param record
     */
    int insert(User record);

    /**
     * 动态字段,写入数据库记录,user
     *
     * @param user
     */
    int insertSelective(User user);

    /**
     * 根据指定主键获取一条数据库记录,user
     *
     * @param id
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录,user
     *
     * @param user
     */
    int updateByPrimaryKeySelective(User user);

    /**
     * 根据主键来更新符合条件的数据库记录,user
     *
     * @param user
     */
    int updateByPrimaryKey(User user);
}