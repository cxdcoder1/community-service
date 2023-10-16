package com.example.community.entity;

import cn.hutool.core.util.NumberUtil;
import lombok.Data;
import java.io.Serializable;

@Data
public class Mem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 内存总量
     */
    private double total;

    /**
     * 已用内存
     */
    private double used;

    /**
     * 剩余内存
     */
    private double free;

    public Mem() {
    }

    public Mem(long serialVersionUID, double total, double used, double free) {
        this.total = total;
        this.used = used;
        this.free = free;
    }

    public double getTotal() {
        return NumberUtil.div(total, (1024 * 1024 * 1024), 2);
    }

    public double getUsed() {
        return NumberUtil.div(used, (1024 * 1024 * 1024), 2);
    }


    public double getFree() {
        return NumberUtil.div(free, (1024 * 1024 * 1024), 2);
    }

    public double getUsage() {
        return NumberUtil.mul(NumberUtil.div(used, total, 4), 100);
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
     * @param used
     */
    public void setUsed(double used) {
        this.used = used;
    }

    /**
     * 设置
     * @param free
     */
    public void setFree(double free) {
        this.free = free;
    }

    public String toString() {
        return "Mem{serialVersionUID = " + serialVersionUID + ", total = " + total + ", used = " + used + ", free = " + free + "}";
    }
}
