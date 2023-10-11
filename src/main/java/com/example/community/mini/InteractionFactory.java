package com.example.community.mini;

import com.example.community.dao.ZyOwnerDao;
import com.example.community.entity.ZyComment;
import com.example.community.entity.ZyCommunityInteraction;
import com.example.community.mini.dto.dto.CommentRequestDto;
import com.example.community.mini.dto.dto.CommunityInteractionDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class InteractionFactory {
    @Resource
    private ZyOwnerDao zyOwnerMapper;

    public ZyCommunityInteraction createByDto(CommunityInteractionDto dto){
        if (dto==null) return null;
        ZyCommunityInteraction zyCommunityInteraction = new ZyCommunityInteraction();
        zyCommunityInteraction.setInteractionId(System.currentTimeMillis());
        zyCommunityInteraction.setContent(dto.getContent());
        zyCommunityInteraction.setUserId(zyOwnerMapper.findOwnerIdByOpenId(dto.getOpenId()));
        zyCommunityInteraction.setCreateTime(new Date());
        zyCommunityInteraction.setCommunityId(dto.getCommunityId());
        return zyCommunityInteraction;
    }

    public ZyComment createComment(CommentRequestDto dto){
        if (dto==null) return null;
        ZyComment comment = new ZyComment();
        comment.setCommentId(System.currentTimeMillis());
        comment.setUserId(zyOwnerMapper.findOwnerIdByOpenId(dto.getOpenId()));
        comment.setContent(dto.getContent());
        comment.setInteractionId(dto.getInteractionId());
        comment.setParentId(dto.getParentId());
        comment.setCreateTime(new Date());
        comment.setRootId(dto.getRootId());
        return comment;
    }






}
