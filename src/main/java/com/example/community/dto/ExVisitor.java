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
public class ExVisitor {
    @ColumnWidth(8)//单独设置列宽
    @ExcelProperty(index = 0, value = {"ID"})
    //id
    private Long visitorId;
    //访客姓名
    @ExcelProperty(index = 1, value = {"访客姓名"})
    private String visitorName;
    //访客手机号
    @ExcelProperty(index = 2, value = {"访客手机号"})
    private String visitorPhoneNumber;
    @ExcelProperty(index = 3, value = {"小区名字"})
    private String communityName;
    //到访时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ColumnWidth(19)//单独设置列宽
    @ExcelProperty(index = 4, value = {"到访时间"})
    private String visitorDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ColumnWidth(19)//单独设置列宽
    @ExcelProperty(index = 5, value = {"创建时间"})
    private Date createTime;

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
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

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getVisitorDate() {
        return visitorDate;
    }

    public void setVisitorDate(String visitorDate) {
        this.visitorDate = visitorDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
