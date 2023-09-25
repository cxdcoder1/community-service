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
    @ExcelProperty(index = 0, value = {"用户编号（导入请填0或不填）"})
    private Long userId;

    //部门ID
    @ExcelIgnore
    private Long deptId;

    //用户账号
    @ColumnWidth(35)//单独设置列宽
    @ExcelProperty(index = 1, value = {"用户名称(必填)"})
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
    @ColumnWidth(30)//单独设置列宽
    @ExcelProperty(index = 4, value = {"手机号码(必填)"})
    private String phonenumber;

    //用户性别（0男 1女 2未知）
    @ExcelIgnore
    private String sex;

    //头像地址
    @ExcelIgnore
    private String avatar;

    //密码
    @ExcelProperty(index = 5, value = {"密码(必填)"})
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
    @ColumnWidth(20)//单独设置列宽
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

    public UserAndDeptImport() {
    }

    public UserAndDeptImport(Long userId, Long deptId, String userName, String nickName, String userType, String email, String phonenumber, String sex, String avatar, String password, String status, String delFlag, String loginIp, Date loginDate, String createBy, Date createTime, String updateBy, Date updateTime, String remark, String deptName) {
        this.userId = userId;
        this.deptId = deptId;
        this.userName = userName;
        this.nickName = nickName;
        this.userType = userType;
        this.email = email;
        this.phonenumber = phonenumber;
        this.sex = sex;
        this.avatar = avatar;
        this.password = password;
        this.status = status;
        this.delFlag = delFlag;
        this.loginIp = loginIp;
        this.loginDate = loginDate;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.remark = remark;
        this.deptName = deptName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "UserAndDeptImport{" +
                "userId=" + userId +
                ", deptId=" + deptId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userType='" + userType + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", sex='" + sex + '\'' +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginDate=" + loginDate +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
