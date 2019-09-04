/*
 *
 * User.java
 * Copyright(C) 2017-2020 yang
 * @date 2018-12-18
 */
package com.ityang.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @version 1.0
 * @Title user表的实体类
 * @Description 用户信息表
 * @Author yang
 * @Date 2018-12-18 14:18:37
 */
@Data
@TableName("USER")
public class User {
    /**
     * ID
     * 表字段 : user.id
     */
    @TableId(type = IdType.AUTO)
    private String id;

    /**
     * 用户名
     * 表字段 : user.userName
     */
    private String username;

    /**
     * 密码
     * 表字段 : user.passwd
     */
    private String passwd;

    /**
     * 性别
     * 表字段 : user.sex
     */
    private Integer sex;

    /**
     * 生日
     * 表字段 : user.birthday
     */
    private Date birthday;

    /**
     * 邮箱
     * 表字段 : user.email
     */
    private String email;

    /**
     * 手机号
     * 表字段 : user.phone
     */
    private String phone;

    /**
     * 职业
     * 表字段 : user.profession
     */
    private String profession;

    /**
     * 所属公司
     * 表字段 : user.company
     */
    private String company;

    /**
     * 地区
     * 表字段 : user.area
     */
    private String area;

    /**
     * 家乡
     * 表字段 : user.homeTown
     */
    private String hometown;

    /**
     * 血型
     * 表字段 : user.bloodType
     */
    private Integer bloodtype;

    /**
     * 是否实名认证
     * 表字段 : user.isConfirm
     */
    private String isconfirm;

    /**
     * 状态
     * 表字段 : user.status
     */
    private String status;

    /**
     * 积分
     * 表字段 : user.noun
     */
    private String noun;

    /**
     * 书币
     * 表字段 : user.money
     */
    private String money;

    /**
     * 备注
     * 表字段 : user.note
     */
    private String note;

    /**
     * 登陆名
     * 表字段 : user.loginName
     */
    private String loginname;
}