package com.example.community.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 访客邀请 (ZyVisitor)表实体类
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@SuppressWarnings("serial")
public class ZyVisitor extends Model<ZyVisitor> {
    //id
    private Long visitorId;
    //小区id
    private Long communityId;
    //访客姓名
    private String visitorName;
    //访客手机号
    private String visitorPhoneNumber;
    //到访时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape=JsonFormat. Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date visitorDate;
    //创建人id
    private Long createById;
    //创建人openid
    private String createByOpenId;
    //创建者
    private String createBy;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    //备注
    private String remark;


    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorPhoneNumber() {
        return visitorPhoneNumber;
    }

    public void setVisitorPhoneNumber(String visitorPhoneNumber) {
        this.visitorPhoneNumber = visitorPhoneNumber;
    }

    public Date getVisitorDate() {
        return visitorDate;
    }

    public void setVisitorDate(Date visitorDate) {
        this.visitorDate = visitorDate;
    }

    public Long getCreateById() {
        return createById;
    }

    public void setCreateById(Long createById) {
        this.createById = createById;
    }

    public String getCreateByOpenId() {
        return createByOpenId;
    }

    public void setCreateByOpenId(String createByOpenId) {
        this.createByOpenId = createByOpenId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.visitorId;
    }
    }

