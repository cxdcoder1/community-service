package com.example.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.RoomDto;
import com.example.community.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 房间 (ZyRoom)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
public interface ZyRoomDao extends BaseMapper<ZyRoom> {

    List<RoomDto> getRoomList(@Param("index")long index,@Param("size") long size,@Param("zyRoom") RoomDto roomDto);

    List<ZyCommunity> getCommunity();

    List<ZyBuilding> getBuilding(ZyRoom zyRoom);

    List<ZyUnit> getUnit(ZyRoom zyRoom);

    List<SysDictData> getroomStatus();

    List<SysDictData> getroomHouseType();

    int addRoom(ZyRoom zyRoom);

    int editRoom(ZyRoom zyRoom);

    int check(ZyRoom zyRoom);

    int deleteRoom(Long roomId);



}

