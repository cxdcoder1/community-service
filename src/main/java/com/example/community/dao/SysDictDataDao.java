package com.example.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.entity.SysDictData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典数据表(SysDictData)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
public interface SysDictDataDao extends BaseMapper<SysDictData> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictData> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysDictData> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictData> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysDictData> entities);

   int updDictType(@Param("type")String type,@Param("type2") String type2);
    public List<SysDictData> getData(@Param("sysDictData") SysDictData sysDictData, @Param("index") long index, @Param("size") long size);

    int updateData(SysDictData sysDictData);

    int removeDictById(Long id);

   List<SysDictData> selectDataName(@Param("name") List<String> name);

    List<SysDictData> selectDataName(String name);

    List<SysDictData> getDeriveList(List<String> list);

    int isAddUpdate(SysDictData sysDictData);

}

