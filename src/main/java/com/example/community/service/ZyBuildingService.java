package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.SysPost;
import com.example.community.entity.ZyBuilding;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.example.community.entity.ZyCommunity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 楼栋 (ZyBuilding)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyBuildingService extends IService<ZyBuilding> {

    Page<ZyBuilding> buildingList(Page<ZyBuilding> page, ZyBuilding zyBuilding,long id);

    Boolean addBuilding(ZyBuilding zyBuilding);

    Integer updateBuilding(ZyBuilding zyBuilding);

    Long selName(ZyBuilding zyBuilding);

    Long delBuilding(long id);

    Long getUnitName(long id);

    boolean deletesBuilding(@Param("ids") Long [] ids);

    /**
     * 获取要导出的岗位信息
     * @return
     */
    List<ZyBuilding> getBuildingList(List<String> list);

    List<ZyBuilding> selectName(String id);

    List<ZyBuilding> selectNames(List<String> id);

    /**
     * 获取楼栋信息
     * @param
     * @return
     */
    List<ZyBuilding> getUBuild(String communityId);

}

