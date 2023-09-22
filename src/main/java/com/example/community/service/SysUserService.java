package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.UserAndDeptAndRole;
import com.example.community.entity.SysRole;
import com.example.community.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息表(SysUser)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface SysUserService extends IService<SysUser> {

    UserAndDeptAndRole getUserInfo(int id);

    int updateUser(SysUser sysUser);

    Page<SysUser> selUserlist(Page<SysUser> page,SysUser sysUser);

    int restUserPwd(int id,int pwd);

    int upDataStatus( int id, String status);
}

