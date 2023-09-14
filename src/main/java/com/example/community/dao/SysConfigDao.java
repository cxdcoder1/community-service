package com.example.community.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.example.community.entity.SysConfig;

/**
 * 参数配置表(SysConfig)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
public interface SysConfigDao extends BaseMapper<SysConfig> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<SysConfig> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<SysConfig> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<SysConfig> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<SysConfig> entities);

}

