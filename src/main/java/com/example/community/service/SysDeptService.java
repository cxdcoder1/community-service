package com.example.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.SysDept;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * 部门表(SysDept)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
public interface SysDeptService extends IService<SysDept> {
    List<SysDept> selAllDept(SysDept sysDept);

    List<SysDept> getDept(SysDept sysDept);

    List<SysDept> getDeptLists(SysDept sysDept);

    int insertDept(SysDept sysDept);

    List selectRoleName(long id);

    Integer updateDept(SysDept sysDept);

    Integer deleteDept(String deptId);

    Boolean checkName(String deptName, String deptId, String parentId);

    /**
     * 查询是否有子集
     *
     * @param deptId
     * @return
     */
    List<SysDept> isChildren(String deptId);

    /**
     * 根据id查询部门信息
     * @param deptId
     * @return
     */
    SysDept getById(String deptId);


    Integer updateDeptlis(String status,long id);

    SysDept getByDept(String deptId);

}

