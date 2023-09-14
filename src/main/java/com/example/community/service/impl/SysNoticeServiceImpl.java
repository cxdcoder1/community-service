package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysNoticeDao;
import com.example.community.entity.SysNotice;
import com.example.community.service.SysNoticeService;
import org.springframework.stereotype.Service;

/**
 * 通知公告表(SysNotice)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Service("sysNoticeService")
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeDao, SysNotice> implements SysNoticeService {

}

