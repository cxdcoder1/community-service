package com.example.community.dto;

import cn.hutool.core.annotation.Alias;
import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

public class ZyCommunitys {

    //小区id
    @ExcelProperty(index = 0, value = {"小区id"})
    @Alias("小区id")
    private String communityId;
    //小区名称
    @ExcelProperty(index = 1, value = {"小区名称"})
    @Alias("小区名称")
    private String communityName;
    //小区编码
    @ExcelProperty(index = 2, value = {"小区编码"})
    @Alias("小区编码")
    private String communityCode;
    //省区划码
    @ExcelProperty(index = 3,value = {"省区划码"})
    @Alias("省区划码")
    private String communityProvenceCode;
    //市区划码
    @ExcelProperty(index = 4, value = {"市区划码"})
    @Alias("市区划码")
    private String communityCityCode;
    //区县区划码
    @ExcelProperty(index = 5, value = {"区县区划码"})
    @Alias("区县区划码")
    private String communityTownCode;
    //详细地址
    @ExcelProperty(index = 6, value = {"详细地址"})
    @Alias("详细地址")
    private String communityDetailedAddress;
    //经度
    private String communityLongitude;
    //纬度
    private String communityLatitude;
    //物业id
    @ExcelProperty(index = 7, value = {"物业id"})
    @Alias("物业id")
    private Long deptId;
    //排序
    @ExcelProperty(index = 8, value = {"排序"})
    @Alias("排序")
    private Integer communitySort;
    //创建者
    @ExcelProperty(index = 9, value = {"创建者"})
    @Alias("创建者")
    private String createBy;
    //创建时间
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ExcelProperty(index = 10, value = {"创建时间"})
    @Alias("创建时间")
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;


}
