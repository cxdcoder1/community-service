package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysUserPostDao;
import com.example.community.entity.SysUserPost;
import com.example.community.service.SysUserPostService;
import org.springframework.stereotype.Service;

/**
 * 用户与岗位关联表(SysUserPost)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("sysUserPostService")
public class SysUserPostServiceImpl extends ServiceImpl<SysUserPostDao, SysUserPost> implements SysUserPostService {

}

