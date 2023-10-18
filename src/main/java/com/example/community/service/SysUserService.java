package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.UserAndDeptAndPostAndRole;
import com.example.community.dto.UserAndDeptAndRole;
import com.example.community.dto.UserAndDeptImport;
import com.example.community.entity.*;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据分公司查询下面对应的员工
     * @param page
     * @param list
     * @return
     */
    Page<UserAndDeptAndPostAndRole> selUserListByP(Page<UserAndDeptAndPostAndRole> page, UserAndDeptAndPostAndRole userAndDeptAndPostAndRole);

    /**
     * 根据部门id查询子集部门
     * @return
     */
    List<String> getByDeptId(Long deptId);

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

    int restUserPwd(int id,String pwd);

    int upDataStatus( int id, String status);

    List<SysDictData> statusOption();
    /**
     * 获取用户导出的数据
     * @param list
     * @return
     */
    List<UserAndDeptImport> getUserList(List<String> list);

    Integer deleteUsers(List<String> list);

    Integer delById(String id);

    /**
     * 用户名验重
     * @param list
     * @return
     */
    Map<String,Object> checkUserName(List<UserAndDeptImport> list);

    /**
     * 电话号码验重
     * @param list
     * @return
     */
    Map<String,Object> checkPhone(List<UserAndDeptImport> list);

    /**
     * 批量插入
     * @param list
     */
    void batchInsert(List<UserAndDeptImport> list) throws Exception;

    SysPost getPostStatus(String id);

    SysUser getUserById(Long id);

}

