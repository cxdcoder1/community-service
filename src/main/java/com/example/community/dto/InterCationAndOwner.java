package com.example.community.dto;

import com.example.community.entity.ZyComment;
import com.example.community.entity.ZyFiles;
import com.example.community.entity.ZyOwner;

import java.util.Date;

public class InterCationAndOwner {

    //id
    private Long interactionId;
    //小区ID
    private Long communityId;
    //创建人ID
    private String createBy;
    //更新者ID
    private String updateBy;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //内容
    private String content;
    //删除状态0默认1删除
    private Integer delFlag;
    //备注
    private String remark;
    //创建人ID
    private Long userId;
    //昵称
    private String ownerNickname;
    //真实姓名
    private String ownerRealName;
    //手机号码
    private String ownerPhoneNumber;
    //文件地址
    private String filesUrl;

    private String commentContent;

    private String commentOwnerNickname;

    private String commentId;

    private String commentCreateTime;

    private String parentId;

    public InterCationAndOwner() {
    }

    public InterCationAndOwner(Long interactionId, Long communityId, String createBy, String updateBy, Date createTime, Date updateTime, String content, Integer delFlag, String remark, Long userId, String ownerNickname, String ownerRealName, String ownerPhoneNumber, String filesUrl, String commentContent, String commentOwnerNickname, String commentId, String commentCreateTime, String parentId) {
        this.interactionId = interactionId;
        this.communityId = communityId;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.content = content;
        this.delFlag = delFlag;
        this.remark = remark;
        this.userId = userId;
        this.ownerNickname = ownerNickname;
        this.ownerRealName = ownerRealName;
        this.ownerPhoneNumber = ownerPhoneNumber;
        this.filesUrl = filesUrl;
        this.commentContent = commentContent;
        this.commentOwnerNickname = commentOwnerNickname;
        this.commentId = commentId;
        this.commentCreateTime = commentCreateTime;
        this.parentId = parentId;
    }

    /**
     * 获取
     * @return interactionId
     */
    public Long getInteractionId() {
        return interactionId;
    }

    /**
     * 设置
     * @param interactionId
     */
    public void setInteractionId(Long interactionId) {
        this.interactionId = interactionId;
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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取
     * @return delFlag
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置
     * @param delFlag
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
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

    /**
     * 获取
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return ownerNickname
     */
    public String getOwnerNickname() {
        return ownerNickname;
    }

    /**
     * 设置
     * @param ownerNickname
     */
    public void setOwnerNickname(String ownerNickname) {
        this.ownerNickname = ownerNickname;
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
     * @return ownerPhoneNumber
     */
    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    /**
     * 设置
     * @param ownerPhoneNumber
     */
    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    /**
     * 获取
     * @return filesUrl
     */
    public String getFilesUrl() {
        return filesUrl;
    }

    /**
     * 设置
     * @param filesUrl
     */
    public void setFilesUrl(String filesUrl) {
        this.filesUrl = filesUrl;
    }

    /**
     * 获取
     * @return commentContent
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 设置
     * @param commentContent
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    /**
     * 获取
     * @return commentOwnerNickname
     */
    public String getCommentOwnerNickname() {
        return commentOwnerNickname;
    }

    /**
     * 设置
     * @param commentOwnerNickname
     */
    public void setCommentOwnerNickname(String commentOwnerNickname) {
        this.commentOwnerNickname = commentOwnerNickname;
    }

    /**
     * 获取
     * @return commentId
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     * 设置
     * @param commentId
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取
     * @return commentCreateTime
     */
    public String getCommentCreateTime() {
        return commentCreateTime;
    }

    /**
     * 设置
     * @param commentCreateTime
     */
    public void setCommentCreateTime(String commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    /**
     * 获取
     * @return parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String toString() {
        return "InterCationAndOwner{interactionId = " + interactionId + ", communityId = " + communityId + ", createBy = " + createBy + ", updateBy = " + updateBy + ", createTime = " + createTime + ", updateTime = " + updateTime + ", content = " + content + ", delFlag = " + delFlag + ", remark = " + remark + ", userId = " + userId + ", ownerNickname = " + ownerNickname + ", ownerRealName = " + ownerRealName + ", ownerPhoneNumber = " + ownerPhoneNumber + ", filesUrl = " + filesUrl + ", commentContent = " + commentContent + ", commentOwnerNickname = " + commentOwnerNickname + ", commentId = " + commentId + ", commentCreateTime = " + commentCreateTime + ", parentId = " + parentId + "}";
    }
}
