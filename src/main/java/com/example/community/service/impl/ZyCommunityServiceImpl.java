package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyCommunityDao;
import com.example.community.entity.SysPost;
import com.example.community.entity.ZyCommunity;
import com.example.community.service.ZyCommunityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 小区 (ZyCommunity)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("zyCommunityService")
public class ZyCommunityServiceImpl extends ServiceImpl<ZyCommunityDao, ZyCommunity> implements ZyCommunityService {

    @Resource
    private ZyCommunityDao zyCommunityDao;
    @Override
    public List<ZyCommunity> getCommunityList() {
        return zyCommunityDao.getCommunityList();
    }


}

