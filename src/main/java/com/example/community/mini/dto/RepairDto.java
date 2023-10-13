package com.example.community.mini.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairDto {

    private List<String> imageUrls = new ArrayList<>();
    //报修ID
    private Long repairId;
    //报修编号
    private String repairNum;
    //报修状态
    private String repairState;
    //派单时间
    private Date assignmentTime;
    //接单时间
    private Date receivingOrdersTime;
    //处理完成时间
    private Date completeTime;
    //取消时间
    private Date cancelTime;
    //期待上门时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape=JsonFormat. Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT")
    private Date doorTime;
    //分派人id
    private Long assignmentId;
    //处理人id
    private Long completeId;
    //处理人电话
    private String completePhone;
    //处理人姓名
    private String completeName;
    //备注
    private String remark;
    //创建者
    private String createBy;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape=JsonFormat. Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT")
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape=JsonFormat. Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT")
    private Date updateTime;
    //创建人id
    private Long userId;
    //删除状态0默认1删除
    private Integer delFlag;
    //报修内容
    private String repairContent;
    //小区ID
    private Long communityId;
    //详细地址
    private String address;

    @Override
    public String toString() {
        return "RepairDto{" +
                "imageUrls=" + imageUrls +
                ", repairId=" + repairId +
                ", repairNum='" + repairNum + '\'' +
                ", repairState='" + repairState + '\'' +
                ", assignmentTime=" + assignmentTime +
                ", receivingOrdersTime=" + receivingOrdersTime +
                ", completeTime=" + completeTime +
                ", cancelTime=" + cancelTime +
                ", doorTime=" + doorTime +
                ", assignmentId=" + assignmentId +
                ", completeId=" + completeId +
                ", completePhone='" + completePhone + '\'' +
                ", completeName='" + completeName + '\'' +
                ", remark='" + remark + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", userId=" + userId +
                ", delFlag=" + delFlag +
                ", repairContent='" + repairContent + '\'' +
                ", communityId=" + communityId +
                ", address='" + address + '\'' +
                '}';
    }

    public RepairDto() {
    }

    public RepairDto(List<String> imageUrls, Long repairId, String repairNum, String repairState, Date assignmentTime, Date receivingOrdersTime, Date completeTime, Date cancelTime, Date doorTime, Long assignmentId, Long completeId, String completePhone, String completeName, String remark, String createBy, Date createTime, String updateBy, Date updateTime, Long userId, Integer delFlag, String repairContent, Long communityId, String address) {
        this.imageUrls = imageUrls;
        this.repairId = repairId;
        this.repairNum = repairNum;
        this.repairState = repairState;
        this.assignmentTime = assignmentTime;
        this.receivingOrdersTime = receivingOrdersTime;
        this.completeTime = completeTime;
        this.cancelTime = cancelTime;
        this.doorTime = doorTime;
        this.assignmentId = assignmentId;
        this.completeId = completeId;
        this.completePhone = completePhone;
        this.completeName = completeName;
        this.remark = remark;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.userId = userId;
        this.delFlag = delFlag;
        this.repairContent = repairContent;
        this.communityId = communityId;
        this.address = address;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public String getRepairNum() {
        return repairNum;
    }

    public void setRepairNum(String repairNum) {
        this.repairNum = repairNum;
    }

    public String getRepairState() {
        return repairState;
    }

    public void setRepairState(String repairState) {
        this.repairState = repairState;
    }

    public Date getAssignmentTime() {
        return assignmentTime;
    }

    public void setAssignmentTime(Date assignmentTime) {
        this.assignmentTime = assignmentTime;
    }

    public Date getReceivingOrdersTime() {
        return receivingOrdersTime;
    }

    public void setReceivingOrdersTime(Date receivingOrdersTime) {
        this.receivingOrdersTime = receivingOrdersTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Date getDoorTime() {
        return doorTime;
    }

    public void setDoorTime(Date doorTime) {
        this.doorTime = doorTime;
    }

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Long getCompleteId() {
        return completeId;
    }

    public void setCompleteId(Long completeId) {
        this.completeId = completeId;
    }

    public String getCompletePhone() {
        return completePhone;
    }

    public void setCompletePhone(String completePhone) {
        this.completePhone = completePhone;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
