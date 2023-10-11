package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyComplaintSuggestDao;
import com.example.community.dto.ZyComplaintSuggestDto;
import com.example.community.entity.ZyComplaintSuggest;
import com.example.community.service.ZyComplaintSuggestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 投诉建议 (ZyComplaintSuggest)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("zyComplaintSuggestService")
public class ZyComplaintSuggestServiceImpl extends ServiceImpl<ZyComplaintSuggestDao, ZyComplaintSuggest> implements ZyComplaintSuggestService {

    @Resource
    private ZyComplaintSuggestDao zyComplaintSuggestDao;
    @Override
    public Page<ZyComplaintSuggestDto> zyComplaintSuggestDtoList(Page<ZyComplaintSuggestDto> page, ZyComplaintSuggestDto zyComplaintSuggestDto, long id) {
        long total = zyComplaintSuggestDao.count(zyComplaintSuggestDto, id);
        page.setTotal(total);
        int totalPages = (int) Math.ceil(total * 1.0 / page.getSize());
        if (page.getCurrent() > totalPages) {
            page.setCurrent(totalPages);
        }
        if(page.getCurrent()<=0){
            page.setCurrent(1);
        }
        page.setPages(totalPages);
        page.setRecords(zyComplaintSuggestDao.selectzyComplaintSuggestDto((page.getCurrent()-1)*page.getSize(),page.getSize(),zyComplaintSuggestDto,id));
        return page;
    }

    @Override
    public Integer updateRemark(String remark, long id) {
        return zyComplaintSuggestDao.updateRemark(remark,id);
    }
}

