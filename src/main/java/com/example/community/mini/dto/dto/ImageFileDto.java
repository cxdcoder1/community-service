package com.example.community.mini.dto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * 图片文件Dto
 */
public class ImageFileDto implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long fileId;

    private String fileUrl;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
