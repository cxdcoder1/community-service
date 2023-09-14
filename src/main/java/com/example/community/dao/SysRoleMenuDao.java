package com.example.community.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.example.community.entity.SysRoleMenu;

/**
 * 角色和菜单关联表(SysRoleMenu)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
public interface SysRoleMenuDao extends BaseMapper<SysRoleMenu> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<SysRoleMenu> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<SysRoleMenu> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<SysRoleMenu> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<SysRoleMenu> entities);

}

