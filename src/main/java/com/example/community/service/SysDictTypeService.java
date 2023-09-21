package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.SysDictData;
import com.example.community.entity.SysDictType;
import com.example.community.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典类型表(SysDictType)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
public interface SysDictTypeService extends IService<SysDictType> {


//    List<SysDictType> selectDictType(@Param("index") Long index, @Param("size") Long size , @Param("sysDictType") SysDictType sysDictType);

    SysDictType selectName(String name);

    Page<SysDictType> selectDictType(Page<SysDictType> page, SysDictType sysDictType);

    int updDictType(SysDictType sysDictType);
    //查重
    List<SysDictType> selDictType(String name);
    //删除
    int deleteDictType(long id);

    List<SysDictType> getDeriveList(List<String> list);
}

