package com.example.community.entity;

import cn.hutool.core.util.NumberUtil;
import lombok.Data;
import java.io.Serializable;

@Data
public class Cpu implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 核心数
     */
    private int cpuNum;

    /**
     * CPU总的使用率
     */
    private double total;

    /**
     * CPU系统使用率
     */
    private double sys;

    /**
     * CPU用户使用率
     */
    private double used;

    /**
     * CPU当前等待率
     */
    private double wait;

    /**
     * CPU当前空闲率
     */
    private double free;

    public Cpu() {
    }

    public Cpu(long serialVersionUID, int cpuNum, double total, double sys, double used, double wait, double free) {

        this.cpuNum = cpuNum;
        this.total = total;
        this.sys = sys;
        this.used = used;
        this.wait = wait;
        this.free = free;
    }


    public double getTotal() {
        return NumberUtil.round(NumberUtil.mul(total, 100), 2).doubleValue();
    }

    public double getSys() {
        return NumberUtil.round(NumberUtil.mul(sys / total, 100), 2).doubleValue();
    }

    public double getUsed() {
        return NumberUtil.round(NumberUtil.mul(used / total, 100), 2).doubleValue();
    }

    public double getWait() {
        return NumberUtil.round(NumberUtil.mul(wait / total, 100), 2).doubleValue();
    }

    public double getFree() {
        return NumberUtil.round(NumberUtil.mul(free / total, 100), 2).doubleValue();
    }


    /**
     * 获取
     * @return cpuNum
     */
    public int getCpuNum() {
        return cpuNum;
    }

    /**
     * 设置
     * @param cpuNum
     */
    public void setCpuNum(int cpuNum) {
        this.cpuNum = cpuNum;
    }

    /**
     * 设置
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * 设置
     * @param sys
     */
    public void setSys(double sys) {
        this.sys = sys;
    }

    /**
     * 设置
     * @param used
     */
    public void setUsed(double used) {
        this.used = used;
    }

    /**
     * 设置
     * @param wait
     */
    public void setWait(double wait) {
        this.wait = wait;
    }

    /**
     * 设置
     * @param free
     */
    public void setFree(double free) {
        this.free = free;
    }

    public String toString() {
        return "Cpu{serialVersionUID = " + serialVersionUID + ", cpuNum = " + cpuNum + ", total = " + total + ", sys = " + sys + ", used = " + used + ", wait = " + wait + ", free = " + free + "}";
    }
}