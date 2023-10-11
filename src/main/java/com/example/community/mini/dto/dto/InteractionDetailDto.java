package com.example.community.mini.dto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 交互详细Dto
 */
public class InteractionDetailDto implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long interactionId;

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    //内容
    private String content;
    //昵称
    private String nickname;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    //头像
    private String avatar;

    private List<ImageFileDto> imageUrls = new ArrayList<>();


    public Long getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(Long interactionId) {
        this.interactionId = interactionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<ImageFileDto> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<ImageFileDto> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
