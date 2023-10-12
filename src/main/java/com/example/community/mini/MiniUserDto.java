package com.example.community.mini;

import java.io.Serializable;

/**
 * 小程序用户的Dto
 */
public class MiniUserDto implements Serializable {
    private Long ownerId;
    //openId
    private String openId;
    //手机号
    private String phoneNum;
    //头像
    private String avatar;
    //昵称
    private String nickName;
    //生日
    private String birthday;
    //性别 0 未知, 1 男  2 女
    private String gender;
    //是否已经实名认证过  true:认证过,false未认证过
    private boolean authenticated;

    //令牌
    private String miniToken;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getMiniToken() {
        return miniToken;
    }

    public void setMiniToken(String miniToken) {
        this.miniToken = miniToken;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
