package com.example.community.mini.my.auth.dto;

import java.io.Serializable;

public class AuthenticationDto implements Serializable {
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 身份证号
     */
    private String idCardNum;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }
}
