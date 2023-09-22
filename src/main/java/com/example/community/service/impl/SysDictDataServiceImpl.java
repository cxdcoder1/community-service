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
    SysDictDataDao sysDictDataDao;

    @Override
    public List<SysDictData> getData(SysDictData sysDictData, long index, long size) {
        return sysDictDataDao.getData(sysDictData,index,size);
    }

    @Override
    public int updateData(SysDictData sysDictData) {
        return sysDictDataDao.updateData(sysDictData);
    }

    @Override
    public int removeDictById(Long id) {
        return sysDictDataDao.removeDictById(id);
    }

    @Override
    public List<SysDictData> selectDataName(String name) {
        System.err.println("service"+name);
        return sysDictDataDao.selectDataName(name);
    }

    @Override
    public List<SysDictData> getDeriveList(List<String> list) {
        return sysDictDataDao.getDeriveList(list);
    }

    @Override
    public int isok(SysDictData sysDictData) {
        return sysDictDataDao.isAddUpdate(sysDictData);
    }

}

