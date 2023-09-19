package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.SysMenu;
import com.example.community.entity.SysRole;

import java.util.List;

/**
 * 角色信息表(SysRole)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
 
public interface SysRoleService extends IService<SysRole> {
    /**
     * 新增保存角色信息
     *
     * @param role 角色信息
     * @return 结果
     */
    public int insertRole(SysRole role);

    Page<SysRole> roleList(Page<SysRole> page, SysRole sysRole);

    public SysRole getRoleById(Long id);


    /**
     * 新增验重角色名
     * @param roleName
     * @return
     */
    public Integer selectRoleName(String roleName);

    public int updateRole(SysRole role);

    public List<SysMenu> getRoleMenuTreeselect(Long roleId);
}

