package com.example.community.mini.dto.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 评论请求的DTO
 */
public class CommentRequestDto implements Serializable {
    private String openId;
    @NotNull(message = "互动Id不能为空")
    private Long interactionId;
    @NotNull(message = "父Id不能为空")
    private Long parentId;
    @NotBlank(message = "评论内容不能为空")
    private String content;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 划属Id
     */

    private Long rootId;

    public Long getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(Long interactionId) {
        this.interactionId = interactionId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }
}
