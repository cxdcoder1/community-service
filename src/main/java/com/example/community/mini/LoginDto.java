package com.example.community.mini;

import java.io.Serializable;

/**
 * 登录的Dto
 */
public class LoginDto implements Serializable {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
