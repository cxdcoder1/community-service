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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;

    @Override
    public String toString() {
        return "ZyCommunity{" +
                "communityId=" + communityId +
                ", communityName='" + communityName + '\'' +
                ", communityCode='" + communityCode + '\'' +
                ", communityProvenceCode='" + communityProvenceCode + '\'' +
                ", communityCityCode='" + communityCityCode + '\'' +
                ", communityTownCode='" + communityTownCode + '\'' +
                ", communityDetailedAddress='" + communityDetailedAddress + '\'' +
                ", communityLongitude='" + communityLongitude + '\'' +
                ", communityLatitude='" + communityLatitude + '\'' +
                ", deptId=" + deptId +
                ", communitySort=" + communitySort +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                '}';
    }

    public ZyCommunity() {
    }

    public ZyCommunity(String communityId, String communityName, String communityCode, String communityProvenceCode, String communityCityCode, String communityTownCode, String communityDetailedAddress, String communityLongitude, String communityLatitude, Long deptId, Integer communitySort, String createBy, Date createTime, String updateBy, Date updateTime, String remark) {
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
    }

    /**
     * 获取
     * @return communityId
     */
    public String getCommunityId() {
        return communityId;
    }

    /**
     * 设置
     * @param communityId
     */
    public void setCommunityId(String communityId) {
        this.communityId = communityId;
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
     * @return communityCode
     */
    public String getCommunityCode() {
        return communityCode;
    }

    /**
     * 设置
     * @param communityCode
     */
    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode;
    }

    /**
     * 获取
     * @return communityProvenceCode
     */
    public String getCommunityProvenceCode() {
        return communityProvenceCode;
    }

    /**
     * 设置
     * @param communityProvenceCode
     */
    public void setCommunityProvenceCode(String communityProvenceCode) {
        this.communityProvenceCode = communityProvenceCode;
    }

    /**
     * 获取
     * @return communityCityCode
     */
    public String getCommunityCityCode() {
        return communityCityCode;
    }

    /**
     * 设置
     * @param communityCityCode
     */
    public void setCommunityCityCode(String communityCityCode) {
        this.communityCityCode = communityCityCode;
    }

    /**
     * 获取
     * @return communityTownCode
     */
    public String getCommunityTownCode() {
        return communityTownCode;
    }

    /**
     * 设置
     * @param communityTownCode
     */
    public void setCommunityTownCode(String communityTownCode) {
        this.communityTownCode = communityTownCode;
    }

    /**
     * 获取
     * @return communityDetailedAddress
     */
    public String getCommunityDetailedAddress() {
        return communityDetailedAddress;
    }

    /**
     * 设置
     * @param communityDetailedAddress
     */
    public void setCommunityDetailedAddress(String communityDetailedAddress) {
        this.communityDetailedAddress = communityDetailedAddress;
    }

    /**
     * 获取
     * @return communityLongitude
     */
    public String getCommunityLongitude() {
        return communityLongitude;
    }

    /**
     * 设置
     * @param communityLongitude
     */
    public void setCommunityLongitude(String communityLongitude) {
        this.communityLongitude = communityLongitude;
    }

    /**
     * 获取
     * @return communityLatitude
     */
    public String getCommunityLatitude() {
        return communityLatitude;
    }

    /**
     * 设置
     * @param communityLatitude
     */
    public void setCommunityLatitude(String communityLatitude) {
        this.communityLatitude = communityLatitude;
    }

    /**
     * 获取
     * @return deptId
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置
     * @param deptId
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取
     * @return communitySort
     */
    public Integer getCommunitySort() {
        return communitySort;
    }

    /**
     * 设置
     * @param communitySort
     */
    public void setCommunitySort(Integer communitySort) {
        this.communitySort = communitySort;
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



}


