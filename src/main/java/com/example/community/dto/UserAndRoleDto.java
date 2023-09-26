package com.example.community.dto;

import com.example.community.entity.SysRole;
import com.example.community.entity.SysUser;
import com.example.community.entity.SysRole;
import com.example.community.entity.SysUser;

public class UserAndRoleDto {
    //用户ID
    private Long userId;

    //角色ID
    private Long roleId;

    //用户列表
    private SysUser sysUser;

    //角色列表
    private SysRole sysRole;


    public UserAndRoleDto() {
    }

    public UserAndRoleDto(Long userId, Long roleId, SysUser sysUser, SysRole sysRole) {
        this.userId = userId;
        this.roleId = roleId;
        this.sysUser = sysUser;
        this.sysRole = sysRole;
    }

    /**
     * 获取
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return roleId
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取
     * @return sysUser
     */
    public SysUser getSysUser() {
        return sysUser;
    }

    /**
     * 设置
     * @param sysUser
     */
    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    /**
     * 获取
     * @return sysRole
     */
    public SysRole getSysRole() {
        return sysRole;
    }

    /**
     * 设置
     * @param sysRole
     */
    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }

    @Override
    public String toString() {
        return "UserAndRoleDto{userId = " + userId + ", roleId = " + roleId + ", sysUser = " + sysUser + ", sysRole = " + sysRole + "}";
    }
}
