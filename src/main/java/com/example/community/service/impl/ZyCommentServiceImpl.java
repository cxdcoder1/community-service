package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyCommentDao;
import com.example.community.dto.InterCationAndOwner;
import com.example.community.entity.ZyComment;
import com.example.community.service.ZyCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论表(ZyComment)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("zyCommentService")
public class ZyCommentServiceImpl extends ServiceImpl<ZyCommentDao, ZyComment> implements ZyCommentService {

    @Resource
    private ZyCommentDao zyCommentDao;

    @Override
    public List<InterCationAndOwner> getParentIds(String id) {
        return zyCommentDao.getParentIds(id);
    }

    @Override
    public int updDelFlag(String id) {
        return zyCommentDao.updDelFlag(id);
    }
}

