package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysUserDao;
import com.example.community.entity.SysUser;
import com.example.community.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * 用户信息表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

}

