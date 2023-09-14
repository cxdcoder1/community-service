package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysPostDao;
import com.example.community.entity.SysPost;
import com.example.community.service.SysPostService;
import org.springframework.stereotype.Service;

/**
 * 岗位信息表(SysPost)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Service("sysPostService")
public class SysPostServiceImpl extends ServiceImpl<SysPostDao, SysPost> implements SysPostService {

}

