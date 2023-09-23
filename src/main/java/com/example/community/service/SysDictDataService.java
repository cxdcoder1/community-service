package com.example.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.SysDictData;

import java.util.List;

/**
 * 字典数据表(SysDictData)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
public interface SysDictDataService extends IService<SysDictData> {

    List<SysDictData> selectDataName(List<String> name);

    int updDictType(String type,String type2);
    List<SysDictData> getData(SysDictData sysDictData, long index, long size);

    int updateData(SysDictData sysDictData);

    int removeDictById(Long id);

//    List<SysDictData> selectDataName(String name);

    List<SysDictData> getDeriveList(List<String> list);

    int isok(SysDictData sysDictData);

}

