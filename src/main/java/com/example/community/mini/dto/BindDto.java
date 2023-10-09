package com.example.community.mini.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 绑定的Dto
 */
public class BindDto implements Serializable {

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    private String openId;

    /** 小区id */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "社区Id不能为空")
    private Long communityId;

    /** 楼栋id */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "楼栋id不能为空")
    private Long buildingId;

    /** 单元id */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "单元id不能为空")
    private Long unitId;

    /** 房间id */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "房间id不能为空")
    private Long roomId;

    /** 业主id */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long ownerId;

    /** 业主类型 */
    @NotBlank(message = "业主类型不能为空")

    private String ownerType;

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

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }
}
