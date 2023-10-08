package com.example.community.mini;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sms")
public class SmsProperty {
    /**
     * 短信服务的Key
     */
    private String accessKey;
    /**
     * 短信服务的密钥
     */
    private String accessSecret;
    /**
     * 短信配置的模板号
     */
    private String loginTemplateCode;
    /**
     * 短信的签名
     */
    private String loginTemplateSign;


    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public String getLoginTemplateCode() {
        return loginTemplateCode;
    }

    public void setLoginTemplateCode(String loginTemplateCode) {
        this.loginTemplateCode = loginTemplateCode;
    }

    public String getLoginTemplateSign() {
        return loginTemplateSign;
    }

    public void setLoginTemplateSign(String loginTemplateSign) {
        this.loginTemplateSign = loginTemplateSign;
    }
}
