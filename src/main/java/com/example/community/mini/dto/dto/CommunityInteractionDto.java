package com.example.community.mini.dto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommunityInteractionDto implements Serializable {

    private String openId;


    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long interactionId;

    @NotNull(message = "小区Id不能为空")
    private Long communityId;

    @NotBlank(message = "互动内容不能为空")
    private String content;


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    private List<String> imageUrls = new ArrayList<>();

    public Long getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(Long interactionId) {
        this.interactionId = interactionId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "CommunityInteractionDto{" +
                "interactionId=" + interactionId +
                ", communityId=" + communityId +
                ", content='" + content + '\'' +
                ", imageUrls=" + imageUrls +
                '}';
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
