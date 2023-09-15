package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
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
}

