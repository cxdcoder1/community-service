package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysDictTypeDao;
import com.example.community.entity.SysDictType;
import com.example.community.service.SysDictTypeService;
import org.springframework.stereotype.Service;

/**
 * 字典类型表(SysDictType)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
@Service("sysDictTypeService")
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeDao, SysDictType> implements SysDictTypeService {

}

