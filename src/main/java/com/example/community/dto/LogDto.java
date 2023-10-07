package com.example.community.dto;

import lombok.Data;

@Data
public class LogDto {

    //访问ID
    private Long infoId;
    //用户账号
    private String userName;
    //登录IP地址
    private String ipaddr;
    //登录地点
    private String loginLocation;
    //浏览器类型
    private String browser;
    //操作系统
    private String os;
    //登录状态（0成功 1失败）
    private String status;
    //提示消息
    private String msg;
    //查询起始时间
    private String createTime;
    //查询结束时间
    private String updateTime;


}
