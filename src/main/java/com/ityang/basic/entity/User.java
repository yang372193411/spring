/*
 *
 * User.java
 * Copyright(C) 2017-2020 yang
 * @date 2018-12-18
 */
package com.ityang.basic.entity;

import java.util.Date;

/**
 * @version 1.0
 * @Title user表的实体类
 * @Description 用户信息表
 * @Author yang
 * @Date 2018-12-18 14:18:37
 */
public class User {
    /**
     * ID
     * 表字段 : user.id
     */
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

    /**
     * 获取 ID 字段:user.id
     *
     * @return user.id, ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 ID 字段:user.id
     *
     * @param id the value for user.id, ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 用户名 字段:user.userName
     *
     * @return user.userName, 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 用户名 字段:user.userName
     *
     * @param username the value for user.userName, 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取 密码 字段:user.passwd
     *
     * @return user.passwd, 密码
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * 设置 密码 字段:user.passwd
     *
     * @param passwd the value for user.passwd, 密码
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    /**
     * 获取 性别 字段:user.sex
     *
     * @return user.sex, 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置 性别 字段:user.sex
     *
     * @param sex the value for user.sex, 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取 生日 字段:user.birthday
     *
     * @return user.birthday, 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置 生日 字段:user.birthday
     *
     * @param birthday the value for user.birthday, 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取 邮箱 字段:user.email
     *
     * @return user.email, 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置 邮箱 字段:user.email
     *
     * @param email the value for user.email, 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取 手机号 字段:user.phone
     *
     * @return user.phone, 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置 手机号 字段:user.phone
     *
     * @param phone the value for user.phone, 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取 职业 字段:user.profession
     *
     * @return user.profession, 职业
     */
    public String getProfession() {
        return profession;
    }

    /**
     * 设置 职业 字段:user.profession
     *
     * @param profession the value for user.profession, 职业
     */
    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    /**
     * 获取 所属公司 字段:user.company
     *
     * @return user.company, 所属公司
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置 所属公司 字段:user.company
     *
     * @param company the value for user.company, 所属公司
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * 获取 地区 字段:user.area
     *
     * @return user.area, 地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置 地区 字段:user.area
     *
     * @param area the value for user.area, 地区
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取 家乡 字段:user.homeTown
     *
     * @return user.homeTown, 家乡
     */
    public String getHometown() {
        return hometown;
    }

    /**
     * 设置 家乡 字段:user.homeTown
     *
     * @param hometown the value for user.homeTown, 家乡
     */
    public void setHometown(String hometown) {
        this.hometown = hometown == null ? null : hometown.trim();
    }

    /**
     * 获取 血型 字段:user.bloodType
     *
     * @return user.bloodType, 血型
     */
    public Integer getBloodtype() {
        return bloodtype;
    }

    /**
     * 设置 血型 字段:user.bloodType
     *
     * @param bloodtype the value for user.bloodType, 血型
     */
    public void setBloodtype(Integer bloodtype) {
        this.bloodtype = bloodtype;
    }

    /**
     * 获取 是否实名认证 字段:user.isConfirm
     *
     * @return user.isConfirm, 是否实名认证
     */
    public String getIsconfirm() {
        return isconfirm;
    }

    /**
     * 设置 是否实名认证 字段:user.isConfirm
     *
     * @param isconfirm the value for user.isConfirm, 是否实名认证
     */
    public void setIsconfirm(String isconfirm) {
        this.isconfirm = isconfirm == null ? null : isconfirm.trim();
    }

    /**
     * 获取 状态 字段:user.status
     *
     * @return user.status, 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态 字段:user.status
     *
     * @param status the value for user.status, 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取 积分 字段:user.noun
     *
     * @return user.noun, 积分
     */
    public String getNoun() {
        return noun;
    }

    /**
     * 设置 积分 字段:user.noun
     *
     * @param noun the value for user.noun, 积分
     */
    public void setNoun(String noun) {
        this.noun = noun == null ? null : noun.trim();
    }

    /**
     * 获取 书币 字段:user.money
     *
     * @return user.money, 书币
     */
    public String getMoney() {
        return money;
    }

    /**
     * 设置 书币 字段:user.money
     *
     * @param money the value for user.money, 书币
     */
    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    /**
     * 获取 备注 字段:user.note
     *
     * @return user.note, 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置 备注 字段:user.note
     *
     * @param note the value for user.note, 备注
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * 获取 登陆名 字段:user.loginName
     *
     * @return user.loginName, 登陆名
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * 设置 登陆名 字段:user.loginName
     *
     * @param loginname the value for user.loginName, 登陆名
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }
}