package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysRoleDao;
import com.example.community.dto.RolesAndMenuIds;
import com.example.community.entity.SysMenu;
import com.example.community.entity.SysRole;
import com.example.community.entity.SysRoleMenu;
import com.example.community.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

//    @Override
//    public Page<SysRole> roleList(Page<SysRole> page, SysRole sysRole) {
//        // 设置分页大小和当前页码
//        page.setSize(page.getSize());
//        page.setCurrent(page.getCurrent());
//
//        // 获取满足条件的角色列表总数
//        int total = roleMapper.selectRoleList(0L,0L,sysRole).size();
//        page.setTotal(total);
//
//        // 获取满足条件的角色列表，并设置到Page对象中
//        List<SysRole> roleList = roleMapper.selectRoleList((page.getCurrent()-1) * page.getSize(), page.getSize(), sysRole);
//        page.setRecords(roleList);
//
//        return page;
//    }

    @Override
    public Page<SysRole> roleList(Page<SysRole> page, SysRole sysRole) {
        // 获取满足条件的角色列表总数
        long total = roleMapper.count(sysRole);
        page.setTotal(total);

        // 计算总页数
        int totalPages = (int) Math.ceil(total * 1.0 / page.getSize());
        if (page.getCurrent() > totalPages) {
            page.setCurrent(totalPages);
        }

        if(page.getCurrent()<=0){
            page.setCurrent(1);
        }

        page.setPages(totalPages);

        page.setRecords(roleMapper.selectRoleList((page.getCurrent()-1) * page.getSize(), page.getSize(), sysRole));

        return page;
    }

    @Override
    public List<SysRole> selectRoleList(SysRole role) {
        return null;
    }


    @Override
    public Integer insertRole(RolesAndMenuIds rolesAndMenuIds) {
         sysRoleDao.insertRole(rolesAndMenuIds);
        System.err.println(rolesAndMenuIds.getRoleId());
        for (Object menuId : rolesAndMenuIds.getMenuIds()) {
            sysRoleDao.addMenu(rolesAndMenuIds.getRoleId(),menuId);
        }
        return 1;
    }

    /**
     * 验重角色名
     *
     * @param roleName
     * @return
     */
    @Override
    public SysRole selectRoleName(String roleName) {
        return sysRoleDao.selectRoleName(roleName);
    }

    @Override
    public int updateRole(RolesAndMenuIds rolesAndMenuIds) {
        sysRoleDao.updateRole(rolesAndMenuIds);
        sysRoleDao.deleteMenu(rolesAndMenuIds.getRoleId());
        for (Object menuId : rolesAndMenuIds.getMenuIds()) {
            System.err.println(rolesAndMenuIds.getRoleId());
            sysRoleDao.addMenu(rolesAndMenuIds.getRoleId(), menuId);

        }
        return 1;
    }

    @Override
    public List<SysMenu> getRoleMenuTreeselect(Integer roleId) {
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


    @Override
    public int upDataStatus(long roleId, String status) {
        return sysRoleDao.upDataStatus(roleId,status);
    }

    @Override
    public List<SysRoleMenu>  getMenuIds(Long roleId) {
        return sysRoleDao.getMenuIds(roleId);
    }

    @Override
    public SysRole getRoleById(Long id) {
        return sysRoleDao.selectRoleById(id);
    }

}

