package com.example.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.SysUserRole;

import java.util.List;

/**
 * 用户和角色关联表(SysUserRole)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface SysUserRoleService extends IService<SysUserRole> {
    /**
     * 角色是否被分配
     * @param roleId
     * @return
     */
    List<SysUserRole> roleIsUsed(String roleId);

}

