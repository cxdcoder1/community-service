package com.example.community.mini;

import com.example.community.entity.ZyOwnerRoom;
import com.example.community.entity.ZyOwnerRoomRecord;
import com.example.community.mini.dto.BindCommonDto;
import com.example.community.mini.dto.BindDto;
import org.springframework.stereotype.Component;

/**
 * 绑定的工厂
 */
@Component
public class BindFactory {
    /**
     * 通过Dto创建 绑定信息
     * @param dto dto
     * @return 绑定信息
     */
    public ZyOwnerRoom createBindInfo(BindDto dto) {
        if (dto == null) return null;

        ZyOwnerRoom zyOwnerRoom = new ZyOwnerRoom();
        zyOwnerRoom.setBuildingId(dto.getBuildingId());
        zyOwnerRoom.setCommunityId(dto.getCommunityId());
        zyOwnerRoom.setUnitId(dto.getUnitId());
        zyOwnerRoom.setRoomId(dto.getRoomId());
        zyOwnerRoom.setOwnerId(dto.getOwnerId());
        zyOwnerRoom.setOwnerType(dto.getOwnerType());
        zyOwnerRoom.setRoomStatus(RoomStatus.Auditing+"");
        zyOwnerRoom.setCreateTime(null);
        return zyOwnerRoom;
    }

    /**
     * 通过绑定信息,创建记录
     * @param zyOwnerRoom 绑定信息
     * @return 记录
     */
    public ZyOwnerRoomRecord createBindRecord(ZyOwnerRoom zyOwnerRoom){
        if (zyOwnerRoom==null) return null;
        ZyOwnerRoomRecord record = new ZyOwnerRoomRecord();
        record.setOwnerRoomId(zyOwnerRoom.getOwnerRoomId());
        record.setCommunityId(zyOwnerRoom.getCommunityId());
        record.setBuildingId(zyOwnerRoom.getBuildingId());
        record.setUnitId(zyOwnerRoom.getUnitId());
        record.setRoomId(zyOwnerRoom.getRoomId());
        record.setOwnerId(zyOwnerRoom.getOwnerId());
        record.setOwnerType(zyOwnerRoom.getOwnerType());
        record.setRoomStatus(zyOwnerRoom.getRoomStatus());
        record.setCreateById(zyOwnerRoom.getOwnerId());
        record.setCreateTime(null);
        return record;
    }


    public BindCommonDto transFromOwnerRoom(ZyOwnerRoom zyOwnerRoom){
        if (zyOwnerRoom==null) return null;
        BindCommonDto bindCommonDto = new BindCommonDto();
        bindCommonDto.setApplyDate(zyOwnerRoom.getCreateTime());

        return bindCommonDto;

    }














}
