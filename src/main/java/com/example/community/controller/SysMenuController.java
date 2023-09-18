package com.example.community.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.entity.SysMenu;
import com.example.community.service.SysMenuService;
import com.example.community.utils.MenuTree;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单权限表(SysMenu)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@RestController
@RequestMapping("sysMenu")
@CrossOrigin
public class SysMenuController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;


    @PostMapping("/menuList")
    public R menuList(@RequestBody SysMenu sysMenu) {
//        System.err.println(sysMenu.toString());
        List<SysMenu> menus = sysMenuService.getMenuList(sysMenu.getMenuName(),sysMenu.getStatus());
//        System.err.println(menus);
        List<SysMenu> menuList = new MenuTree(menus).builTree();

        if (menuList != null && !menuList.isEmpty()) {
            return R.ok(menuList);
        }

        System.err.println(R.ok(menus));

        return R.ok(menus);
    }


//    @PostMapping("/menuList")
//    public R menuList(@RequestBody SysMenu sysMenu) {
//        return success(this.sysMenuService.getMenuList(sysMenu.getMenuName(),sysMenu.getStatus()));
//    }


    /**
     * 通过当前登录的用户id来查询菜单
     * @param id
     * @return
     */

    @GetMapping("getTreeMenu/{id}")
    public R MenuTreeList(@PathVariable int id) {
        return success(this.sysMenuService.MenuTree(id));
    }

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param sysMenu 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysMenu> page, SysMenu sysMenu) {
        return success(this.sysMenuService.page(page, new QueryWrapper<>(sysMenu)));
    }


    @RequestMapping("deleteMenu")
    public Map<String, Object> deleteMenu(@RequestBody SysMenu sysMenu){
        Map<String, Object> map = new HashMap<>();
        System.err.println(sysMenu.toString());
        String s = sysMenuService.deleteMenu(sysMenu.getMenuId(), null);
        map.put("data",s);
        System.out.println(map);
        return map;
    }

    /**
     * 新增数据
     *
     * @param sysMenu 实体对象
     * @return 新增结果
     */
    @PostMapping("addMenu")
    public Map<String, Object> insert(@RequestBody SysMenu sysMenu) {
        Map<String, Object> result = new HashMap<>();
        Boolean cName = sysMenuService.checkName(sysMenu.getMenuName(), sysMenu.getMenuId() + "", sysMenu.getParentId() + "");
        Boolean cPath = sysMenuService.checkPath(sysMenu.getPath(), sysMenu.getMenuId() + "");
        //判断是否重复
        if (cName == false) {
            result.put("status", 201);
            result.put("success", false);
            result.put("msg", "菜单名重复");
            return result;
        }
        if (cPath == false) {
            result.put("status", 201);
            result.put("success", false);
            result.put("msg", "路径名重复");
            return result;
        }
        //没有重复可以新增
        //获取即将添加的菜单的父类
        SysMenu parent = sysMenuService.getParent(sysMenu);
        if (parent.getMenuType().equals("F")) {
            //父类是按钮 不能添加
            result.put("status", 201);
            result.put("success", false);
            result.put("msg", "不能在按钮下添加菜单");
            return result;
        }

        //判断父为目录 子为按钮时 不能添加
        if (parent.getMenuType().equals("M") && sysMenu.getParentId().equals("F")) {
            result.put("status", 201);
            result.put("success", false);
            result.put("msg", "不能在目录下面添加按钮");
            return result;
        } else if (parent.getMenuType().equals("M")) {
            return add(sysMenu, result);
        }

        //判断父为菜单时
        if (parent.getMenuType().equals("C")) {
            //首先查询父类菜单是否有按钮
            Boolean t = hasF(parent);
            if (sysMenu.getMenuType().equals("M")) {
                //子为目录
                if (t) {
                    //含有按钮
                    result.put("status", 201);
                    result.put("success", false);
                    result.put("msg", "不能在有按钮的菜单下面添加目录");
                    return result;
                } else {
                    //没有按钮
                    //把父集提升为目录
                    sysMenuService.updateMenu(sysMenu);
                    return add(sysMenu, result);
                }
            }
            if (sysMenu.getMenuType().equals("C")) {
                //子为菜单
                if (t) {
                    //含有按钮
                    result.put("status", 201);
                    result.put("success", false);
                    result.put("msg", "不能在有按钮的菜单下面添加菜单");
                    return result;
                } else {
                    //没有按钮
                    //把父集提升为目录
                    sysMenuService.updateMenu(sysMenu);
                    return add(sysMenu, result);
                }
            }
            if (sysMenu.getMenuType().equals("F")) {
                //子为按钮时
                return add(sysMenu, result);
            }
        }
        //父为按钮
        if (parent.getMenuType().equals("F")) {
            result.put("status", 201);
            result.put("success", false);
            result.put("msg", "不能在按钮下添加");
            return result;
        }
        result.put("msg","其他");
        result.put("status","202");
        return result;
    }

    /**
     * 是否子集是否含有按钮
     * @param sysMenu
     * @return
     */
    public Boolean hasF(SysMenu sysMenu){
        List<SysMenu> list = sysMenuService.getMenuChildren(sysMenu);
        for (SysMenu menu : list) {
            if (menu.getMenuType().equals("F")){
                //查询到按钮
                return true;
            }
        }
        return false;
    }

    /**
     * 条件成立 新增
     * @param sysMenu
     * @return
     */
    public Map<String, Object> add(SysMenu sysMenu , Map<String,Object> result){
        //新增
        sysMenu.setChildren(null);
        sysMenu.setCreateTime(new Date());
        Integer i = sysMenuService.addMenu(sysMenu);
        if (i==1) {
            result.put("status", 200);
            result.put("success", true);
            result.put("msg", "成功");
            return result;
        }
        result.put("status", 201);
        result.put("success", false);
        result.put("msg", "失败");
        return result;
    }


    /**
     * 修改数据
     *
     * @param sysMenu 实体对象
     * @return 修改结果
     */
    @PutMapping("updateMenu")
    public Map<String,Object> update(@RequestBody SysMenu sysMenu) {
        Map<String, Object> result = new HashMap<>();
        Boolean cName = sysMenuService.checkName(sysMenu.getMenuName(), sysMenu.getMenuId() + "", sysMenu.getParentId() + "");
        Boolean cPath = sysMenuService.checkPath(sysMenu.getMenuName(), sysMenu.getMenuId() + "");
        //判断是否重复
        if (cName == false) {
            result.put("status", 201);
            result.put("success", false);
            result.put("msg", "菜单名重复");
            return result;
        }
        if (cPath == false) {
            result.put("status", 201);
            result.put("success", false);
            result.put("msg", "路径名重复");
            return result;
        }
        //没有重复可以修改


        //修改当前菜单
        Integer i = sysMenuService.updateMenu(sysMenu);
        if (i==1){
            result.put("status",200);
            result.put("success",true);
            result.put("msg","成功");
            return result;
        }
        result.put("status", 201);
        result.put("success", false);
        result.put("msg", "失败");
        return result;
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
//    @DeleteMapping
//    public R delete(@RequestParam("idList") List<Long> idList) {
//        return success(this.sysMenuService.removeByIds(idList));
//    }

}

