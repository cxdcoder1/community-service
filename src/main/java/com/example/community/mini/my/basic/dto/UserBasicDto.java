package com.example.community.mini.my.basic.dto;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 基础用户信息维护
 */
public class UserBasicDto implements Serializable {
    @NotEmpty(message = "头像不能为空")
    private String avatar;
    @NotEmpty(message = "昵称不能为空")
    private String nickName;
    @NotEmpty(message = "性别不能为空")
    private String gender;
    @NotEmpty(message = "生日不能为空")
    private String birthday;


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


}
