package com.example.community.dto;

import lombok.Getter;

/**
 * @author zhf
 */
@Getter
public class RoomStatus {

    private  String roomStatus;

    private Integer roomNum;

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }
}
