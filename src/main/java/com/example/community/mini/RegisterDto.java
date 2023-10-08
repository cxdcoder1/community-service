package com.example.community.mini;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 注册Dto
 */
@Data
public class RegisterDto implements Serializable {

    //openId
    @NotBlank(message = "openId不能为空")
    private String openId;
    //手机号
    @NotBlank(message = "手机号不能为空")
    private String phoneNum;
    //头像
    private String avatar;
    //昵称
    private String nickName;
    //生日
    private Date birthday;
    //微信性别定义 0 未知,1男，2 女
    private String gender;
    //验证码 不会持久化
    @NotBlank(message = "验证码不能为空")
    private String code;

}
