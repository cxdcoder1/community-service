package com.example.community.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class ExZyRepair {
    @ColumnWidth(8)//单独设置列宽
    @ExcelProperty(index = 0, value = {"报修ID"})
    //报修ID
    private Long repairId;
    //报修编号
    //类型(投诉、建议)
    @ExcelProperty(index = 1, value = {"报修编号"})
    private String repairNum;
    //报修状态
    @ExcelProperty(index = 2, value = {"报修编状态(0.待处理，1.已分派，2.已完成，3.已取消)"})
    private String repairState;
    //业主名字
    @ExcelProperty(index = 3, value = {"业主名字"})
    private  String ownerRealName;
    //业主电话
    @ExcelProperty(index = 4, value = {"业主电话"})
    private String ownerPhoneNumber;
    //报修内容
    @ExcelProperty(index = 5, value = {"报修内容"})
    private String repairContent;
    //详细地址
    @ExcelProperty(index = 6, value = {"详细地址"})
    private String address;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ColumnWidth(19)//单独设置列宽
    @ExcelProperty(index = 7, value = {"创建时间"})
    private Date createTime;
    //期待上门时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ColumnWidth(19)//单独设置列宽
    @ExcelProperty(index = 8, value = {"期待上门时间"})
    private Date doorTime;
    //处理人姓名
    @ExcelProperty(index = 9, value = {"处理人姓名"})
    private String completeName;
    //备注
    @ExcelProperty(index = 10, value = {"备注"})
    private String remark;
}
