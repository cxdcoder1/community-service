package com.example.community.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.UnitAndCommunityAndBuilding;
import com.example.community.dto.UserAndDeptAndPostAndRole;
import com.example.community.entity.SysDictData;
import com.example.community.entity.ZyRoom;
import org.apache.ibatis.annotations.Param;
import com.example.community.entity.ZyUnit;

/**
 * 单元 (ZyUnit)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
public interface ZyUnitDao extends BaseMapper<ZyUnit> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ZyUnit> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ZyUnit> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ZyUnit> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ZyUnit> entities);

    List<UnitAndCommunityAndBuilding> getList(@Param("index") Long index, @Param("size") Long size,@Param("unit") UnitAndCommunityAndBuilding unitAndCommunityAndBuilding);

    ZyUnit checkUName(ZyUnit zyUnit);

    ZyUnit checkCode(ZyUnit zyUnit);

    Integer addUnit(ZyUnit zyUnit);

    Integer updateUnit(ZyUnit zyUnit);

    Integer delById(String id);

    List<ZyRoom> getByUnit(String id);

    Integer delUnits(List<String> list);

    List<ZyRoom> getByUnits(List<String> list);

    List<ZyUnit> getUnitsById(List<String> list);

    List<SysDictData>statusList(String id);

}

