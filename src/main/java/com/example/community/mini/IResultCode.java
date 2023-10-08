package com.example.community.mini;

import java.io.Serializable;

/**
 * @author yangdi
 */
public interface IResultCode extends Serializable {

    /**
     * 获取消息
     *
     * @return
     */
    String getMessage();

    /**
     * 获取状态码
     *
     * @return
     */
    int getCode();
}
