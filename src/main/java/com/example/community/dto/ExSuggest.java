package com.example.community.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhf
 */
@Getter
@ColumnWidth(15) //列宽,最大值为255
@HeadRowHeight(16) //表头行高
@ContentRowHeight(16) //数据行高
public class ExSuggest {
    @ColumnWidth(8)//单独设置列宽
    @ExcelProperty(index = 0, value = {"ID"})
    //id
    private Long complaintSuggestId;
    //类型(投诉、建议)
    @ExcelProperty(index = 1, value = {"类型(Suggest=建议，Complaint=投诉)"})
    private String complaintSuggestType;
    //内容
    @ExcelProperty(index = 2, value = {"内容"})
    private String complaintSuggestContent;
    //创建者
    @ExcelProperty(index = 3, value = {"创建者"})
    private String createBy;
    //手机号码
    @ExcelProperty(index = 4, value = {"手机号码"})
    private String ownerPhoneNumber;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ColumnWidth(19)//单独设置列宽
    @ExcelProperty(index = 5, value = {"到访时间"})
    private Date createTime;
    //备注
    @ExcelProperty(index = 6, value = {"备注"})
    private String remark;
    //文件的URL
    @ExcelProperty(index = 7, value = {"文件的URL"})
    private String filesUrl;


    public Long getComplaintSuggestId() {
        return complaintSuggestId;
    }

    public void setComplaintSuggestId(Long complaintSuggestId) {
        this.complaintSuggestId = complaintSuggestId;
    }

    public String getComplaintSuggestType() {
        return complaintSuggestType;
    }

    public void setComplaintSuggestType(String complaintSuggestType) {
        this.complaintSuggestType = complaintSuggestType;
    }

    public String getComplaintSuggestContent() {
        return complaintSuggestContent;
    }

    public void setComplaintSuggestContent(String complaintSuggestContent) {
        this.complaintSuggestContent = complaintSuggestContent;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFilesUrl() {
        return filesUrl;
    }

    public void setFilesUrl(String filesUrl) {
        this.filesUrl = filesUrl;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }
}
