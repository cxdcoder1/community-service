package com.example.community.mini.dto;

import org.springframework.format.annotation.DateTimeFormat;

public class OwnerRecordDto {

    //房屋绑定记录id
    private Long recordId;
    //房屋绑定id
    private String ownerRoomId;
    //小区id
    private Long communityId;
    //楼栋id
    private Long buildingId;
    //单元id
    private Long unitId;
    //房间id
    private Long roomId;
    //业主id
    private Long ownerId;
    //楼栋信息 单元信息 房间信息
    private String buildingName;
    private String unitName;
    private String roomName;
    //业主类型
    private String ownerType;
    //绑定状态（0审核中 1绑定 2审核失败,3解绑）
    private String roomStatus;
    //审核意见
    private String recordAuditOpinion;
    //审核人类型
    private String recordAuditType;
    //创建人id
    private Long createById;
    //创建者
    private String createBy;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String createTime;
    //更新者
    private String updateBy;
    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String updateTime;
    //备注
    private String remark;

    public OwnerRecordDto() {
    }

    public OwnerRecordDto(Long recordId, String ownerRoomId, Long communityId, Long buildingId, Long unitId, Long roomId, Long ownerId, String buildingName, String unitName, String roomName, String ownerType, String roomStatus, String recordAuditOpinion, String recordAuditType, Long createById, String createBy, String createTime, String updateBy, String updateTime, String remark) {
        this.recordId = recordId;
        this.ownerRoomId = ownerRoomId;
        this.communityId = communityId;
        this.buildingId = buildingId;
        this.unitId = unitId;
        this.roomId = roomId;
        this.ownerId = ownerId;
        this.buildingName = buildingName;
        this.unitName = unitName;
        this.roomName = roomName;
        this.ownerType = ownerType;
        this.roomStatus = roomStatus;
        this.recordAuditOpinion = recordAuditOpinion;
        this.recordAuditType = recordAuditType;
        this.createById = createById;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "OwnerRecordDto{" +
                "recordId=" + recordId +
                ", ownerRoomId='" + ownerRoomId + '\'' +
                ", communityId=" + communityId +
                ", buildingId=" + buildingId +
                ", unitId=" + unitId +
                ", roomId=" + roomId +
                ", ownerId=" + ownerId +
                ", buildingName='" + buildingName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", roomName='" + roomName + '\'' +
                ", ownerType='" + ownerType + '\'' +
                ", roomStatus='" + roomStatus + '\'' +
                ", recordAuditOpinion='" + recordAuditOpinion + '\'' +
                ", recordAuditType='" + recordAuditType + '\'' +
                ", createById=" + createById +
                ", createBy='" + createBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getOwnerRoomId() {
        return ownerRoomId;
    }

    public void setOwnerRoomId(String ownerRoomId) {
        this.ownerRoomId = ownerRoomId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRecordAuditOpinion() {
        return recordAuditOpinion;
    }

    public void setRecordAuditOpinion(String recordAuditOpinion) {
        this.recordAuditOpinion = recordAuditOpinion;
    }

    public String getRecordAuditType() {
        return recordAuditType;
    }

    public void setRecordAuditType(String recordAuditType) {
        this.recordAuditType = recordAuditType;
    }

    public Long getCreateById() {
        return createById;
    }

    public void setCreateById(Long createById) {
        this.createById = createById;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
