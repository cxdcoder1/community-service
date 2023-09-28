package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyRoomDao;
import com.example.community.dto.RoomDto;
import com.example.community.entity.*;
import com.example.community.service.ZyRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 房间 (ZyRoom)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@Service("zyRoomService")
public class ZyRoomServiceImpl extends ServiceImpl<ZyRoomDao, ZyRoom> implements ZyRoomService {

    @Resource
    ZyRoomDao zyRoomDao;

    @Override
    public List<RoomDto> getRoomList(long index, long size,RoomDto roomDto) {
        return zyRoomDao.getRoomList(index,size,roomDto);
    }

    @Override
    public List<ZyCommunity> getCommunity() {
        return zyRoomDao.getCommunity();
    }

    @Override
    public List<ZyBuilding> getBuilding(ZyRoom zyRoom) {
        return zyRoomDao.getBuilding(zyRoom);
    }

    @Override
    public List<ZyUnit> getUnit(ZyRoom zyRoom) {
        return zyRoomDao.getUnit(zyRoom);
    }

    @Override
    public List<SysDictData> getroomStatus() {
        return zyRoomDao.getroomStatus();
    }

    @Override
    public List<SysDictData> getroomHouseType() {
        return zyRoomDao.getroomHouseType();
    }

    @Override
    public int addRoom(ZyRoom zyRoom) {
        return zyRoomDao.addRoom(zyRoom);
    }

    @Override
    public int editRoom(ZyRoom zyRoom) {
        return zyRoomDao.editRoom(zyRoom);
    }

    @Override
    public int check(ZyRoom zyRoom) {
        return zyRoomDao.check(zyRoom);
    }

    @Override
    public int deleteRoom(Long roomId) {
        return zyRoomDao.deleteRoom(roomId);
    }

    @Override
    public List<ZyRoom> getRoomList(List<String> list) {
        return null;
    }

    @Override
    public int getRooms(List<String> list) {
        return zyRoomDao.getRooms(list);
    }

    @Override
    public int delRooms(List<String> list) {
        return zyRoomDao.delRooms(list);
    }
}

