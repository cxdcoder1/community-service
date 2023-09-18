package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysRoleDao;
import com.example.community.entity.SysMenu;
import com.example.community.entity.SysRole;
import com.example.community.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import javax.annotation.Resource;

/**
 * 角色信息表(SysRole)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {


    @Resource
    private SysRoleDao roleMapper;

    @Override
    public List<SysRole> selectRoleList(SysRole role)
    {
        return roleMapper.selectRoleList(role);
    }

    @Resource
    private SysRoleDao sysRoleDao;

    /**
     * 新增角色
     * @param role 角色信息
     * @return
     */
    @Override
    public int insertRole(SysRole role) {
        return sysRoleDao.insertRole(role);
    }

    /**
     * 验重角色名
     * @param roleName
     * @return
     */
    @Override
    public Integer selectRoleName(String roleName) {
        return sysRoleDao.selectRoleName(roleName);
    }

    @Override
    public int updateRole(SysRole role) {
        return sysRoleDao.updateRole(role);
    }

    @Override
    public List<SysMenu> getRoleMenuTreeselect(int roleId) {
        return sysRoleDao.getRoleMenuTreeselect(roleId);
    }

}

