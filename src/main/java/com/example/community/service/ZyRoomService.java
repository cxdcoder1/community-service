package com.example.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.RoomDto;
import com.example.community.dto.RoomStatus;
import com.example.community.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 房间 (ZyRoom)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
public interface ZyRoomService extends IService<ZyRoom> {

    List<RoomDto> getRoomList(long index,long size ,RoomDto roomDto);

    List<ZyCommunity> getCommunity();

    List<ZyBuilding> getBuilding(ZyRoom zyRoom);

    List<ZyUnit> getUnit(ZyRoom zyRoom);

    List<SysDictData> getroomStatus();

    List<SysDictData> getroomHouseType();

    int addRoom(ZyRoom zyRoom);

    int editRoom(ZyRoom zyRoom);

    int check(ZyRoom zyRoom);

    int deleteRoom(Long roomId);

    List<ZyRoom> getRoomList(List<String> list);

    int getRooms(List<String> list);

    int delRooms(List<String> list);

    int updRooms(long id);

    List<RoomStatus>roomList();

}

