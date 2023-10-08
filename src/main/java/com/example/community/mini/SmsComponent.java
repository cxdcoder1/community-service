package com.example.community.mini;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SmsComponent {


    private static final Logger log = LoggerFactory.getLogger(SmsComponent.class);

    private final ObjectMapper objectMapper;

    private final SmsProperty smsProperty;

    public SmsComponent(ObjectMapper objectMapper, SmsProperty smsProperty) {
        this.objectMapper = objectMapper;
        this.smsProperty = smsProperty;
    }

    // private IAcsClient client = null;

    // @PostConstruct
    // private void initClient() {
    //     DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
    //             smsProperty.getAccessKey(), smsProperty.getAccessSecret());
    //     client = new DefaultAcsClient(profile);
    //     log.info("短信客户端初始化完毕:[{}]", client);
    // }

    public ZyResult<String> sendVerifyCode(String phoneNum, String code) {

        // CommonRequest request = new CommonRequest();
        // request.setSysMethod(MethodType.POST);
        // request.setSysDomain("dysmsapi.aliyuncs.com");
        // request.setSysVersion("2017-05-25");
        // request.setSysAction("SendSms");
        // request.putQueryParameter("RegionId", "cn-hangzhou");
        // request.putQueryParameter("PhoneNumbers", phoneNum);
        // request.putQueryParameter("SignName", smsProperty.getLoginTemplateSign());
        // request.putQueryParameter("TemplateCode", smsProperty.getLoginTemplateCode());
        // request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        // try {
        //     CommonResponse response = client.getCommonResponse(request);
        //     //响应数据
        //     log.info("发送短信给:[{}] 后响应数据:[{}]", phoneNum, response.getData());
        //     String responseCode = objectMapper.readTree(response.getData()).get("Code").asText();
        //     if ("OK".equals(responseCode)) {
        //         return ZyResult.success("短信发送成功");
        //     } else {
        //         return ZyResult.fail(response.getData());
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     log.error("发送短信失败:[{}]", e.getMessage());
        //     return ZyResult.fail(e.getMessage());
        return ZyResult.success("短信发送成功");
    }
}

