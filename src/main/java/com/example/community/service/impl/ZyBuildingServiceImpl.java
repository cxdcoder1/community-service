package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyBuildingDao;
import com.example.community.dao.ZyCommunityDao;
import com.example.community.entity.ZyBuilding;
import com.example.community.entity.ZyCommunity;
import com.example.community.service.ZyBuildingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 楼栋 (ZyBuilding)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("zyBuildingService")
public class ZyBuildingServiceImpl extends ServiceImpl<ZyBuildingDao, ZyBuilding> implements ZyBuildingService {

    @Resource
    private ZyBuildingDao zyBuilding;

    @Override
    public List<ZyBuilding> selectName(String id) {
        return zyBuilding.selectName(id);
    }

    @Override
    public List<ZyBuilding> selectNames(List<String> id) {
        return zyBuilding.selectNames(id);
    }
    @Resource
    private ZyBuildingDao zyBuildingDao;
    @Override
    public Page<ZyBuilding> buildingList(Page<ZyBuilding> page, ZyBuilding zyBuilding,long id) {
        long total = zyBuildingDao.count(zyBuilding,id);
        page.setTotal(total);

        // 计算总页数
        int totalPages = (int) Math.ceil(total * 1.0 / page.getSize());
        if (page.getCurrent() > totalPages) {
            page.setCurrent(totalPages);
        }

        if(page.getCurrent()<=0){
            page.setCurrent(1);
        }

        page.setPages(totalPages);
        page.setRecords(zyBuildingDao.selectBuild((page.getCurrent()-1)*page.getSize(),page.getSize(),zyBuilding,id));
        return page;

    }

    @Override
    public Boolean addBuilding(ZyBuilding zyBuilding) {
        Long buildingName = zyBuildingDao.getBuildingName(zyBuilding.getBuildingName(), zyBuilding.getCommunityId());
        if (buildingName==null){
            zyBuildingDao.addBuilding(zyBuilding);
            return true;
        }
        return false;
    }

    @Override
    public Integer updateBuilding(ZyBuilding zyBuilding) {
        return zyBuildingDao.updateBuilding(zyBuilding);
    }

    @Override
    public Long selName(ZyBuilding zyBuilding) {
        return zyBuildingDao.selBuildingName(zyBuilding);
    }

    @Override
    public Long delBuilding(long id) {
        return zyBuildingDao.delBuilding(id);
    }

    @Override
    public Long getUnitName(long id) {
        return zyBuildingDao.getUnitName(id);
    }

    @Override
    public boolean deletesBuilding(Long [] ids) {
        for (int i=0;i<ids.length;i++){
            if (zyBuildingDao.getUnitName(ids[i])!=null){
                return false;
            }
        }
      if (zyBuildingDao.deletesBuilding(ids)>0){
          return true;
      }else {
          return false;
      }
    }

    @Override
    public List<ZyBuilding> getBuildingList(List<String> list) {
        return zyBuildingDao.getBuildingList(list);
    }


    @Override
    public List<ZyBuilding> getUBuild(String communityId) {

        return zyBuildingDao.getUBuild(communityId);
    }
}

