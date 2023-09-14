package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyComplaintSuggestDao;
import com.example.community.entity.ZyComplaintSuggest;
import com.example.community.service.ZyComplaintSuggestService;
import org.springframework.stereotype.Service;

/**
 * 投诉建议 (ZyComplaintSuggest)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("zyComplaintSuggestService")
public class ZyComplaintSuggestServiceImpl extends ServiceImpl<ZyComplaintSuggestDao, ZyComplaintSuggest> implements ZyComplaintSuggestService {

}

