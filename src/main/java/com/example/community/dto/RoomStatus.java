package com.example.community.dto;

import lombok.Getter;

/**
 * @author zhf
 */
@Getter
public class RoomStatus {

    private  String roomStatus;

    private String roomNum;

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
}
