package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.ZyOwnerRoomDto;
import com.example.community.entity.ZyBuilding;
import com.example.community.dto.CommunityAndDeptDto;
import com.example.community.dto.OwnerRoomList;
import com.example.community.entity.ZyOwnerRoom;
import com.example.community.mini.dto.OwnerRecordDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 房屋绑定表 (ZyOwnerRoom)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyOwnerRoomService extends IService<ZyOwnerRoom> {

    Page<OwnerRoomList> getRoomAll(Page<OwnerRoomList> page, OwnerRoomList ownerRoomList);



    int updOwnerRoom(String status,String id);

    /**
     * 根据小区id和业主id查询房屋绑定信息
     * @return
     */
    List<OwnerRecordDto> getRoomsByCommunityId(String communityId, String ownerId);
}

