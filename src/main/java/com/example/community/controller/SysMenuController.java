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
        List<SysMenu> menus = sysMenuService.getMenuList(sysMenu.getMenuName(),sysMenu.getStatus());
        List<SysMenu> menuList = new MenuTree(menus).builTree();

        if (menuList != null && !menuList.isEmpty()) {
            System.out.println(menuList);
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

