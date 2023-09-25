package com.example.community.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysPostDao;
import com.example.community.dao.SysUserPostDao;
import com.example.community.entity.SysPost;
import com.example.community.service.SysPostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 岗位信息表(SysPost)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Service("sysPostService")
public class SysPostServiceImpl extends ServiceImpl<SysPostDao, SysPost> implements SysPostService {

    @Resource
    private SysPostDao sysPostDao;


    @Override
    public Page<SysPost> postList(Page<SysPost> page, SysPost sysPost) {
        // 获取满足条件的角色列表总数
        long total = sysPostDao.count(sysPost);
        page.setTotal(total);

        // 计算总页数
        int totalPages = (int) Math.ceil(total * 1.0 / page.getSize());
        if (page.getCurrent() > totalPages) {
            page.setCurrent(totalPages);
        }

        if(page.getCurrent()<=0){
            page.setCurrent(1);
        }

        page.setPages(totalPages);
        page.setRecords(sysPostDao.selectPost((page.getCurrent()-1) * page.getSize(), page.getSize(), sysPost));
        return page;
    }



    @Override
    public int insertPost(SysPost sysPost) {
        return sysPostDao.insertPost(sysPost);
    }

    @Override
    public Integer setAllPost(String postCode, String postName) {
        return sysPostDao.getPostByCodeOrName(postCode,postName);
    }

    @Override
    public Boolean checkName(String postCode, String postId, String postName) {
        List<SysPost> sysPosts = sysPostDao.checkName(postCode, postId, postName);
        for (SysPost sysPost : sysPosts) {
            if (sysPost.getPostName().equals(postName) || sysPost.getPostCode().equals(postCode)) {
                // 存在重复的 name 或 code
                // 排除当前记录，以允许自身更新
                if (!sysPost.getPostId().equals(postId)) {
                    return false;
                }
            }
        }
        // 不存在重复的 name 或 code
        return true;
    }
    @Override
    public Integer update(SysPost sysPost) {
          return  sysPostDao.updateDept(sysPost);

    }

    @Override
    public Integer selName(SysPost sysPost) {
        return sysPostDao.selNamePost(sysPost);
    }

    @Override
    public Integer delPost(long postId) {
        return sysPostDao.deletePostById(postId);
    }

    @Override
    public Integer deleteByIds(Long[] houseIds) {
        return sysPostDao.deletePostIds(houseIds);
    }

    @Override
    public List<SysPost> getPostList(List<String> list) {
        return sysPostDao.getPostList(list);
    }

    @Override
    public boolean deletes(int[] ids) {
        //去判断删除数组中要删除的岗位能否找到对应的人员信息
        for (int i=0;i<ids.length;i++){
            if (sysPostDao.getUserByPost(ids[i])!=0){
                return false;
            }
        }
        //判读是否删除成功
        if (sysPostDao.deletes(ids)>0){
            return true;
        }else{
            return false;
        }
    }
}

