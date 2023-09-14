package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysJobDao;
import com.example.community.entity.SysJob;
import com.example.community.service.SysJobService;
import org.springframework.stereotype.Service;

/**
 * 定时任务调度表(SysJob)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Service("sysJobService")
public class SysJobServiceImpl extends ServiceImpl<SysJobDao, SysJob> implements SysJobService {

}

