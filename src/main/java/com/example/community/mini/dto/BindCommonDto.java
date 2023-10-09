package com.example.community.mini.dto;

import com.example.community.mini.RoomStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class BindCommonDto implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long ownerRoomId;//绑定表中的Id
    private String buildingName;//楼栋名称

    private String unitName;//单元名称
    private String roomName;//房间名称

    private String ownerType;//业主类型

    private String applyDate;//申请时间

    private Date changeDate;//状态变更时间

    private RoomStatus roomStatus;//记录状态


    private String recordAuditOpinion;//审批意见


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

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRecordAuditOpinion() {
        return recordAuditOpinion;
    }

    public void setRecordAuditOpinion(String recordAuditOpinion) {
        this.recordAuditOpinion = recordAuditOpinion;
    }
}
