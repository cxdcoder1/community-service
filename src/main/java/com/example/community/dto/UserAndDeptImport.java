package com.example.community.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

import java.util.Date;

@ColumnWidth(15) //列宽,最大值为255
@HeadRowHeight(16) //表头行高
@ContentRowHeight(16) //数据行高
public class UserAndDeptImport {

    //用户ID
    @ExcelProperty(index = 0, value = {"用户编号"})
    private Long userId;

    //部门ID
    @ExcelIgnore
    private Long deptId;

    //用户账号
    @ExcelProperty(index = 1, value = {"用户名称"})
    private String userName;

    //用户昵称
    @ExcelProperty(index = 2, value = {"用户昵称"})
    private String nickName;

    //用户类型（00系统用户）
    @ExcelIgnore
    private String userType;

    //用户邮箱
    @ExcelIgnore
    private String email;

    //手机号码
    @ExcelProperty(index = 4, value = {"手机号码"})
    private String phonenumber;

    //用户性别（0男 1女 2未知）
    @ExcelIgnore
    private String sex;

    //头像地址
    @ExcelIgnore
    private String avatar;

    //密码
    @ExcelProperty(index = 5, value = {"密码"})
    private String password;

    //帐号状态（0正常 1停用）
    @ExcelProperty(index = 6, value = {"帐号状态(0正常 1停用)"})
    private String status;

    //删除标志（0代表存在 2代表删除）
    @ExcelIgnore
    private String delFlag;

    //最后登录IP
    @ExcelIgnore
    private String loginIp;

    //最后登录时间
    @ExcelIgnore
    private Date loginDate;

    //创建者
    @ExcelIgnore
    private String createBy;

    //创建时间
    @ExcelProperty(index = 7, value = {"创建时间"})
    private Date createTime;

    //更新者
    @ExcelIgnore
    private String updateBy;

    //更新时间
    @ExcelIgnore
    private Date updateTime;

    //备注
    @ExcelIgnore
    private String remark;

    //部门名称
    @ExcelProperty(index = 3, value = {"部门"})
    private String deptName;

}
