package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    private SysRoleDao sysRoleDao;


    @Resource
    private SysRoleDao roleMapper;



    @Override
    public Page<SysRole> roleList(Page<SysRole> page, SysRole sysRole) {

        page.setSize(page.getSize());
        page.setCurrent(page.getCurrent());

        int total = roleMapper.selectRoleList(0L,0L,sysRole).size();
        page.setTotal(total);
        //总页数
        int pages = (int) Math.ceil(page.getTotal() * 1.0 / page.getSize());
        if (page.getCurrent()>pages){
            page.setCurrent(pages);
        }
        page.setRecords(roleMapper.selectRoleList((page.getCurrent()-1)*page.getSize(),page.getSize(),sysRole));
        return page;
    }

    @Override
    public List<SysRole> selectRoleList(SysRole role) {
        return null;
    }


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

    @Override
    public List<SysRole> getDeriveList(List<String> list) {
        return sysRoleDao.getDeriveList(list);
    }

    @Override
    public Integer deleteRole(String roleId) {
        return sysRoleDao.deleteRole(roleId);
    }


}

