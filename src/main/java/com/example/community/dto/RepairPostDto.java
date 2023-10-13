package com.example.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RepairPostDto {

    //报修ID
    private Long repairId;
    //报修编号
    private String repairNum;
    //报修状态
    private String repairState;
    //派单时间
    private Date assignmentTime;
    //接单时间
    private Date receivingOrdersTime;
    //处理完成时间
    private Date completeTime;
    //取消时间
    private Date cancelTime;
    //期待上门时间
    private String doorTime;
    //分派人id
    private Long assignmentId;
    //处理人id
    private Long completeId;
    //处理人电话
    private String completePhone;
    //处理人姓名
    private String completeName;
    //备注
    private String remark;
    //创建者
    private String connectName;
    //创建时间
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    private Date updateTime;
    //创建人id
    private Long userId;
    //删除状态0默认1删除
    private Integer delFlag;
    //报修内容
    private String repairContent;
    //小区ID
    private Long communityId;
    //详细地址
    private String address;

    private List<String> imagesUrl = new ArrayList<>();
}
