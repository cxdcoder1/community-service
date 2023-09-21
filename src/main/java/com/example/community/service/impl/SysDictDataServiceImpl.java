package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysDictDataDao;
import com.example.community.entity.SysDictData;
import com.example.community.service.SysDictDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 字典数据表(SysDictData)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
@Service("sysDictDataService")
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataDao, SysDictData> implements SysDictDataService {

    @Resource
    private SysDictDataDao sysDictDataDao;


    @Override
    public List<SysDictData> selectDataName(List<String> name) {
        return sysDictDataDao.selectDataName(name);
    }

    @Override
    public int updDictType(String type,String type2 ) {
        return sysDictDataDao.updDictType(type,type2);

    }
}

