package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyVisitorDao;
import com.example.community.entity.ZyVisitor;
import com.example.community.service.ZyVisitorService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 访客邀请 (ZyVisitor)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@Service("zyVisitorService")
public class ZyVisitorServiceImpl extends ServiceImpl<ZyVisitorDao, ZyVisitor> implements ZyVisitorService {

    @Resource
    private ZyVisitorDao zyVisitorDao;

    @Override
    public Page<ZyVisitor> zyVisitorList(Page<ZyVisitor> page, ZyVisitor zyVisitor, long id) {
        long total = zyVisitorDao.count(zyVisitor, id);
        page.setTotal(total);
        int totalPages = (int) Math.ceil(total * 1.0 / page.getSize());
        if (page.getCurrent() > totalPages) {
            page.setCurrent(totalPages);
        }
        if(page.getCurrent()<=0){
            page.setCurrent(1);
        }
        page.setPages(totalPages);
        page.setRecords(zyVisitorDao.selectZyVisitor((page.getCurrent()-1)*page.getSize(),page.getSize(),zyVisitor,id));
        return page;
    }

    @Override
    public Integer updateRemark(long id) {
        return zyVisitorDao.updateRemark(id);
    }

    @Override
    public Integer updateRemarks(long id) {
        return zyVisitorDao.updateRemarks(id);
    }
}

