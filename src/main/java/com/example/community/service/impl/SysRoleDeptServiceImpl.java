package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysRoleDeptDao;
import com.example.community.entity.SysRoleDept;
import com.example.community.service.SysRoleDeptService;
import org.springframework.stereotype.Service;

/**
 * 角色和部门关联表(SysRoleDept)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Service("sysRoleDeptService")
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptDao, SysRoleDept> implements SysRoleDeptService {

}

