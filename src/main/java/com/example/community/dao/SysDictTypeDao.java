package com.example.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.entity.SysDictType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典类型表(SysDictType)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
public interface SysDictTypeDao extends BaseMapper<SysDictType> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<SysDictType> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<SysDictType> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<SysDictType> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
    int insertOrUpdateBatch(@Param("entities") List<SysDictType> entities);

    public List<SysDictType> getDictOptionselect(Long dictId);

    List<SysDictType> selectDictType(@Param("index") Long index, @Param("size") Long size , @Param("sysDictType") SysDictType sysDictType);

    long count(@Param("sysDictType") SysDictType sysDictType);

    SysDictType  selectDictTypeName(@Param("name") String name);

    int updDictType(SysDictType sysDictType);

    List<SysDictType> selDictType(@Param("name") String name);

    int deleteDictType(@Param("id") List<Long> id);

    List<SysDictType> getDeriveList(List<String> list);
}

