package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysDictDataDao;
import com.example.community.dao.SysUserDao;
import com.example.community.dto.UserAndDeptAndPostAndRole;
import com.example.community.dto.UserAndDeptAndRole;
import com.example.community.dto.UserAndDeptImport;
import com.example.community.entity.*;
import com.example.community.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 用户信息表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Resource
    SysUserDao sysUserDao;

    @Resource
    SysDictDataDao sysDictDataDao;

    @Override
    public UserAndDeptAndRole getUserInfo(int id) {
        return sysUserDao.getUserInfo(id);
    }

    @Override
    public int updateUser(SysUser sysUser) {
        return sysUserDao.updataUser(sysUser);
    }

    @Override
    public Page<UserAndDeptAndPostAndRole> selUserlist(Page<UserAndDeptAndPostAndRole> page, UserAndDeptAndPostAndRole userAndDeptAndPostAndRole) {
        // 获取满足条件的角色列表总数
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());

//        long total = sysUserDao.selUserlist(0L,0L,userAndDeptAndPostAndRole).size();
        long total = sysUserDao.count(userAndDeptAndPostAndRole);
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

        page.setRecords(sysUserDao.selUserlist((page.getCurrent()-1) * page.getSize(), page.getSize(), userAndDeptAndPostAndRole));
        System.err.println(page.getRecords()+"cccccccccccc");
        return page;

    }

    @Override
    public Page<UserAndDeptAndPostAndRole> selUserListByP(Page<UserAndDeptAndPostAndRole> page, UserAndDeptAndPostAndRole userAndDeptAndPostAndRole) {
        // 获取满足条件的角色列表总数
        long total = sysUserDao.countByDepts(userAndDeptAndPostAndRole);
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

        //查询分页数据
        List<UserAndDeptAndPostAndRole> list = sysUserDao.selUserlistByDeptS((page.getCurrent() - 1) * page.getSize(), page.getSize(), userAndDeptAndPostAndRole);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<String> getByDeptId(Long deptId) {
        return sysUserDao.getByDeptId(deptId);
    }


    @Override
    public List<SysRole> getAllRole() {
        return sysUserDao.getAllRole();
    }

    @Override
    public List<SysPost> getAllPost() {
        return sysUserDao.getAllPost();
    }

    @Override
    public int updatePost(Long UserId, Long PostId) {
        int i = sysUserDao.updatePost(UserId, PostId);
        return i;
    }

    @Override
    public int updateRole(Long UserId, Long RoleId) {
        int i = sysUserDao.updateRole(UserId, RoleId);
        return i;
    }

    @Override
    public int insertUser(SysUser sysUser) {
        return sysUserDao.insertUser1(sysUser);
    }

    @Override
    public int insertPost(Long UserId, Long PostId) {
        return sysUserDao.insertPost(UserId,PostId);
    }

    @Override
    public int insertRole(Long UserId, Long RoleId) {
        return sysUserDao.insertRole(UserId,RoleId);
    }

    @Override
    public int isok(SysUser sysUser) {
        return sysUserDao.isAddUpdate(sysUser);
    }

    @Override
    public List<SysDept> selAllDept(SysDept sysDept) {
        return sysUserDao.getDeptList(sysDept);
    }

    @Override
    public int restUserPwd(int id, Long pwd) {
        return sysUserDao.restUserPwd(id,pwd);
    }

    @Override
    public int upDataStatus(int id, String status) {
        return sysUserDao.upDataStatus(id,status);
    }

    @Override
    public List<SysDictData> statusOption() {
        return sysDictDataDao.statusOption();
    }

    @Override
    public List<UserAndDeptImport> getUserList(List<String> list) {

        return sysUserDao.getUserList(list);
    }

    @Override
    public Integer deleteUsers(List<String> list) {

        return sysUserDao.deleteUsers(list);
    }

    @Override
    public Integer delById(String id) {


        return sysUserDao.delById(id);
    }

    @Override
    public Map<String,Object> checkUserName(List<UserAndDeptImport> list) {
        Map<String,Object> result = new HashMap<>();
        Set<String> set = new HashSet<>();
        //判断文件中是否重复
        for (UserAndDeptImport u : list) {
            if (!set.add(u.getUserName())){
                //重复
                result.put("status","false");
                result.put("msg","文件中有用户名重复");
                result.put("userName",u.getUserName());
                return result;
            }
        }
        //判断与数据库是否重复
        //获取数据库的数据
        Set<String> names = sysUserDao.getNames();
        for (UserAndDeptImport u : list) {
            if (!names.add(u.getUserName())){
                //重复
                result.put("status","false");
                result.put("msg","用户名已经存在");
                result.put("userName",u.getUserName());
                return result;
            }
        }
        result.put("status","true");
        result.put("msg","没有重复");
        return result;
    }

    @Override
    public Map<String,Object> checkPhone(List<UserAndDeptImport> list) {
        Map<String,Object> result = new HashMap<>();
        Set<String> set = new HashSet<>();
        //判断文件中是否重复
        for (UserAndDeptImport u : list) {
            if (!set.add(u.getPhonenumber())){
                //重复
                result.put("status","false");
                result.put("msg","文件中的电话号码重复");
                result.put("phone",u.getPhonenumber());
                return result;
            }
        }
        Set<String> phone = sysUserDao.getPhone();
        //判断与数据库中是否重复
        for (UserAndDeptImport u : list) {
            if (!phone.add(u.getPhonenumber())){
                //重复
                result.put("status","false");
                result.put("msg","电话号码已经存在");
                result.put("phone",u.getPhonenumber());
                return result;
            }
        }
        result.put("status","true");
        result.put("msg","没有重复");
        return result;
    }

    @Override
    public void batchInsert(List<UserAndDeptImport> list) throws Exception {
        sysUserDao.batchInsert(list);
    }

    @Override
    public SysPost getPostStatus(String id) {

        return sysUserDao.getPostStatus(id);
    }


}

