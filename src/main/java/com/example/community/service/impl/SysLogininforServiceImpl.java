package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysLogininforDao;
import com.example.community.entity.SysLogininfor;
import com.example.community.service.SysLogininforService;
import org.springframework.stereotype.Service;

/**
 * 系统访问记录(SysLogininfor)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Service("sysLogininforService")
public class SysLogininforServiceImpl extends ServiceImpl<SysLogininforDao, SysLogininfor> implements SysLogininforService {

}

