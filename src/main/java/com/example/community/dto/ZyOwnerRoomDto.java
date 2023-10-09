package com.example.community.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhf
 */
@Getter
public class ZyOwnerRoomDto {
    //业主id
    @ColumnWidth(8)//单独设置列宽
    @ExcelProperty(index = 0, value = {"ID"})
    private Long ownerId;
    //昵称
    @ExcelProperty(index = 1, value = {"昵称"})
    private String ownerNickname;
    //真实姓名
    @ExcelProperty(index = 2, value = {"真实姓名"})
    private String ownerRealName;
    //性别unknow未知male男female女
    @ExcelProperty(index = 3, value = {"性别unknow未知male男female女"})
    private String ownerGender;
    //年龄
    @ExcelProperty(index = 4, value = {"年龄"})
    private Integer ownerAge;
    private Long ownerRoomId;
    //身份证号码
    @ExcelProperty(index = 5, value = {"身份证号码"})
    private String ownerIdCard;
    //手机号码
    @ExcelProperty(index = 6, value = {"手机号码"})
    private String ownerPhoneNumber;
    private String ownerOpenId;
    //微信号
    private String ownerWechatId;
    //qq号码
    private String ownerQqNumber;
    //出生日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ColumnWidth(19)//单独设置列宽
    @ExcelProperty(index = 7, value = {"出生日期"})
    private Date ownerBirthday;
    //头像
    private String ownerPortrait;
    //个性签名
    private String ownerSignature;
    //禁用状态enable启用-disable禁用
    private String ownerStatus;
    //注册方式（weChat微信-app-web）
    private String ownerLogonMode;
    //密码
    private String ownerPassword;
    //创建者
    private String createBy;
    //创建时间
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;
    //小区名称
    @ExcelProperty(index = 8, value = {"小区名称"})
    private String communityName;
    //单元名称
    @ExcelProperty(index = 9, value = {"单元名称"})
    private String unitName;
    //楼栋名称
    @ExcelProperty(index = 10, value = {"楼栋名称"})
    private String buildingName;
    //业主类型
    @ExcelProperty(index = 11, value = {"业主类型"})
    private String ownerType;
    //房间名称
    @ExcelProperty(index = 12, value = {"房间名称"})
    private String roomName;
    //小区id
    private String communityId;
    //房间id
    private Long roomId;
    //楼栋id
    private Long buildingId;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    //单元id
    private Long unitId;
    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }



    public Long getOwnerRoomId() {
        return ownerRoomId;
    }

    public void setOwnerRoomId(Long ownerRoomId) {
        this.ownerRoomId = ownerRoomId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerNickname() {
        return ownerNickname;
    }

    public void setOwnerNickname(String ownerNickname) {
        this.ownerNickname = ownerNickname;
    }

    public String getOwnerRealName() {
        return ownerRealName;
    }

    public void setOwnerRealName(String ownerRealName) {
        this.ownerRealName = ownerRealName;
    }

    public String getOwnerGender() {
        return ownerGender;
    }

    public void setOwnerGender(String ownerGender) {
        this.ownerGender = ownerGender;
    }

    public Integer getOwnerAge() {
        return ownerAge;
    }

    public void setOwnerAge(Integer ownerAge) {
        this.ownerAge = ownerAge;
    }

    public String getOwnerIdCard() {
        return ownerIdCard;
    }

    public void setOwnerIdCard(String ownerIdCard) {
        this.ownerIdCard = ownerIdCard;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public String getOwnerOpenId() {
        return ownerOpenId;
    }

    public void setOwnerOpenId(String ownerOpenId) {
        this.ownerOpenId = ownerOpenId;
    }

    public String getOwnerWechatId() {
        return ownerWechatId;
    }

    public void setOwnerWechatId(String ownerWechatId) {
        this.ownerWechatId = ownerWechatId;
    }

    public String getOwnerQqNumber() {
        return ownerQqNumber;
    }

    public void setOwnerQqNumber(String ownerQqNumber) {
        this.ownerQqNumber = ownerQqNumber;
    }

    public Date getOwnerBirthday() {
        return ownerBirthday;
    }

    public void setOwnerBirthday(Date ownerBirthday) {
        this.ownerBirthday = ownerBirthday;
    }

    public String getOwnerPortrait() {
        return ownerPortrait;
    }

    public void setOwnerPortrait(String ownerPortrait) {
        this.ownerPortrait = ownerPortrait;
    }

    public String getOwnerSignature() {
        return ownerSignature;
    }

    public void setOwnerSignature(String ownerSignature) {
        this.ownerSignature = ownerSignature;
    }

    public String getOwnerStatus() {
        return ownerStatus;
    }

    public void setOwnerStatus(String ownerStatus) {
        this.ownerStatus = ownerStatus;
    }

    public String getOwnerLogonMode() {
        return ownerLogonMode;
    }

    public void setOwnerLogonMode(String ownerLogonMode) {
        this.ownerLogonMode = ownerLogonMode;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwnerPassword() {
        return ownerPassword;
    }

    public void setOwnerPassword(String ownerPassword) {
        this.ownerPassword = ownerPassword;
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

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
