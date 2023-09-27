package com.example.community.dto;

import com.example.community.entity.ZyBuilding;
import com.example.community.entity.ZyCommunity;

import java.util.Date;

public class UnitAndCommunityAndBuilding {

    //单元id
    private Long unitId;
    //小区id
    private Long communityId;
    //楼栋id
    private Long buildingId;
    //单元名称
    private String unitName;
    //单元编号
    private String unitCode;
    //层数
    private Integer unitLevel;
    //建筑面积
    private Double unitAcreage;
    //是否有电梯
    private String unitHaveElevator;
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

    //小区
    private ZyCommunity zyCommunity;

    //楼栋
    private ZyBuilding zyBuilding;



    @Override
    public String toString() {
        return "UnitAndCommunityAndBuilding{" +
                "unitId=" + unitId +
                ", communityId=" + communityId +
                ", buildingId=" + buildingId +
                ", unitName='" + unitName + '\'' +
                ", unitCode='" + unitCode + '\'' +
                ", unitLevel=" + unitLevel +
                ", unitAcreage=" + unitAcreage +
                ", unitHaveElevator='" + unitHaveElevator + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                ", zyCommunity=" + zyCommunity +
                ", zyBuilding=" + zyBuilding +
                '}';
    }

    public UnitAndCommunityAndBuilding() {
    }

    public UnitAndCommunityAndBuilding(Long unitId, Long communityId, Long buildingId, String unitName, String unitCode, Integer unitLevel, Double unitAcreage, String unitHaveElevator, String createBy, Date createTime, String updateBy, Date updateTime, String remark, ZyCommunity zyCommunity, ZyBuilding zyBuilding) {
        this.unitId = unitId;
        this.communityId = communityId;
        this.buildingId = buildingId;
        this.unitName = unitName;
        this.unitCode = unitCode;
        this.unitLevel = unitLevel;
        this.unitAcreage = unitAcreage;
        this.unitHaveElevator = unitHaveElevator;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.remark = remark;
        this.zyCommunity = zyCommunity;
        this.zyBuilding = zyBuilding;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public Integer getUnitLevel() {
        return unitLevel;
    }

    public void setUnitLevel(Integer unitLevel) {
        this.unitLevel = unitLevel;
    }

    public Double getUnitAcreage() {
        return unitAcreage;
    }

    public void setUnitAcreage(Double unitAcreage) {
        this.unitAcreage = unitAcreage;
    }

    public String getUnitHaveElevator() {
        return unitHaveElevator;
    }

    public void setUnitHaveElevator(String unitHaveElevator) {
        this.unitHaveElevator = unitHaveElevator;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public ZyCommunity getZyCommunity() {
        return zyCommunity;
    }

    public void setZyCommunity(ZyCommunity zyCommunity) {
        this.zyCommunity = zyCommunity;
    }

    public ZyBuilding getZyBuilding() {
        return zyBuilding;
    }

    public void setZyBuilding(ZyBuilding zyBuilding) {
        this.zyBuilding = zyBuilding;
    }
}
