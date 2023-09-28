package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.SysPost;
import com.example.community.entity.ZyCommunity;
import com.example.community.dto.CommunityAndDeptDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import java.util.List;

import java.util.List;

/**
 * 小区 (ZyCommunity)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyCommunityService extends IService<ZyCommunity> {

    Page<CommunityAndDeptDto> getCommunity(Page<CommunityAndDeptDto> page,CommunityAndDeptDto communityAndDeptDto);

    long delCommunity(String id);

    List<ZyCommunity> getCommunityDeriveList(List<String> list);

    //批量删除
    int deleteCommunity(List<String> id);

    //新增
    int insCommunit(ZyCommunity zyCommunity);

    //查重
    List<ZyCommunity> selCommunityDerive(ZyCommunity zyCommunity);

    //修改
    int updCommunityDerive(ZyCommunity zyCommunity);

    int updCommunity(String communityId,String deptId);
    List<ZyCommunity> getCommunityList();

    List<ZyCommunity> selCommunityCity(ZyCommunity zyCommunity);

    /**
     * 获取小区信息
     * @return
     */
    List<ZyCommunity> getUCommunity();
}

