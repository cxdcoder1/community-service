package com.example.community.log.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

/**
 * @author Ydx
 * @date 2020/3/5 16:29
 */
public class LogUtil {

    /**
     * 获取当前机器ip
     * @return
     */
    public static String getLocalIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取当前机器的用户名
     * @return
     */
    public static String  getMain(){
        String osUser=System.getProperty("user.name");
        return osUser;
    }

    /**
     * 获取当前系统名   e.g :win10
     * @return
     */
    public static String getProperty(){
        Properties props=System.getProperties();
        String osName = props.getProperty("os.name");
        return osName;
    }


}