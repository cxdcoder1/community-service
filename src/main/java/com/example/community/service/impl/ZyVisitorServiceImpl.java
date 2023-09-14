package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyVisitorDao;
import com.example.community.entity.ZyVisitor;
import com.example.community.service.ZyVisitorService;
import org.springframework.stereotype.Service;

/**
 * 访客邀请 (ZyVisitor)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@Service("zyVisitorService")
public class ZyVisitorServiceImpl extends ServiceImpl<ZyVisitorDao, ZyVisitor> implements ZyVisitorService {

}

