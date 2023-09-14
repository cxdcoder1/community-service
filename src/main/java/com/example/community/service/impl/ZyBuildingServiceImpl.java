package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyBuildingDao;
import com.example.community.entity.ZyBuilding;
import com.example.community.service.ZyBuildingService;
import org.springframework.stereotype.Service;

/**
 * 楼栋 (ZyBuilding)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("zyBuildingService")
public class ZyBuildingServiceImpl extends ServiceImpl<ZyBuildingDao, ZyBuilding> implements ZyBuildingService {

}

