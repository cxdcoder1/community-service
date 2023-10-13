package com.example.community.service.impl;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyFilesDao;
import com.example.community.dao.ZyRepairDao;
import com.example.community.dto.RepairPostDto;
import com.example.community.dto.ZyRepairDto;
import com.example.community.entity.SysUser;
import com.example.community.entity.ValueLabel;
import com.example.community.entity.ZyFiles;
import com.example.community.entity.ZyRepair;
import com.example.community.mini.ZyResult;
import com.example.community.mini.dto.RepairDto;
import com.example.community.service.ZyRepairService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 报修信息(ZyRepair)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@Service("zyRepairService")
public class ZyRepairServiceImpl extends ServiceImpl<ZyRepairDao, ZyRepair> implements ZyRepairService {
    @Resource
    private ZyRepairDao zyRepairDao;

    @Resource
    private ZyFilesDao zyFilesMapper;

    @Override
    public Page<ZyRepairDto> zyRepairDtoList(Page<ZyRepairDto> page, ZyRepairDto zyRepairDto, long id) {
        long total = zyRepairDao.count(zyRepairDto, id);
        page.setTotal(total);
        int totalPages = (int) Math.ceil(total * 1.0 / page.getSize());
        if (page.getCurrent() > totalPages) {
            page.setCurrent(totalPages);
        }
        if(page.getCurrent()<=0){
            page.setCurrent(1);
        }
        page.setPages(totalPages);
        page.setRecords(zyRepairDao.selectZyRepairDto((page.getCurrent()-1)*page.getSize(),page.getSize(),zyRepairDto,id));
        return page;
    }

    @Override
    public List<SysUser> getUserList(long id) {
        return zyRepairDao.getUserList(id);
    }

    @Override
    public Integer updateRepair(ZyRepair zyRepair) {
        return zyRepairDao.updateRepair(zyRepair);
    }

    @Override
    public Integer selectDoorTime(String time) {
        return zyRepairDao.selectDoorTime(time);
    }

    @Override
    public String  getNumber(String name) {
        return zyRepairDao.getNumber(name);
    }

    @Override
    public List<ValueLabel> repairHouse(Long communityId, Long ownerId) {
        return zyRepairDao.repairHouse(communityId, ownerId);
    }

    @Override
    public ZyResult repairPost(RepairPostDto repairPostDto) {
        ZyRepair zyRepair = new ZyRepair();
        zyRepair.setRepairId(System.currentTimeMillis());
        zyRepair.setRepairNum("code"+System.currentTimeMillis());
        zyRepair.setRepairState("0");
        zyRepair.setRepairContent(repairPostDto.getRepairContent());
        zyRepair.setCreateBy(repairPostDto.getConnectName());
        zyRepair.setDoorTime(repairPostDto.getDoorTime());
        zyRepair.setCommunityId(repairPostDto.getCommunityId());
        zyRepair.setUserId(repairPostDto.getUserId());
        zyRepair.setAddress(repairPostDto.getAddress());
        zyRepairDao.insert(zyRepair);
        //新增图片
        if (repairPostDto.getImagesUrl().size() > 0) {
            List<ZyFiles> files = new ArrayList<>();
            DefaultIdentifierGenerator defaultIdentifierGenerator = new DefaultIdentifierGenerator();
            repairPostDto.getImagesUrl().forEach(url -> {
                ZyFiles zyFiles = new ZyFiles();
                zyFiles.setFilesId(defaultIdentifierGenerator.nextId(null));
                zyFiles.setFilesUrl(url);
                zyFiles.setCreateTime(new Date());
                zyFiles.setSource(0);//来源0APP端，1PC端
                zyFiles.setUserId(zyRepair.getUserId());
                zyFiles.setParentId(zyRepair.getRepairId());//设置图片所属
                zyFiles.setRemark("Repair");
                files.add(zyFiles);
            });
            zyFilesMapper.insertFilesBatch(files);
        }
        return ZyResult.data("1");
    }

    @Override
    public List<RepairDto> getRepairByK(String communityId, String userId) {
        return zyRepairDao.selectAllRepairs(communityId,userId);
    }

    @Override
    public Integer deleteRepair(String repairId,String updateBy) {
        Date date = new Date();
        return zyRepairDao.deleteRepair(updateBy,repairId ,date);
    }

    @Override
    public Integer completeRepair(String repairId,String updateBy ) {
        Date date = new Date();
        return zyRepairDao.completeRepair(updateBy,repairId,date);
    }

    @Override
    public Integer reRepair(RepairDto repairDto) {
        return zyRepairDao.reRepair(repairDto);
    }

    @Override
    public List<ZyRepair> getZyRepairList() {
        return zyRepairDao.getZyRepairList();
    }
}

