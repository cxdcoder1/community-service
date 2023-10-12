package com.example.community.dto;

public class FeilsImgs {

    private String parentId;

    private String filesUrl;


    public FeilsImgs() {
    }

    public FeilsImgs(String parentId, String filesUrl) {
        this.parentId = parentId;
        this.filesUrl = filesUrl;
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

    public String toString() {
        return "FeilsImgs{parentId = " + parentId + ", filesUrl = " + filesUrl + "}";
    }
}
