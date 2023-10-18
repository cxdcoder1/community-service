package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.ZyComplaintSuggestDto;
import com.example.community.entity.ZyComplaintSuggest;
import com.example.community.entity.ZyVisitor;

import java.util.List;

/**
 * 投诉建议 (ZyComplaintSuggest)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyComplaintSuggestService extends IService<ZyComplaintSuggest> {
    Page<ZyComplaintSuggestDto> zyComplaintSuggestDtoList(Page<ZyComplaintSuggestDto> page, ZyComplaintSuggestDto zyComplaintSuggestDto, long id);

    Integer updateRemark(String remark,long id);

    List<ZyComplaintSuggest> getZyComplaintSuggest();
}

