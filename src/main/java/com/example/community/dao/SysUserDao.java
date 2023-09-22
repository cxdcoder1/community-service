package com.example.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.UserAndDeptAndRole;
import com.example.community.entity.SysPost;
import com.example.community.entity.SysRole;
import com.example.community.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

}

