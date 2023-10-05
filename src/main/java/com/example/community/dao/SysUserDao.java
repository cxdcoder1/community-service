package com.example.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.UserAndDeptAndPostAndRole;
import com.example.community.dto.UserAndDeptAndRole;
import com.example.community.dto.UserAndDeptImport;
import com.example.community.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 用户信息表(SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
public interface SysUserDao extends BaseMapper<SysUser> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysUser> entities);

    UserAndDeptAndRole getUserInfo(int id);

    int updataUser(@Param("sysUser") SysUser sysUser);

    List<SysPost> getAllPost();

    List<SysRole> getAllRole();

    int updatePost(Long UserId, Long PostId);

    int updateRole(Long UserId, Long RoleId);

    int insertUser1(SysUser sysUser);

    int insertPost(Long UserId, Long PostId);

    int insertRole(Long UserId, Long RoleId);

    int isAddUpdate(SysUser sysUser);

    //获取用户添加修改的部门
    List<SysDept> getDeptList(SysDept sysDept);

    List<UserAndDeptAndPostAndRole> selUserlist(@Param("index") Long index, @Param("size") Long size, @Param("sysUser") UserAndDeptAndPostAndRole userAndDeptAndPostAndRole);

    List<UserAndDeptAndPostAndRole> selUserlistByDeptS(@Param("index") Long index, @Param("size") Long size, @Param("sysUser") UserAndDeptAndPostAndRole userAndDeptAndPostAndRole);

    long count(UserAndDeptAndPostAndRole userAndDeptAndPostAndRole);

    long countByDepts(UserAndDeptAndPostAndRole userAndDeptAndPostAndRole);

    int restUserPwd(@Param("id") int id, @Param("pwd") Long pwd);

    int upDataStatus(@Param("id") int id, @Param("status") String status);

    List<UserAndDeptImport> getUserList(List<String> list);

    Integer deleteUsers(List<String> list);

    Integer delById(String id);

    Set<String> getNames();

    Set<String> getPhone();

    void batchInsert(List<UserAndDeptImport> list) throws Exception;

    SysPost getPostStatus(String id);

    List<String> getByDeptId(Long deptId);

}

