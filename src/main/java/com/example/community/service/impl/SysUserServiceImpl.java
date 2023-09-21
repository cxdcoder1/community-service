package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysUserDao;
import com.example.community.dto.UserAndDeptAndRole;
import com.example.community.entity.SysUser;
import com.example.community.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public Page<SysUser> UserList(Page<SysUser> page, SysUser sysUser) {
        // 获取满足条件的角色列表总数
        long total = sysUserDao.selectUserList(0l,0l,sysUser).size();
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

        page.setRecords(sysUserDao.selectUserList((page.getCurrent()-1) * page.getSize(), page.getSize(), sysUser));
        return page;
    }
}

