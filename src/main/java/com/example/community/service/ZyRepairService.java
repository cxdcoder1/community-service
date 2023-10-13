package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.ZyRepairDto;
import com.example.community.entity.SysUser;
import com.example.community.entity.ZyRepair;
import com.example.community.entity.ZyVisitor;
import com.example.community.mini.dto.RepairDto;

import java.util.List;

import java.util.List;

/**
 * 报修信息(ZyRepair)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
public interface ZyRepairService extends IService<ZyRepair> {
    Page<ZyRepairDto> zyRepairDtoList(Page<ZyRepairDto> page, ZyRepairDto zyRepairDto, long id);

    /**
     * 获取报修列表
     * @param communityId
     * @param userId
     * @return
     */
    List<RepairDto> getRepairByK(String communityId ,String userId);

    /**
     * 删除报修表
     * @return
     */
    Integer deleteRepair(String repairId);

    /**
     * 完成报修单
     * @return
     */
    Integer completeRepair(String repairId);

    /**
     * 重新报修
     * @param repairDto
     * @return
     */
    Integer reRepair(RepairDto repairDto);


    List<SysUser> getUserList(long id);

    Integer updateRepair(ZyRepair zyRepair);

    Integer selectDoorTime(String time);

    String  getNumber(String name);
}

