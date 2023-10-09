package com.example.community.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhf
 */
public class ExZyOwnerRoom {
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
    @ExcelProperty(index = 5, value = {"身份证号码"})
    private String ownerIdCard;
    //手机号码
    @ExcelProperty(index = 6, value = {"手机号码"})
    private String ownerPhoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ColumnWidth(19)//单独设置列宽
    @ExcelProperty(index = 7, value = {"出生日期"})
    private Date ownerBirthday;
    @ExcelProperty(index = 8, value = {"小区名称"})
    private String communityName;

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

    public Date getOwnerBirthday() {
        return ownerBirthday;
    }

    public void setOwnerBirthday(Date ownerBirthday) {
        this.ownerBirthday = ownerBirthday;
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

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

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
}
