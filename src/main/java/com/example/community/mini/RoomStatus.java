package com.example.community.mini;

public enum RoomStatus {
    /**
     * 审核中
     */
    Auditing,
    /**
     * 绑定状态
     */
    Binding,
    /**
     * 拒绝,审核失败
     */
    Reject,
    /**
     * 解绑
     */
    Unbind;
}
