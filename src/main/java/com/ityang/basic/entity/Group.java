/*
*
* Group.java
* Copyright(C) 2017-2020 yang
* @date 2018-07-29
*/
package com.ityang.basic.entity;

/**
 * 组
 */
public class Group {
    /**
     * ID
     * 表字段 : group.ID
     */
    private String id;

    /**
     * 组名称
     * 表字段 : group.groupName
     */
    private String groupname;

    /**
     * 组备注
     * 表字段 : group.groupNote
     */
    private String groupnote;

    /**
     * 获取 ID 字段:group.ID
     *
     * @return group.ID, ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 ID 字段:group.ID
     *
     * @param id the value for group.ID, ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 组名称 字段:group.groupName
     *
     * @return group.groupName, 组名称
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * 设置 组名称 字段:group.groupName
     *
     * @param groupname the value for group.groupName, 组名称
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    /**
     * 获取 组备注 字段:group.groupNote
     *
     * @return group.groupNote, 组备注
     */
    public String getGroupnote() {
        return groupnote;
    }

    /**
     * 设置 组备注 字段:group.groupNote
     *
     * @param groupnote the value for group.groupNote, 组备注
     */
    public void setGroupnote(String groupnote) {
        this.groupnote = groupnote == null ? null : groupnote.trim();
    }
}