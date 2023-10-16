package com.example.community.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class Sys implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 服务器名称
     */
    private String computerName;

    /**
     * 服务器Ip
     */
    private String computerIp;

    /**
     * 项目路径
     */
    private String userDir;

    /**
     * 操作系统
     */
    private String osName;

    /**
     * 系统架构
     */
    private String osArch;


    public Sys() {
    }

    public Sys(long serialVersionUID, String computerName, String computerIp, String userDir, String osName, String osArch) {

        this.computerName = computerName;
        this.computerIp = computerIp;
        this.userDir = userDir;
        this.osName = osName;
        this.osArch = osArch;
    }

    /**
     * 获取
     * @return computerName
     */
    public String getComputerName() {
        return computerName;
    }

    /**
     * 设置
     * @param computerName
     */
    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    /**
     * 获取
     * @return computerIp
     */
    public String getComputerIp() {
        return computerIp;
    }

    /**
     * 设置
     * @param computerIp
     */
    public void setComputerIp(String computerIp) {
        this.computerIp = computerIp;
    }

    /**
     * 获取
     * @return userDir
     */
    public String getUserDir() {
        return userDir;
    }

    /**
     * 设置
     * @param userDir
     */
    public void setUserDir(String userDir) {
        this.userDir = userDir;
    }

    /**
     * 获取
     * @return osName
     */
    public String getOsName() {
        return osName;
    }

    /**
     * 设置
     * @param osName
     */
    public void setOsName(String osName) {
        this.osName = osName;
    }

    /**
     * 获取
     * @return osArch
     */
    public String getOsArch() {
        return osArch;
    }

    /**
     * 设置
     * @param osArch
     */
    public void setOsArch(String osArch) {
        this.osArch = osArch;
    }

    public String toString() {
        return "Sys{serialVersionUID = " + serialVersionUID + ", computerName = " + computerName + ", computerIp = " + computerIp + ", userDir = " + userDir + ", osName = " + osName + ", osArch = " + osArch + "}";
    }
}