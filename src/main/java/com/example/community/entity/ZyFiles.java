package com.example.community.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件管理(ZyFiles)表实体类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@SuppressWarnings("serial")
public class ZyFiles extends Model<ZyFiles> {
    //文件ID
    private Long filesId;
    //文件地址
    private String filesUrl;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape=JsonFormat. Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    private Date updateTime;
    //创建人者
    private String createBy;
    //删除状态0默认1删除
    private Integer delFlag;
    //来源0APP端，1PC端
    private Integer source;
    //备注
    private String remark;
    //父级ID
    private Long parentId;
    //创建人ID
    private Long userId;

    @Override
    public String toString() {
        return "ZyFiles{" +
                "filesId=" + filesId +
                ", filesUrl='" + filesUrl + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", createBy='" + createBy + '\'' +
                ", delFlag=" + delFlag +
                ", source=" + source +
                ", remark='" + remark + '\'' +
                ", parentId=" + parentId +
                ", userId=" + userId +
                '}';
    }

    public Long getFilesId() {
        return filesId;
    }

    public void setFilesId(Long filesId) {
        this.filesId = filesId;
    }

    public String getFilesUrl() {
        return filesUrl;
    }

    public void setFilesUrl(String filesUrl) {
        this.filesUrl = filesUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.filesId;
    }
    }

