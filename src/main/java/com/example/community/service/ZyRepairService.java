package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.ZyRepairDto;
import com.example.community.entity.ZyRepair;
import com.example.community.entity.ZyVisitor;

/**
 * 报修信息(ZyRepair)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
public interface ZyRepairService extends IService<ZyRepair> {
    Page<ZyRepairDto> zyRepairDtoList(Page<ZyRepairDto> page, ZyRepairDto zyRepairDto, long id);
}

