package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.UnitAndCommunityAndBuilding;
import com.example.community.dto.UserAndDeptAndPostAndRole;
import com.example.community.entity.SysDictData;
import com.example.community.entity.ZyRoom;
import com.example.community.entity.ZyUnit;

import java.util.List;

/**
 * 单元 (ZyUnit)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
public interface ZyUnitService extends IService<ZyUnit> {

    /**
     * 查询单元信息
     * @param page
     * @param
     * @return
     */
    Page<UnitAndCommunityAndBuilding> getUnitList(Page<UnitAndCommunityAndBuilding> page, UnitAndCommunityAndBuilding unitAndCommunityAndBuilding);

    Boolean checkUName(ZyUnit zyUnit);

    Boolean checkCode(ZyUnit zyUnit);

    Integer addUnit(ZyUnit zyUnit);

    Integer updateUnit(ZyUnit zyUnit);

    Integer delById(String id);

    List<ZyRoom> getByUnits(List<String> list);

    List<ZyRoom> getByUnit(String id);

    Integer delUnits(List<String> list);

    List<ZyUnit> getUnitsById(List<String> list);

    List<SysDictData>statusList(String id);
}

