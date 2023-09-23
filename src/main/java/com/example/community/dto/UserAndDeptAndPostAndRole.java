package com.example.community.dto;

import com.example.community.entity.SysDept;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserAndDeptAndPostAndRole {
    //用户ID
    private Long userId;
    //部门ID
    private Long deptId;
    //用户账号
    private String userName;
    //用户昵称
    private String nickName;
    //用户类型（00系统用户）
    private String userType;
    //用户邮箱
    private String email;
    //手机号码
    private String phonenumber;
    //用户性别（0男 1女 2未知）
    private String sex;
    //头像地址
    private String avatar;
    //密码
    private String password;
    //帐号状态（0正常 1停用）
    private String status;
    //删除标志（0代表存在 2代表删除）
    private String delFlag;
    //最后登录IP
    private String loginIp;
    //最后登录时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String loginDate;
    //创建者
    private String createBy;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String createTime;
    //更新者
    private String updateBy;
    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String updateTime;
    //备注
    private String remark;

    //部门
    private SysDept sysDeptList;
    //岗位和用户
    private UserAndPostDto userAndPostDto;

    //角色和用户
    private UserAndRoleDto userAndRoleDto;


    public UserAndDeptAndPostAndRole() {
    }

    public UserAndDeptAndPostAndRole(Long userId, Long deptId, String userName, String nickName, String userType, String email, String phonenumber, String sex, String avatar, String password, String status, String delFlag, String loginIp, String loginDate, String createBy, String createTime, String updateBy, String updateTime, String remark, SysDept sysDeptList, UserAndPostDto userAndPostDto, UserAndRoleDto userAndRoleDto) {
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
        this.sysDeptList = sysDeptList;
        this.userAndPostDto = userAndPostDto;
        this.userAndRoleDto = userAndRoleDto;
    }

    /**
     * 获取
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return deptId
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置
     * @param deptId
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取
     * @return userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * 设置
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * 获取
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取
     * @return delFlag
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置
     * @param delFlag
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取
     * @return loginIp
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 设置
     * @param loginIp
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    /**
     * 获取
     * @return loginDate
     */
    public String getLoginDate() {
        return loginDate;
    }

    /**
     * 设置
     * @param loginDate
     */
    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * 获取
     * @return createBy
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateBy
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取
     * @return updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取
     * @return sysDeptList
     */
    public SysDept getSysDeptList() {
        return sysDeptList;
    }

    /**
     * 设置
     * @param sysDeptList
     */
    public void setSysDeptList(SysDept sysDeptList) {
        this.sysDeptList = sysDeptList;
    }

    /**
     * 获取
     * @return userAndPostDto
     */
    public UserAndPostDto getUserAndPostDto() {
        return userAndPostDto;
    }

    /**
     * 设置
     * @param userAndPostDto
     */
    public void setUserAndPostDto(UserAndPostDto userAndPostDto) {
        this.userAndPostDto = userAndPostDto;
    }

    /**
     * 获取
     * @return userAndRoleDto
     */
    public UserAndRoleDto getUserAndRoleDto() {
        return userAndRoleDto;
    }

    /**
     * 设置
     * @param userAndRoleDto
     */
    public void setUserAndRoleDto(UserAndRoleDto userAndRoleDto) {
        this.userAndRoleDto = userAndRoleDto;
    }

    public String toString() {
        return "UserAndDeptAndPostAndRole{userId = " + userId + ", deptId = " + deptId + ", userName = " + userName + ", nickName = " + nickName + ", userType = " + userType + ", email = " + email + ", phonenumber = " + phonenumber + ", sex = " + sex + ", avatar = " + avatar + ", password = " + password + ", status = " + status + ", delFlag = " + delFlag + ", loginIp = " + loginIp + ", loginDate = " + loginDate + ", createBy = " + createBy + ", createTime = " + createTime + ", updateBy = " + updateBy + ", updateTime = " + updateTime + ", remark = " + remark + ", sysDeptList = " + sysDeptList + ", userAndPostDto = " + userAndPostDto + ", userAndRoleDto = " + userAndRoleDto + "}";
    }
}
