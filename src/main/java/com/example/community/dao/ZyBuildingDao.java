package com.example.community.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.entity.ZyCommunity;
import org.apache.ibatis.annotations.Param;
import com.example.community.entity.ZyBuilding;

/**
 * 楼栋 (ZyBuilding)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyBuildingDao extends BaseMapper<ZyBuilding> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ZyBuilding> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ZyBuilding> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ZyBuilding> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ZyBuilding> entities);

    List<ZyBuilding> selectName(@Param("id") String id);

    List<ZyBuilding> selectNames(@Param("id") List<String> id);


    List<ZyBuilding> selectBuild(@Param("index") Long index, @Param("size") Long size , @Param("zyBuilding") ZyBuilding zyBuilding,@Param("id")long id);

    long count(ZyBuilding zyBuilding,long id);

    /**
     * 新增
     * @param zyBuilding
     * @return
     */
    Integer addBuilding(ZyBuilding zyBuilding);

    Long getBuildingName(String buildingName,long communityId );

    Long selBuildingName(ZyBuilding zyBuilding);

    /**
     * 修改
     * @param zyBuilding
     * @return
     */
    Integer updateBuilding(ZyBuilding zyBuilding);

    /**
     * 单个删除
     * @param id
     * @return
     */
    Long delBuilding(long id);

    Long getUnitName(long id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    Long deletesBuilding(@Param("ids") Long [] ids);


    List<ZyBuilding> getBuildingList(List<String> list);

    List<ZyBuilding> getUBuild(String communityId);

}

