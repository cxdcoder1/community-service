package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.ExZyOwnerRoom;
import com.example.community.dto.InterCationAndOwner;
import com.example.community.dto.ZyOwnerRoomDto;
import com.example.community.entity.ZyOwner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 业主 (ZyOwner)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyOwnerService extends IService<ZyOwner> {

    /**
     * 更新业主身份证号
     * @param zyOwner
     * @return
     */
    Integer updateIdCard(ZyOwner zyOwner);

    /**
     * 根据身份证号查询业主
     * @param idCard
     * @return
     */
    ZyOwner getByIdCard(String idCard);

    /**
     * 根据openid获取业主信息
     * @param openId
     * @return
     */
    ZyOwner getByOpenId(String openId);

    Page<ZyOwnerRoomDto> zyOwnerRoomList(Page<ZyOwnerRoomDto> page, ZyOwnerRoomDto zyOwnerRoomDto, long id);


    Integer updateStatus(long ownerId);

    List<ExZyOwnerRoom> getzyOwnerRoomDtoList(List<String> list);

    InterCationAndOwner selectCommentByInteractionId(InterCationAndOwner interCationAndOwner);
}

