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

}

