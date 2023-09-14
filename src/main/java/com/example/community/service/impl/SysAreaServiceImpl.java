package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysAreaDao;
import com.example.community.entity.SysArea;
import com.example.community.service.SysAreaService;
import org.springframework.stereotype.Service;

/**
 * 区域表(SysArea)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
@Service("sysAreaService")
public class SysAreaServiceImpl extends ServiceImpl<SysAreaDao, SysArea> implements SysAreaService {

}

