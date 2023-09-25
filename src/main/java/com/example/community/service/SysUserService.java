package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.UserAndDeptAndPostAndRole;
import com.example.community.dto.UserAndDeptAndRole;
import com.example.community.entity.*;
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

    Page<UserAndDeptAndPostAndRole> selUserlist(Page<UserAndDeptAndPostAndRole> page, UserAndDeptAndPostAndRole userAndDeptAndPostAndRole);

    List<SysRole> getAllRole();

    List<SysPost> getAllPost();

    int updatePost(Long UserId, Long PostId);

    int updateRole(Long UserId, Long RoleId);

    int insertUser(SysUser sysUser);

    int insertPost(Long UserId, Long PostId);

    int insertRole(Long UserId, Long RoleId);

    int isok(SysUser sysUser);
    //获取用户选择的部门列表
    List<SysDept> selAllDept(SysDept sysDept);

    int restUserPwd(int id,int pwd);

    int upDataStatus( int id, String status);

    List<SysDictData> statusOption();

}

