package com.example.community.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.entity.SysMenu;
import com.example.community.log.BusinessType;
import com.example.community.log.Log;
import com.example.community.service.SysDictDataService;
import com.example.community.service.SysMenuService;
import com.example.community.utils.MenuTree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "菜单管理")
@RestController
@RequestMapping("sysMenu")
@CrossOrigin
public class SysMenuController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;

    @Resource
    private SysDictDataService sysDictDataService;

    //状态
    @GetMapping("/menuStatusOption")
    public R statusOption() {
        return success(this.sysDictDataService.menuStatusOption());
    }

    //显示
    @GetMapping("/menuShowsOption")
    public R menuShowsOption() {
        return success(this.sysDictDataService.menuShowOption());
    }

    @ApiOperation(value = "获取菜单列表接口",notes = "获取菜单列表接口的说明")
    @PostMapping("/menuList")
    public R menuList(@RequestBody SysMenu sysMenu) {
        List<SysMenu> menus = sysMenuService.getMenuList(sysMenu.getMenuName(), sysMenu.getStatus());
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

    @ApiOperation(value = "获取树形菜单列表接口",notes = "获取树形菜单列表接口的说明")
    @GetMapping("getTreeMenu/{id}")
    public R MenuTreeList(@PathVariable int id) {
        if (id == 1) {
            return success(this.sysMenuService.MenuList());
        } else {
            return success(this.sysMenuService.MenuTree(id));
        }
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



    @Log(title = "菜单管理", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除菜单接口",notes = "删除菜单接口的说明")
    @RequestMapping("deleteMenu")
    public Map<String, Object> deleteMenu(@RequestBody SysMenu sysMenu) {
        Map<String, Object> map = new HashMap<>();
        System.err.println(sysMenu.toString());
        String s = sysMenuService.deleteMenu(sysMenu.getMenuId(), null);
        map.put("data", s);
        System.out.println(map);
        return map;
    }

    /**
     * 新增数据
     *
     * @param sysMenu 实体对象
     * @return 新增结果
     */
    @Log(title = "菜单管理", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增菜单接口",notes = "新增菜单接口的说明")
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
        if (parent == null) {
            //没有父类
            if (sysMenu.getMenuType().equals("M")) {
                //必须是目录才可以添加
                return add(sysMenu, result);
            } else {
                //不是目录不可以添加
                result.put("status", 201);
                result.put("success", false);
                result.put("msg", "没有父类目录的菜单添加只能添加目录类型");
                return result;
            }
        }
        if (parent.getMenuType().equals("F")) {
            //父类是按钮 不能添加
            result.put("status", 201);
            result.put("success", false);
            result.put("msg", "不能在按钮下添加菜单");
            return result;
        }

        //判断父为目录 子为按钮时 不能添加
        if (parent.getMenuType().equals("M") && sysMenu.getMenuType().equals("F")) {
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
                    sysMenuService.upTypeToM(parent);
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
                    sysMenuService.upTypeToM(sysMenu);
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
        result.put("msg", "其他");
        result.put("status", "202");
        return result;
    }

    /**
     * 是否子集是否含有按钮
     *
     * @param sysMenu
     * @return
     */
    public Boolean hasF(SysMenu sysMenu) {
        List<SysMenu> list = sysMenuService.getMenuChildren(sysMenu);
        for (SysMenu menu : list) {
            if (menu.getMenuType().equals("F")) {
                //查询到按钮
                return true;
            }
        }
        return false;
    }

    /**
     * 条件成立 新增
     *
     * @param sysMenu
     * @return
     */
    public Map<String, Object> add(SysMenu sysMenu, Map<String, Object> result) {
        //新增
        sysMenu.setChildren(null);
        sysMenu.setCreateTime(new Date());
        Integer i = sysMenuService.addMenu(sysMenu);
        if (i == 1) {
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
    @Log(title = "菜单管理", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改菜单接口",notes = "修改菜单接口的说明")
    @PutMapping("updateMenu")
    public Map<String, Object> update(@RequestBody SysMenu sysMenu) {
        Map<String, Object> result = new HashMap<>();
        //判断父类是否是自己
        if (sysMenu.getMenuId().equals(sysMenu.getParentId())) {
            //修改的父类为自己 不可修改
            result.put("status", 201);
            result.put("success", false);
            result.put("msg", "不可以把上级菜单置为自己");
            return result;
        }
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
        //获取修改后菜单的父类
        SysMenu parent = sysMenuService.getParent(sysMenu);

        if (parent == null) {
            //没有父类
            if (sysMenu.getMenuType().equals("M")) {
                //子类必须是目录才可以修改
                return up(sysMenu, result);
            } else {
                //子类不是目录不可以修改
                result.put("status", 201);
                result.put("success", false);
                result.put("msg", "只有目录才可以修改到最高级");
                return result;
            }
        }
        if (parent.getMenuType().equals("F")) {
            //父类是按钮 不能修改
            result.put("status", 201);
            result.put("success", false);
            result.put("msg", "不能修改菜单到按钮下");
            return result;
        }

        //判断父为目录 子为按钮时 不能修改
        if (parent.getMenuType().equals("M") && sysMenu.getMenuType().equals("F")) {
            result.put("status", 201);
            result.put("success", false);
            result.put("msg", "不能修改按钮到目录下");
            return result;
        } else if (parent.getMenuType().equals("M")) {
            return up(sysMenu, result);
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
                    result.put("msg", "不能把目录修改到有按钮的菜单下面");
                    return result;
                } else {
                    //没有按钮
                    //把父集提升为目录
                    sysMenuService.upTypeToM(parent);
                    return up(sysMenu, result);
                }
            }
            if (sysMenu.getMenuType().equals("C")) {
                //子为菜单
                if (t) {
                    //含有按钮
                    result.put("status", 201);
                    result.put("success", false);
                    result.put("msg", "不能把菜单修改到有按钮的菜单下");
                    return result;
                } else {
                    //没有按钮
                    //把父集提升为目录
                    sysMenuService.upTypeToM(sysMenu);
                    return up(sysMenu, result);
                }
            }
            if (sysMenu.getMenuType().equals("F")) {
                //子为按钮时
                return up(sysMenu, result);
            }
        }
        //父为按钮
        if (parent.getMenuType().equals("F")) {
            result.put("status", 201);
            result.put("success", false);
            result.put("msg", "不能修改到按钮下");
            return result;
        }
        result.put("msg", "其他");
        result.put("status", "202");
        return result;
    }

    /**
     * 条件成立 修改
     *
     * @param sysMenu
     * @param result
     * @return
     */
    public Map<String, Object> up(SysMenu sysMenu, Map<String, Object> result) {
        Integer i = sysMenuService.updateMenu(sysMenu);
        System.err.println("ccccccccccc"+sysMenu.getMenuId());

        if (i == 1) {
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

