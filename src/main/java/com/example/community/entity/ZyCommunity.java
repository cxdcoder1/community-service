package com.example.community.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 小区 (ZyCommunity)表实体类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@SuppressWarnings("serial")
public class ZyCommunity extends Model<ZyCommunity> {

    //小区id
    private String communityId;
    //小区名称
    private String communityName;
    //小区编码
    private String communityCode;
    //省区划码
    private String communityProvenceCode;
    //市区划码
    private String communityCityCode;
    //区县区划码
    private String communityTownCode;
    //详细地址
    private String communityDetailedAddress;
    //经度
    private String communityLongitude;
    //纬度
    private String communityLatitude;
    //物业id
    private Long deptId;
    //排序
    private Integer communitySort;
    //创建者
    private String createBy;
    //创建时间
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;
    //交房数量
    private String roomNum;
    //楼栋数量
    private String buildNum;

    public String getBuildNum() {
        return buildNum;
    }

    public void setBuildNum(String buildNum) {
        this.buildNum = buildNum;
    }

    public ZyCommunity(String communityId, String communityName, String communityCode, String communityProvenceCode, String communityCityCode, String communityTownCode, String communityDetailedAddress, String communityLongitude, String communityLatitude, Long deptId, Integer communitySort, String createBy, Date createTime, String updateBy, Date updateTime, String remark, String roomNum) {
        this.communityId = communityId;
        this.communityName = communityName;
        this.communityCode = communityCode;
        this.communityProvenceCode = communityProvenceCode;
        this.communityCityCode = communityCityCode;
        this.communityTownCode = communityTownCode;
        this.communityDetailedAddress = communityDetailedAddress;
        this.communityLongitude = communityLongitude;
        this.communityLatitude = communityLatitude;
        this.deptId = deptId;
        this.communitySort = communitySort;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.remark = remark;
        this.roomNum = roomNum;
    }

    public ZyCommunity() {
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode;
    }

    public String getCommunityProvenceCode() {
        return communityProvenceCode;
    }

    public void setCommunityProvenceCode(String communityProvenceCode) {
        this.communityProvenceCode = communityProvenceCode;
    }

    public String getCommunityCityCode() {
        return communityCityCode;
    }

    public void setCommunityCityCode(String communityCityCode) {
        this.communityCityCode = communityCityCode;
    }

    public String getCommunityTownCode() {
        return communityTownCode;
    }

    public void setCommunityTownCode(String communityTownCode) {
        this.communityTownCode = communityTownCode;
    }

    public String getCommunityDetailedAddress() {
        return communityDetailedAddress;
    }

    public void setCommunityDetailedAddress(String communityDetailedAddress) {
        this.communityDetailedAddress = communityDetailedAddress;
    }

    public String getCommunityLongitude() {
        return communityLongitude;
    }

    public void setCommunityLongitude(String communityLongitude) {
        this.communityLongitude = communityLongitude;
    }

    public String getCommunityLatitude() {
        return communityLatitude;
    }

    public void setCommunityLatitude(String communityLatitude) {
        this.communityLatitude = communityLatitude;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Integer getCommunitySort() {
        return communitySort;
    }

    public void setCommunitySort(Integer communitySort) {
        this.communitySort = communitySort;
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

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
}


