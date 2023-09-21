package com.example.community.entity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典类型表(SysDictType)表实体类
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
@SuppressWarnings("serial")
public class SysDictType extends Model<SysDictType> {
    private static final long serialVersionUID = 1L;
    //字典主键
    @ExcelProperty(index = 0, value = {"ID"})
    @TableId
    private Long dictId;
    //字典名称
    /** 字典名称 */
    @ExcelProperty(index = 1, value = {"角色名称"})
    private String dictName;
    //字典类型
    @ExcelProperty(index = 2, value = {"字典类型"})
    private String dictType;
    //状态（0正常 1停用）
    @ExcelProperty(index = 3, value = {"状态"})
    private String status;
    //创建者
    @ExcelIgnore
    private String createBy;
    //创建时间
    @ExcelProperty(index = 4, value = {"创建时间"})
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String createTime;
    //更新者
    @ExcelIgnore
    private String updateBy;
    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String updateTime;
    //备注
    @ExcelProperty(index = 5, value = {"备注"})
    private String remark;

    public SysDictType() {
    }


    public SysDictType(Long dictId, String dictName, String dictType, String status, String createBy, String createTime, String updateBy, String updateTime, String remark) {
        this.dictId = dictId;
        this.dictName = dictName;
        this.dictType = dictType;
        this.status = status;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.remark = remark;
    }

    /**
     * 获取
     * @return dictId
     */
    public Long getDictId() {
        return dictId;
    }

    /**
     * 设置
     * @param dictId
     */
    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    /**
     * 获取
     * @return dictName
     */
    public String getDictName() {
        return dictName;
    }

    /**
     * 设置
     * @param dictName
     */
    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    /**
     * 获取
     * @return dictType
     */
    public String getDictType() {
        return dictType;
    }

    /**
     * 设置
     * @param dictType
     */
    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    /**
     * 获取
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取
     * @return createBy
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateBy
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取
     * @return updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String toString() {
        return "SysDictType{dictId = " + dictId + ", dictName = " + dictName + ", dictType = " + dictType + ", status = " + status + ", createBy = " + createBy + ", createTime = " + createTime + ", updateBy = " + updateBy + ", updateTime = " + updateTime + ", remark = " + remark + "}";
    }
}

