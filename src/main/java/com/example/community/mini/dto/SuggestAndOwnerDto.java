package com.example.community.mini.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuggestAndOwnerDto {

    private String openId;
    /**
     * 投诉或者建议的图片
     */
    private List<String> imageUrls = new ArrayList<>();
    //id
    private Long complaintSuggestId;
    //小区id
    private Long communityId;
    //类型(投诉、建议)
    private String complaintSuggestType;
    //内容
    private String complaintSuggestContent;
    //创建者
    private String createBy;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape=JsonFormat. Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT")
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape=JsonFormat. Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date updateTime;
    //备注
    private String remark;
    //投诉人ID
    private Long userId;


    public SuggestAndOwnerDto() {
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Long getComplaintSuggestId() {
        return complaintSuggestId;
    }

    public void setComplaintSuggestId(Long complaintSuggestId) {
        this.complaintSuggestId = complaintSuggestId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getComplaintSuggestType() {
        return complaintSuggestType;
    }

    public void setComplaintSuggestType(String complaintSuggestType) {
        this.complaintSuggestType = complaintSuggestType;
    }

    public String getComplaintSuggestContent() {
        return complaintSuggestContent;
    }

    public void setComplaintSuggestContent(String complaintSuggestContent) {
        this.complaintSuggestContent = complaintSuggestContent;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SuggestAndOwnerDto{" +
                "openId='" + openId + '\'' +
                ", imageUrls=" + imageUrls +
                ", complaintSuggestId=" + complaintSuggestId +
                ", communityId=" + communityId +
                ", complaintSuggestType='" + complaintSuggestType + '\'' +
                ", complaintSuggestContent='" + complaintSuggestContent + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                ", userId=" + userId +
                '}';
    }

    public SuggestAndOwnerDto(String openId, List<String> imageUrls, Long complaintSuggestId, Long communityId, String complaintSuggestType, String complaintSuggestContent, String createBy, Date createTime, String updateBy, Date updateTime, String remark, Long userId) {
        this.openId = openId;
        this.imageUrls = imageUrls;
        this.complaintSuggestId = complaintSuggestId;
        this.communityId = communityId;
        this.complaintSuggestType = complaintSuggestType;
        this.complaintSuggestContent = complaintSuggestContent;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.remark = remark;
        this.userId = userId;
    }
}
