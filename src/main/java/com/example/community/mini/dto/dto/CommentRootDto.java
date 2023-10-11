package com.example.community.mini.dto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 顶级评论的Dto
 */
public class CommentRootDto implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long commentId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long rootId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 评论内容
     */
    private String comment;
    /**
     * 创建人Id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createUserId;
    /**
     * 创建人昵称
     */
    private String createNickname;

    private String createAvatar;
    /**
     * 被回复人id
     */
    private Long parentUserId;
    /**
     * 被回复人昵称
     */
    private String parentUserNickname;
    /**
     * 被回复人头像
     */
    private String parentAvatar;

    private List<CommentRootDto> children = new ArrayList<>();

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateNickname() {
        return createNickname;
    }

    public void setCreateNickname(String createNickname) {
        this.createNickname = createNickname;
    }

    public String getCreateAvatar() {
        return createAvatar;
    }

    public void setCreateAvatar(String createAvatar) {
        this.createAvatar = createAvatar;
    }

    public Long getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(Long parentUserId) {
        this.parentUserId = parentUserId;
    }

    public String getParentUserNickname() {
        return parentUserNickname;
    }

    public void setParentUserNickname(String parentUserNickname) {
        this.parentUserNickname = parentUserNickname;
    }

    public String getParentAvatar() {
        return parentAvatar;
    }

    public void setParentAvatar(String parentAvatar) {
        this.parentAvatar = parentAvatar;
    }

    public List<CommentRootDto> getChildren() {
        return children;
    }

    public void setChildren(List<CommentRootDto> children) {
        this.children = children;
    }
}
