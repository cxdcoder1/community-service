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

    public List<SysRole> selectRoleList(SysRole role);

    /**
     * 新增验重角色名
     * @param roleName
     * @return
     */
    public Integer selectRoleName(String roleName);

    public int updateRole(SysRole role);

    public List<SysMenu> getRoleMenuTreeselect(int roleId);

    /**
     * 获取要导出的角色信息
     * @return
     */
    List<SysRole> getDeriveList(List<String> list);

    /**
     * 删除
     * @param roleId
     * @return
     */
    Integer deleteRole(String roleId);



    public int upDataStatus(long roleId,String status);
}

