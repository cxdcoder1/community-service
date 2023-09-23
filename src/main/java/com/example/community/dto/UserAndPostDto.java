package com.example.community.dto;

import com.example.community.entity.SysPost;
import com.example.community.entity.SysUser;

public class UserAndPostDto {
    //用户ID
    private Long userId;
    //岗位ID
    private Long postId;

    private SysUser sysUser;

    private SysPost sysPost;


    public UserAndPostDto() {
    }

    public UserAndPostDto(Long userId, Long postId, SysUser sysUser, SysPost sysPost) {
        this.userId = userId;
        this.postId = postId;
        this.sysUser = sysUser;
        this.sysPost = sysPost;
    }

    /**
     * 获取
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return postId
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置
     * @param postId
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * 获取
     * @return sysUser
     */
    public SysUser getSysUser() {
        return sysUser;
    }

    /**
     * 设置
     * @param sysUser
     */
    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    /**
     * 获取
     * @return sysPost
     */
    public SysPost getSysPost() {
        return sysPost;
    }

    /**
     * 设置
     * @param sysPost
     */
    public void setSysPost(SysPost sysPost) {
        this.sysPost = sysPost;
    }

    @Override
    public String toString() {
        return "UserAndPost{userId = " + userId + ", postId = " + postId + ", sysUser = " + sysUser + ", sysPost = " + sysPost + "}";
    }
}
