package com.example.community.controller;



import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.community.entity.SysMenu;
import com.example.community.entity.SysRole;
import com.example.community.service.SysRoleService;
import com.example.community.utils.MenuTree;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色信息表(SysRole)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@RestController
@RequestMapping("sysRole")
@CrossOrigin
public class SysRoleController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleService roleService;



    @GetMapping("/list")
    public List<SysRole> list(SysRole role) {
        List<SysRole> list = roleService.selectRoleList(role);
        return list;
    }

    /**
     * 修改保存角色
     */
    @PutMapping("edit")
    public String edit(@Validated @RequestBody SysRole role) {
        int i = roleService.updateRole(role);
        if (i!=0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    /**
     * 修改保存数据权限
     */
//    @PutMapping("/dataScope")
//    public String dataScope(@RequestBody SysRole role) {
//        roleService.
//    }

    @RequestMapping("getRoleMenuTreeselect")
    public R getRoleMenuTreeselect(int roleId) {
        List<SysMenu> menus = roleService.getRoleMenuTreeselect(roleId);
        List<SysMenu> menuList = new MenuTree(menus).builTree();

        if (menuList != null && !menuList.isEmpty()) {
            System.out.println(menuList);
            return R.ok(menuList);
        }



        System.err.println(R.ok(menus));

        return R.ok(menus);
    }
}

