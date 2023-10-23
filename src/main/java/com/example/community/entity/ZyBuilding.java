package com.example.community.entity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 楼栋 (ZyBuilding)表实体类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@SuppressWarnings("serial")
@Getter
@Setter
@ColumnWidth(15) //列宽,最大值为255
@HeadRowHeight(16) //表头行高
@ContentRowHeight(16) //数据行高
public class ZyBuilding extends Model<ZyBuilding> {
    //楼栋id
    @ColumnWidth(8)//单独设置列宽
    @ExcelProperty(index = 0, value = {"ID"})
    private Long buildingId;
    //楼栋名称
    @ExcelProperty(index = 1, value = {"楼栋名称"})
    private String buildingName;
    //楼栋编码
    @ExcelProperty(index = 2, value = {"楼栋编码"})
    private String buildingCode;
    //楼栋面积
    @ExcelProperty(index = 3, value = {"楼栋面积（平方）"})
    private Double buildingAcreage;
    //小区id
    @ExcelProperty(index = 4, value = {"小区Id"})
    private Long communityId;
    //创建者
    private String createBy;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ColumnWidth(19)//单独设置列宽
    @ExcelProperty(index = 5, value = {"创建时间"})
    private Date createTime;
    //更新者
    @ExcelIgnore
    private String updateBy;
    //更新时间
    @ExcelIgnore
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    //备注
    @ExcelIgnore
    private String remark;

    @Override
    public String toString() {
        return "ZyBuilding{" +
                "buildingId=" + buildingId +
                ", buildingName='" + buildingName + '\'' +
                ", buildingCode='" + buildingCode + '\'' +
                ", buildingAcreage=" + buildingAcreage +
                ", communityId=" + communityId +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public Double getBuildingAcreage() {
        return buildingAcreage;
    }

    public void setBuildingAcreage(Double buildingAcreage) {
        this.buildingAcreage = buildingAcreage;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
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

}

