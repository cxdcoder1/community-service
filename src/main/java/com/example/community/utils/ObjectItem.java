package com.example.community.utils;

import lombok.Data;

@Data
public class ObjectItem {
    private String objectName;
    private Long size;

    public ObjectItem() {
    }

    public ObjectItem(String objectName, Long size) {
        this.objectName = objectName;
        this.size = size;
    }

    /**
     * 获取
     * @return objectName
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * 设置
     * @param objectName
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    /**
     * 获取
     * @return size
     */
    public Long getSize() {
        return size;
    }

    /**
     * 设置
     * @param size
     */
    public void setSize(Long size) {
        this.size = size;
    }

    public String toString() {
        return "ObjectItem{objectName = " + objectName + ", size = " + size + "}";
    }
}
