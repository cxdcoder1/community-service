package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyUnitDao;
import com.example.community.dto.UnitAndCommunityAndBuilding;
import com.example.community.entity.SysDictData;
import com.example.community.entity.ZyRoom;
import com.example.community.entity.ZyUnit;
import com.example.community.service.ZyUnitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 单元 (ZyUnit)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@Service("zyUnitService")
public class ZyUnitServiceImpl extends ServiceImpl<ZyUnitDao, ZyUnit> implements ZyUnitService {

    @Resource
    private ZyUnitDao zyUnitDao;

    @Override
    public Page<UnitAndCommunityAndBuilding> getUnitList(Page<UnitAndCommunityAndBuilding> page, UnitAndCommunityAndBuilding unitAndCommunityAndBuilding) {
        //获取总数据量
        int total = zyUnitDao.getList(0L, 0L, unitAndCommunityAndBuilding).size();
        page.setTotal(total);

        // 计算总页数
        int totalPages = (int) Math.ceil(total * 1.0 / page.getSize());
        if (page.getCurrent() > totalPages) {
            page.setCurrent(totalPages);
        }
        if (page.getCurrent() <= 0) {
            page.setCurrent(1);
        }
        page.setPages(totalPages);
        List<UnitAndCommunityAndBuilding> list = zyUnitDao.getList((page.getCurrent() - 1) * page.getSize(), page.getSize(), unitAndCommunityAndBuilding);
        System.err.println(list);
        page.setRecords(list);
        return page;
    }

    @Override
    public Boolean checkUName(ZyUnit zyUnit) {
        ZyUnit zyUnit1 = zyUnitDao.checkUName(zyUnit);
        if (zyUnit1 != null) {
            //有重复
            if (zyUnit.getUnitId().equals(zyUnit1.getUnitId())) {
                //重复的是本身
                return true;
            } else {
                //与别人重复
                return false;
            }
        } else {
            //没有重复
            return true;
        }
    }

    @Override
    public Boolean checkCode(ZyUnit zyUnit) {
        ZyUnit zyUnit1 = zyUnitDao.checkCode(zyUnit);
        if (zyUnit1 != null) {
            //有重复
            if (zyUnit1.getUnitId().equals(zyUnit.getUnitId())) {
                //与自己重复
                return true;
            } else {
                //与别人重复
                return false;
            }
        } else {
            //没有重复
            return true;
        }
    }

    @Override
    public Integer addUnit(ZyUnit zyUnit) {
        return zyUnitDao.addUnit(zyUnit);
    }

    @Override
    public Integer updateUnit(ZyUnit zyUnit) {

        return zyUnitDao.updateUnit(zyUnit);
    }

    @Override
    public Integer delById(String id) {
        return zyUnitDao.delById(id);
    }

    @Override
    public List<ZyRoom> getByUnits(List<String> list) {
        return zyUnitDao.getByUnits(list);
    }


    @Override
    public List<ZyRoom> getByUnit(String id) {
        return zyUnitDao.getByUnit(id);
    }

    @Override
    public Integer delUnits(List<String> list) {

        return zyUnitDao.delUnits(list);
    }

    @Override
    public List<ZyUnit> getUnitsById(List<String> list) {

        return zyUnitDao.getUnitsById(list);
    }

    @Override
    public List<SysDictData> statusList(String id) {

        return zyUnitDao.statusList(id);
    }
}

