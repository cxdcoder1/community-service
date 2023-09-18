package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.SysRole;

import java.util.List;

/**
 * 角色信息表(SysRole)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
 
public interface SysRoleService extends IService<SysRole> {

    Page<SysRole> roleList(Page<SysRole> page, SysRole sysRole);


}

