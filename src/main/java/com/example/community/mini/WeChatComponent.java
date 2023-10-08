package com.example.community.mini;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 微信通用组件
 */
@Component
public class WeChatComponent {

    @Value("${weChat.appId}")
    private String appId;
    @Value("${weChat.appSecret}")
    private String appSecret;

    private static final String weChatUrl = "https://api.weixin.qq.com/sns/jscode2session" +
            "?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private ObjectMapper objectMapper;

    /**
     * 根据code码获取用户的OpenId
     * @param code code码
     * @return openId
     */
    public ZyResult<String> getOpenIdByCode(String code){
        if (StringUtils.isEmpty(code)){
            return ZyResult.fail("登录码不能为空");
        }
        String authUrl  = String.format(weChatUrl,appId,appSecret,code);
        String result = restTemplate.getForObject(authUrl, String.class);
        System.err.println(result);
        try {
            JsonNode jsonNode = objectMapper.readTree(result);
            System.out.println(jsonNode);
            if (jsonNode.get("errcode")==null){
                return ZyResult.data(jsonNode.get("openid").asText());
            }else {
                return ZyResult.fail(500,"换取openId错误");
            }

        } catch (IOException e) {
            e.printStackTrace();
            return ZyResult.fail(500,e.getMessage());
        }

    }


}
