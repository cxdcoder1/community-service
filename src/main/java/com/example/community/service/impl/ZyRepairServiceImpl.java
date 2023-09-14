package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyRepairDao;
import com.example.community.entity.ZyRepair;
import com.example.community.service.ZyRepairService;
import org.springframework.stereotype.Service;

/**
 * 报修信息(ZyRepair)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@Service("zyRepairService")
public class ZyRepairServiceImpl extends ServiceImpl<ZyRepairDao, ZyRepair> implements ZyRepairService {

}

