/*
*
* User.java
* Copyright(C) 2017-2020 yang
* @date 2018-07-29
*/
package com.ityang.basic.entity;

/**
 * 用户表
 */
public class User {
    /**
     * ID
     * 表字段 : user.id
     */
    private Integer id;

    /**
     * 名称
     * 表字段 : user.name
     */
    private String name;

    /**
     * 密码
     * 表字段 : user.pass
     */
    private String pass;

    /**
     * 手机号
     * 表字段 : user.moble
     */
    private String moble;

    /**
     * 获取 ID 字段:user.id
     *
     * @return user.id, ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 ID 字段:user.id
     *
     * @param id the value for user.id, ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 名称 字段:user.name
     *
     * @return user.name, 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 名称 字段:user.name
     *
     * @param name the value for user.name, 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 密码 字段:user.pass
     *
     * @return user.pass, 密码
     */
    public String getPass() {
        return pass;
    }

    /**
     * 设置 密码 字段:user.pass
     *
     * @param pass the value for user.pass, 密码
     */
    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    /**
     * 获取 手机号 字段:user.moble
     *
     * @return user.moble, 手机号
     */
    public String getMoble() {
        return moble;
    }

    /**
     * 设置 手机号 字段:user.moble
     *
     * @param moble the value for user.moble, 手机号
     */
    public void setMoble(String moble) {
        this.moble = moble == null ? null : moble.trim();
    }
}