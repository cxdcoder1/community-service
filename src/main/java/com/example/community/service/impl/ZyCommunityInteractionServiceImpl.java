package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyCommunityInteractionDao;
import com.example.community.entity.ZyCommunityInteraction;
import com.example.community.service.ZyCommunityInteractionService;
import org.springframework.stereotype.Service;

/**
 * 社区互动表(ZyCommunityInteraction)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("zyCommunityInteractionService")
public class ZyCommunityInteractionServiceImpl extends ServiceImpl<ZyCommunityInteractionDao, ZyCommunityInteraction> implements ZyCommunityInteractionService {

}

