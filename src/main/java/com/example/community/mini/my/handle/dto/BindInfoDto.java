package com.example.community.mini.my.handle.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 绑定请求的信息
 */
public class BindInfoDto implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long ownerRoomId;

    private String buildingName;

    private String unitName;

    private String roomName;

    private String ownerRealName;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private Date applyDate;

    private String phoneNum;

    private String ownerType;


    public Long getOwnerRoomId() {
        return ownerRoomId;
    }

    public void setOwnerRoomId(Long ownerRoomId) {
        this.ownerRoomId = ownerRoomId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getOwnerRealName() {
        return ownerRealName;
    }

    public void setOwnerRealName(String ownerRealName) {
        this.ownerRealName = ownerRealName;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }
}
