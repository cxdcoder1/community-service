package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysDeptDao;
import com.example.community.entity.SysDept;
import com.example.community.service.SysDeptService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门表(SysDept)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDept> implements SysDeptService {

    @Resource
    private SysDeptDao sysDeptDao;

    @Override
    public List<SysDept> selAllDept(SysDept sysDept) {
        return sysDeptDao.getDeptList(sysDept);
    }

    @Override
    public List<SysDept> getDeptLists(SysDept sysDept) {
        return sysDeptDao.getDeptLists(sysDept);
    }

    @Override
    public Integer deleteDept(String deptId) {

        return sysDeptDao.deleteDept(deptId);
    }

    @Override
    public List<SysDept> isChildren(String deptId) {

        return sysDeptDao.isChildren(deptId);
    }

    @Override
    public SysDept getById(String deptId) {

        return sysDeptDao.getById(deptId);
    }



    @Override
    public Integer updateDeptlis(String status,long id) {
        return sysDeptDao.updateDeptlis(status,id);
    }


    @Override
    public Boolean checkName(String deptName, String deptId, String parentId) {
        SysDept sysDept1 = sysDeptDao.checkName(deptName, deptId, parentId);
        if (sysDept1 == null) {
            return true;
        } else {
            Integer deptId1 = sysDept1.getDeptId().intValue();
            if (deptId1==Integer.parseInt(deptId)) {
                return true;
            }
            return false;
        }
    }

    @Override
    public int insertDept(@RequestBody SysDept sysDept) {
        System.err.println(sysDept.getDeptName());
        System.out.println(sysDept.getParentId());
        return sysDeptDao.insert(sysDept);
    }

    @Override
    public List selectRoleName(long id) {
        return sysDeptDao.selectRoleName(id);
    }

    @Override
    public Integer updateDept(SysDept sysDept) {
        return sysDeptDao.updateDept(sysDept);
    }
}

