package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.CommunityAndDeptDto;
import com.example.community.dto.FeilsImgs;
import com.example.community.dto.InterCationAndOwner;
import com.example.community.entity.ZyCommunityInteraction;
import com.example.community.entity.ZyComplaintSuggest;
import com.example.community.entity.ZyFiles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 社区互动表(ZyCommunityInteraction)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyCommunityInteractionService extends IService<ZyCommunityInteraction> {

    Page<InterCationAndOwner> getInterCationAll(Page<InterCationAndOwner> page,InterCationAndOwner interCationAndOwner);

    int deleteByUserId(String id,String type);

    String getUserName(String parentId);

    List<InterCationAndOwner> getInterCationList(String interactionId);

    List<FeilsImgs> getFeilsUrl(String id);

    List<String> getRoomParentIds(List<String> id);

    int updCommentId(List<String> id);


}

