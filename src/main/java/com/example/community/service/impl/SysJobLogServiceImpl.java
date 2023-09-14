package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysJobLogDao;
import com.example.community.entity.SysJobLog;
import com.example.community.service.SysJobLogService;
import org.springframework.stereotype.Service;

/**
 * 定时任务调度日志表(SysJobLog)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Service("sysJobLogService")
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogDao, SysJobLog> implements SysJobLogService {

}

