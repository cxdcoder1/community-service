package com.example.community.mini;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 评论对象 zy_comment
 * 
 * @author yin
 * @date 2020-12-18
 */
public class ZyCommentDto extends BaseEntity
{

    /** id */
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long commentId;

    /** 内容 */
    private String content;

    /** 父级ID */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    /** 删除状态0默认1删除 */
    private Integer delFlag;

    /** 社区互动ID */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long interactionId;

    /**创建人ID*/
    private Long userId;

    /**业主名称*/
    private String ownerName;

    /**业主头像*/
    private String ownerPortrait;

    /**业主姓名(被回复者姓名)*/
    private String passiveOwnerName;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPortrait() {
        return ownerPortrait;
    }

    public void setOwnerPortrait(String ownerPortrait) {
        this.ownerPortrait = ownerPortrait;
    }

    public String getPassiveOwnerName() {
        return passiveOwnerName;
    }

    public void setPassiveOwnerName(String passiveOwnerName) {
        this.passiveOwnerName = passiveOwnerName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCommentId(Long commentId)
    {
        this.commentId = commentId;
    }

    public Long getCommentId() 
    {
        return commentId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }
    public void setInteractionId(Long interactionId) 
    {
        this.interactionId = interactionId;
    }

    public Long getInteractionId() 
    {
        return interactionId;
    }

}
