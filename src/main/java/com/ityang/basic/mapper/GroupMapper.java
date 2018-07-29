/*
*
* GroupMapper.java
* Copyright(C) 2017-2020 yang
* @date 2018-07-29
*/
package com.ityang.basic.mapper;

import com.ityang.basic.entity.Group;

public interface GroupMapper {
    /**
     *  新写入数据库记录,group
     *
     * @param group
     */
    int insert(Group group);

    /**
     *  动态字段,写入数据库记录,group
     *
     * @param group
     */
    int insertSelective(Group group);
}