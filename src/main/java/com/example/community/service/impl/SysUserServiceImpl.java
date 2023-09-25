package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysUserDao;
import com.example.community.dto.UserAndDeptAndPostAndRole;
import com.example.community.dto.UserAndDeptAndRole;
import com.example.community.entity.SysDept;
import com.example.community.entity.SysPost;
import com.example.community.entity.SysRole;
import com.example.community.entity.SysUser;
import com.example.community.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Resource
    SysUserDao sysUserDao;

    @Override
    public UserAndDeptAndRole getUserInfo(int id) {
        return sysUserDao.getUserInfo(id);
    }

    @Override
    public int updateUser(SysUser sysUser) {
        return sysUserDao.updataUser(sysUser);
    }

    @Override
    public Page<UserAndDeptAndPostAndRole> selUserlist(Page<UserAndDeptAndPostAndRole> page, UserAndDeptAndPostAndRole userAndDeptAndPostAndRole) {
        // 获取满足条件的角色列表总数
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());

        long total = sysUserDao.count(userAndDeptAndPostAndRole);
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

        page.setRecords(sysUserDao.selUserlist((page.getCurrent()-1) * page.getSize(), page.getSize(), userAndDeptAndPostAndRole));
//        sysUserDao.selUserlist(page,sysUser);
        return page;

    }


    @Override
    public List<SysRole> getAllRole() {
        return sysUserDao.getAllRole();
    }

    @Override
    public List<SysPost> getAllPost() {
        return sysUserDao.getAllPost();
    }

    @Override
    public int updatePost(Long UserId, Long PostId) {
        int i = sysUserDao.updatePost(UserId, PostId);
        return i;
    }

    @Override
    public int updateRole(Long UserId, Long RoleId) {
        int i = sysUserDao.updateRole(UserId, RoleId);
        return i;
    }

    @Override
    public int insertUser(SysUser sysUser) {
        return sysUserDao.insertUser1(sysUser);
    }

    @Override
    public int insertPost(Long UserId, Long PostId) {
        return sysUserDao.insertPost(UserId,PostId);
    }

    @Override
    public int insertRole(Long UserId, Long RoleId) {
        return sysUserDao.insertRole(UserId,RoleId);
    }

    @Override
    public int isok(SysUser sysUser) {
        return sysUserDao.isAddUpdate(sysUser);
    }

    @Override
    public List<SysDept> selAllDept(SysDept sysDept) {
        return sysUserDao.getDeptList(sysDept);
    }

    @Override
    public int restUserPwd(int id, int pwd) {
        return sysUserDao.restUserPwd(id,pwd);
    }

    @Override
    public int upDataStatus(int id, String status) {
        return sysUserDao.upDataStatus(id,status);
    }


}

