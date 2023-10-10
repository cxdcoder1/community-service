package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyCommunityInteractionDao;
import com.example.community.dto.CommunityAndDeptDto;
import com.example.community.dto.InterCationAndOwner;
import com.example.community.entity.ZyCommunityInteraction;
import com.example.community.service.ZyCommunityInteractionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 社区互动表(ZyCommunityInteraction)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("zyCommunityInteractionService")
public class ZyCommunityInteractionServiceImpl extends ServiceImpl<ZyCommunityInteractionDao, ZyCommunityInteraction> implements ZyCommunityInteractionService {

    @Resource
    private ZyCommunityInteractionDao zyCommunityInteractionDao;

    @Override
    public Page<InterCationAndOwner> getInterCationAll(Page<InterCationAndOwner> page, InterCationAndOwner interCationAndOwner) {
        // 获取满足条件的角色列表总数
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        long total = zyCommunityInteractionDao.getCount(interCationAndOwner);

        page.setTotal(total);

        // 计算总页数
        int totalPages = (int) Math.ceil(total * 1.0 / page.getSize());
        if (page.getCurrent() > totalPages) {
            page.setCurrent(totalPages);
        }

        if (page.getCurrent() <= 0) {
            page.setCurrent(1);
        }

        page.setPages(totalPages);
        List<InterCationAndOwner> list =  zyCommunityInteractionDao.getInterCationAll((page.getCurrent()-1)*page.getSize(),page.getSize(),interCationAndOwner);

        System.err.println(list);
        page.setRecords(list);

        return page;
    }

    @Override
    public int deleteByUserId(String id, String type) {
        return zyCommunityInteractionDao.deleteByUserId(id,type);
    }

    @Override
    public List<InterCationAndOwner> getInterCationList(String interactionId) {
        return zyCommunityInteractionDao.getInterCationList(interactionId);
    }
}

