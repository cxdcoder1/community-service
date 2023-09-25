package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.SysPost;
import com.example.community.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 岗位信息表(SysPost)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
public interface SysPostService extends IService<SysPost> {
    Page<SysPost> postList(Page<SysPost> page, SysPost sysPost);

    int insertPost(SysPost sysPost);

    Integer setAllPost(String postCode,String postName);

    Boolean checkName(String postCode,String postId,String postName);

    Integer update(SysPost sysPost);

    Integer selName(SysPost sysPost);

    Integer delPost(long postId);

     Integer deleteByIds(Long[] houseIds);

    /**
     * 获取要导出的岗位信息
     * @return
     */
    List<SysPost> getPostList(List<String> list);

    boolean deletes(@Param("ids") int[] ids);
}

