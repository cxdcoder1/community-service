package com.example.community.mini.my.basic;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;

/**
 * miniApp的上下文环境
 */
public class MiniContextUtils implements Serializable {

    private static ThreadLocal<String> miniUserInfo = new ThreadLocal<>();

    private static final ObjectMapper objectMapper = new ObjectMapper();


    protected static void setUserInfo(String userInfo) {
        miniUserInfo.set(userInfo);
    }

    /**
     * getOpenId 和 getPhoneNum只能使用其中一个,并且一个请求只能使用一次
     *
     * @return 获取业主小程序openId
     */
    public static String getOpenId() {
        String userInfo = miniUserInfo.get();
        System.out.println("getOpenId" + userInfo);
        try {
            return objectMapper.readTree(userInfo).get("openId").asText();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            remove();
        }
    }

    /**
     * getOpenId 和 getPhoneNum只能使用其中一个,并且一个请求只能使用一次
     *
     * @return 获取业主手机号
     */
    public static String getPhoneNum() {
        String userInfo = miniUserInfo.get();
        try {
            return objectMapper.readTree(userInfo).get("phoneNum").asText();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            remove();
        }
    }

    //移除线程绑定信息
    public static void remove() {
        miniUserInfo.remove();
    }
}
