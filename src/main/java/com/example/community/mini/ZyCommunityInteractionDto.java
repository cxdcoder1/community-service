package com.example.community.mini;

import com.baomidou.mybatisplus.annotation.TableId;
import com.example.community.entity.ZyFiles;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.List;

/**
 * 社区互动对象 zy_community_interaction
 *
 * @author yin
 * @date 2020-12-17
 */
public class ZyCommunityInteractionDto extends BaseEntity {

    /**
     * id
     */
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long interactionId;

    /**
     * 小区ID
     */
    private Long communityId;

    /**
     * 内容
     */
    private String content;

    /**
     * 图片ID
     */
    private String filesId;

    /**
     * 删除状态0默认1删除
     */
    private Integer delFlag;

    /**
     * 用户昵称
     */
    private String ownerNickname;

    /**
     * 用户真实姓名
     */
    private String ownerRealName;

    /**
     * 业主电话
     */
    private String ownerPhoneNumber;

    /**
     * 图片地址list
     */
    private List urlList;

    /**
     * 创建人ID
     */
    private Long userId;

    /**
     * 文件表
     */
    private ZyFiles[] zyFiles;

    /**
     * 评论表
     */
    private List<ZyCommentDto> zyCommentList;

    /**
     * 头像
     */
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<ZyCommentDto> getZyCommentList() {
        return zyCommentList;
    }

    public void setZyCommentList(List<ZyCommentDto> zyCommentList) {
        this.zyCommentList = zyCommentList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ZyFiles[] getZyFiles() {
        return zyFiles;
    }

    public void setZyFiles(ZyFiles[] zyFiles) {
        this.zyFiles = zyFiles;
    }

    public List getUrlList() {
        return urlList;
    }

    public void setUrlList(List urlList) {
        this.urlList = urlList;
    }

    public void setInteractionId(Long interactionId) {
        this.interactionId = interactionId;
    }

    public Long getInteractionId() {
        return interactionId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }

    public String getFilesId() {
        return filesId;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public String getOwnerNickname() {
        return ownerNickname;
    }

    public void setOwnerNickname(String ownerNickname) {
        this.ownerNickname = ownerNickname;
    }

    public String getOwnerRealName() {
        return ownerRealName;
    }

    public void setOwnerRealName(String ownerRealName) {
        this.ownerRealName = ownerRealName;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    @Override
    public String toString() {
        return "ZyCommunityInteractionDto{" +
                "interactionId=" + interactionId +
                ", communityId=" + communityId +
                ", content='" + content + '\'' +
                ", filesId='" + filesId + '\'' +
                ", delFlag=" + delFlag +
                ", ownerNickname='" + ownerNickname + '\'' +
                ", ownerRealName='" + ownerRealName + '\'' +
                ", ownerPhoneNumber='" + ownerPhoneNumber + '\'' +
                ", urlList=" + urlList +
                ", userId=" + userId +
                ", zyFiles=" + Arrays.toString(zyFiles) +
                '}';
    }
}
