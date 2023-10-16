package com.example.community.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class SysFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 盘符路径
     */
    private String dirName;

    /**
     * 盘符类型
     */
    private String sysTypeName;

    /**
     * 文件类型
     */
    private String typeName;

    /**
     * 总大小
     */
    private String total;

    /**
     * 剩余大小
     */
    private String free;

    /**
     * 已经使用量
     */
    private String used;

    /**
     * 资源的使用率
     */
    private double usage;


    public SysFile() {
    }

    public SysFile(long serialVersionUID, String dirName, String sysTypeName, String typeName, String total, String free, String used, double usage) {

        this.dirName = dirName;
        this.sysTypeName = sysTypeName;
        this.typeName = typeName;
        this.total = total;
        this.free = free;
        this.used = used;
        this.usage = usage;
    }

    /**
     * 获取
     * @return dirName
     */
    public String getDirName() {
        return dirName;
    }

    /**
     * 设置
     * @param dirName
     */
    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    /**
     * 获取
     * @return sysTypeName
     */
    public String getSysTypeName() {
        return sysTypeName;
    }

    /**
     * 设置
     * @param sysTypeName
     */
    public void setSysTypeName(String sysTypeName) {
        this.sysTypeName = sysTypeName;
    }

    /**
     * 获取
     * @return typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 获取
     * @return total
     */
    public String getTotal() {
        return total;
    }

    /**
     * 设置
     * @param total
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * 获取
     * @return free
     */
    public String getFree() {
        return free;
    }

    /**
     * 设置
     * @param free
     */
    public void setFree(String free) {
        this.free = free;
    }

    /**
     * 获取
     * @return used
     */
    public String getUsed() {
        return used;
    }

    /**
     * 设置
     * @param used
     */
    public void setUsed(String used) {
        this.used = used;
    }

    /**
     * 获取
     * @return usage
     */
    public double getUsage() {
        return usage;
    }

    /**
     * 设置
     * @param usage
     */
    public void setUsage(double usage) {
        this.usage = usage;
    }

    public String toString() {
        return "SysFile{serialVersionUID = " + serialVersionUID + ", dirName = " + dirName + ", sysTypeName = " + sysTypeName + ", typeName = " + typeName + ", total = " + total + ", free = " + free + ", used = " + used + ", usage = " + usage + "}";
    }
}