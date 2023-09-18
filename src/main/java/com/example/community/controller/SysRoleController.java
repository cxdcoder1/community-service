package com.example.community.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.entity.SysMenu;
import com.example.community.entity.SysRole;
import com.example.community.service.SysRoleService;
import com.example.community.utils.MenuTree;
import org.apache.ibatis.session.RowBounds;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private SysRoleService sysRoleService;

    /**
     * 新增角色
     * @param role
     * @return
     */
    @GetMapping("insertRole")
    public Map<String, Object> insertRole(SysRole role){
        Map<String, Object> map = new HashMap<>();
        Integer integer = sysRoleService.selectRoleName(role.getRoleName());
        if (integer==0){
            int i = sysRoleService.insertRole(role);
            map.put("msg","新增成功");
            map.put("status", 200);
            map.put("success", true);
            return map;
        }
           map.put("msg","角色名重复");
           map.put("status", 201);
           map.put("success", false);
           return map;
    }

    @GetMapping("/list")
    public List<SysRole> list(SysRole role) {
        List<SysRole> list = sysRoleService.selectRoleList(role);
        return list;
    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param sysRole 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysRole> page, SysRole sysRole) {
        return success(this.sysRoleService.page(page, new QueryWrapper<>(sysRole)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysRoleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysRole 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysRole sysRole) {
        return success(this.sysRoleService.save(sysRole));
    }

    /**
     * 修改数据
     *
     * @param sysRole 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysRole sysRole) {
        return success(this.sysRoleService.updateById(sysRole));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysRoleService.removeByIds(idList));
    }

    /**
     * 修改保存角色
     */
    @PutMapping("edit")
    public String edit(@Validated @RequestBody SysRole role) {
        int i = sysRoleService.updateRole(role);
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
        List<SysMenu> menus = sysRoleService.getRoleMenuTreeselect(roleId);
        List<SysMenu> menuList = new MenuTree(menus).builTree();
        if (menuList != null && !menuList.isEmpty()) {
            System.out.println(menuList);
            return R.ok(menuList);
        }
        System.err.println(R.ok(menus));

        return R.ok(menus);
    }
}

