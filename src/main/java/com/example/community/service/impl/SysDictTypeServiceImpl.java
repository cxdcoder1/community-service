package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysDictTypeDao;
import com.example.community.entity.SysDictType;
import com.example.community.service.SysDictTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 字典类型表(SysDictType)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
@Service("sysDictTypeService")
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeDao, SysDictType> implements SysDictTypeService {

    @Resource
    SysDictTypeDao sysDictTypeDao;

    @Override
    public List<SysDictType> getDictOptionselect(Long dictId) {

        List<SysDictType> dictOptionselect = sysDictTypeDao.getDictOptionselect(dictId);
//        ArrayList<Object> dictNameList = new ArrayList<>();
//        for (SysDictType sysDictType : dictOptionselect) {
//            dictNameList.add(sysDictType.getDictName());
//        }

        return dictOptionselect;
    }

    @Override
    public SysDictType selectName(String name) {
        return sysDictTypeDao.selectDictTypeName(name);
    }

    @Override
    public Page<SysDictType> selectDictType(Page<SysDictType> page, SysDictType sysDictType) {
        // 获取满足条件的角色列表总数

        long total = sysDictTypeDao.count(sysDictType);

        page.setTotal(total);

        // 计算总页数
        long totalPages = (long) Math.ceil(total * 1.0 / page.getSize());
        if (page.getCurrent() > totalPages) {
            page.setCurrent(totalPages);
        }

        if(page.getCurrent()<=0){
            page.setCurrent(1);
        }

        page.setPages(totalPages);
        page.setRecords(sysDictTypeDao.selectDictType((page.getCurrent()-1) * page.getSize(), page.getSize(),sysDictType));

        return page;
    }

    @Override
    public int updDictType(SysDictType sysDictType) {
        return sysDictTypeDao.updDictType(sysDictType);
    }


    @Override
    public List<SysDictType> selDictType(String name) {
        return sysDictTypeDao.selDictType(name);
    }

//    @Override
//    public List<SysDictType> selDictType(String name) {
//        return sysDictTypeDao.selDictType(name);
//    }


    @Override
    public int deleteDictType(List<Long> id) {
        return sysDictTypeDao.deleteDictType(id);
    }

    @Override
    public List<SysDictType> getDeriveList(List<String> list) {
        return sysDictTypeDao.getDeriveList(list);
    }


//    @Override
//    public List<SysDictType> selectRoleList(SysDictType sysDictType) {
//        return null;
//    }


}

