package com.example.community.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RoomDto {

    //房间id
    private Long roomId;
    //小区name
    private Long communityId;
    //楼栋name
    private Long buildingId;
    //单元name
    private Long unitId;
    //楼层
    private Integer roomLevel;
    //房间编号
    private String roomCode;
    //房间名称
    private String roomName;
    //房屋建筑面积
    private Double roomAcreage;
    //算费系数
    private Double roomCost;
    //房屋状态
    private String roomStatus;
    //是否商铺
    private String roomIsShop;
    //是否商品房
    private String roomSCommercialHouse;
    //房屋户型
    private String roomHouseType;
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

    //小区name
    private String communityName;
    //楼栋name
    private String buildingName;
    //单元name
    private String unitName;

}
