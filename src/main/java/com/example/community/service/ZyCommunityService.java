package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.SysPost;
import com.example.community.entity.ZyCommunity;

import java.util.List;

/**
 * 小区 (ZyCommunity)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyCommunityService extends IService<ZyCommunity> {

    List<ZyCommunity> getCommunityList();



}

