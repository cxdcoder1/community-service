package com.example.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.SysDept;

import java.util.List;

/**
 * 部门表(SysDept)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
public interface SysDeptService extends IService<SysDept> {
        List<SysDept> selAllDept(SysDept sysDept);
}

