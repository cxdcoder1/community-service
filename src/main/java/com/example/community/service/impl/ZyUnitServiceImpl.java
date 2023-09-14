package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyUnitDao;
import com.example.community.entity.ZyUnit;
import com.example.community.service.ZyUnitService;
import org.springframework.stereotype.Service;

/**
 * 单元 (ZyUnit)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@Service("zyUnitService")
public class ZyUnitServiceImpl extends ServiceImpl<ZyUnitDao, ZyUnit> implements ZyUnitService {

}

