package com.example.community.dto;

import java.util.Date;

public class OwnerRoomList {
    //小区名称
    private String communityName;
    //楼栋名称
    private String buildingName;
    //单元名称
    private String unitName;
    //房间号
    private String roomName;
    //业主姓名
    private String ownerRealName;
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
    //业主类型
    private String ownerType;
    //绑定状态（0审核中 1绑定 2审核失败）
    private String roomStatus;
    //创建者
    private String createBy;
    //创建时间
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;


    public OwnerRoomList() {
    }

    public OwnerRoomList(String communityName, String buildingName, String unitName, String roomName, String ownerRealName, String ownerRoomId, Long communityId, Long buildingId, Long unitId, Long roomId, Long ownerId, String ownerType, String roomStatus, String createBy, Date createTime, String updateBy, Date updateTime, String remark) {
        this.communityName = communityName;
        this.buildingName = buildingName;
        this.unitName = unitName;
        this.roomName = roomName;
        this.ownerRealName = ownerRealName;
        this.ownerRoomId = ownerRoomId;
        this.communityId = communityId;
        this.buildingId = buildingId;
        this.unitId = unitId;
        this.roomId = roomId;
        this.ownerId = ownerId;
        this.ownerType = ownerType;
        this.roomStatus = roomStatus;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.remark = remark;
    }

    /**
     * 获取
     * @return communityName
     */
    public String getCommunityName() {
        return communityName;
    }

    /**
     * 设置
     * @param communityName
     */
    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    /**
     * 获取
     * @return buildingName
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * 设置
     * @param buildingName
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    /**
     * 获取
     * @return unitName
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置
     * @param unitName
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * 获取
     * @return roomName
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * 设置
     * @param roomName
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * 获取
     * @return ownerRealName
     */
    public String getOwnerRealName() {
        return ownerRealName;
    }

    /**
     * 设置
     * @param ownerRealName
     */
    public void setOwnerRealName(String ownerRealName) {
        this.ownerRealName = ownerRealName;
    }

    /**
     * 获取
     * @return ownerRoomId
     */
    public String getOwnerRoomId() {
        return ownerRoomId;
    }

    /**
     * 设置
     * @param ownerRoomId
     */
    public void setOwnerRoomId(String ownerRoomId) {
        this.ownerRoomId = ownerRoomId;
    }

    /**
     * 获取
     * @return communityId
     */
    public Long getCommunityId() {
        return communityId;
    }

    /**
     * 设置
     * @param communityId
     */
    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    /**
     * 获取
     * @return buildingId
     */
    public Long getBuildingId() {
        return buildingId;
    }

    /**
     * 设置
     * @param buildingId
     */
    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * 获取
     * @return unitId
     */
    public Long getUnitId() {
        return unitId;
    }

    /**
     * 设置
     * @param unitId
     */
    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    /**
     * 获取
     * @return roomId
     */
    public Long getRoomId() {
        return roomId;
    }

    /**
     * 设置
     * @param roomId
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    /**
     * 获取
     * @return ownerId
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * 设置
     * @param ownerId
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 获取
     * @return ownerType
     */
    public String getOwnerType() {
        return ownerType;
    }

    /**
     * 设置
     * @param ownerType
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    /**
     * 获取
     * @return roomStatus
     */
    public String getRoomStatus() {
        return roomStatus;
    }

    /**
     * 设置
     * @param roomStatus
     */
    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    /**
     * 获取
     * @return createBy
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateBy
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String toString() {
        return "OwnerRoomList{communityName = " + communityName + ", buildingName = " + buildingName + ", unitName = " + unitName + ", roomName = " + roomName + ", ownerRealName = " + ownerRealName + ", ownerRoomId = " + ownerRoomId + ", communityId = " + communityId + ", buildingId = " + buildingId + ", unitId = " + unitId + ", roomId = " + roomId + ", ownerId = " + ownerId + ", ownerType = " + ownerType + ", roomStatus = " + roomStatus + ", createBy = " + createBy + ", createTime = " + createTime + ", updateBy = " + updateBy + ", updateTime = " + updateTime + ", remark = " + remark + "}";
    }
}
