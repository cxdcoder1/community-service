package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysConfigDao;
import com.example.community.entity.SysConfig;
import com.example.community.service.SysConfigService;
import org.springframework.stereotype.Service;

/**
 * 参数配置表(SysConfig)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
@Service("sysConfigService")
public class SysConfigServiceImpl extends ServiceImpl<SysConfigDao, SysConfig> implements SysConfigService {

}

