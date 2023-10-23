package com.example.community.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.config.CustomAnnotation;
import com.example.community.dto.RolesAndMenuIds;
import com.example.community.entity.SysMenu;
import com.example.community.entity.SysRole;
import com.example.community.entity.SysRoleMenu;
import com.example.community.entity.SysUserRole;
import com.example.community.log.BusinessType;
import com.example.community.log.Log;
import com.example.community.service.SysDictDataService;
import com.example.community.service.SysRoleService;
import com.example.community.service.SysUserRoleService;
import com.example.community.utils.MenuTree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色信息表(SysRole)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Api(tags = "角色管理")
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
     * 用户角色关联服务对象
     */
    @Resource
    private SysUserRoleService sysUserRoleService;


    @Resource
    private SysDictDataService sysDictDataService;
    /**
     * 状态
     *
     * @param
     */
    @CustomAnnotation("system:role:edit")
    @ApiOperation(value = "修改角色状态接口",notes = "修改角色状态接口的说明")
    @PutMapping("upDataStatus")
    public R upDataStatus(@RequestParam("status") String status, @RequestParam("roleId") int roleId) {
        return success(this.sysRoleService.upDataStatus(roleId,status));
    }

    /**
     * 新增角色
     * @param
     * @return
     */
    @CustomAnnotation("system:role:add")
    @Log(title = "角色管理", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增角色接口",notes = "新增角色接口的说明")
    @PostMapping("insertRole")
    public Map<String, Object> insertRole(@RequestBody RolesAndMenuIds rolesAndMenuIds){
        Map<String, Object> map = new HashMap<>();
        SysRole sysRole = sysRoleService.selectRoleName(rolesAndMenuIds.getRoleName());
//
        if (sysRole!=null){
            //重复
            map.put("msg","角色名重复");
            map.put("status", 201);
            map.put("success", false);
            return map;
        }
//        if (sysRole.getRoleName().equals(role.getRoleName())){
//        }
        Integer integer1 = sysRoleService.insertRole(rolesAndMenuIds);
        map.put("msg","新增成功");
        map.put("status", 200);
        map.put("success", true);
        //获取新增角色的主键
        return map;

    }

    @CustomAnnotation("system:role:list")
    @ApiOperation(value = "获取角色列表接口",notes = "获取角色列表接口的说明")
    @GetMapping("list")
    public R selectPageAll(Page<SysRole> page, SysRole sysRole) {

        return success(this.sysRoleService.roleList(page, sysRole));
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

    @CustomAnnotation("system:role:edit")
    @ApiOperation(value = "修改角色接口",notes = "修改角色接口的说明")
    @PutMapping("edit")
    public Map<String, Object> edit(@RequestBody RolesAndMenuIds rolesAndMenuIds) {
        Map<String, Object> map = new HashMap<>();
        SysRole sysRole = sysRoleService.selectRoleName(rolesAndMenuIds.getRoleName());
        if (sysRole!=null){
            if (!sysRole.getRoleId().equals(rolesAndMenuIds.getRoleId())){
                //重复
                map.put("msg","角色名重复");
                map.put("status", 201);
                map.put("success", false);
                return map;
            }
        }

        sysRoleService.updateRole(rolesAndMenuIds);
        map.put("msg","修改成功");
        map.put("status", 200);
        map.put("success", true);
        return map;
    }

    /**
     * 修改保存数据权限
     */
//    @PutMapping("/dataScope")
//    public String dataScope(@RequestBody SysRole role) {
//        roleService.
//    }

    @RequestMapping("getRoleMenuTreeselect")
    public R getRoleMenuTreeselect(Integer roleId) {
        List<SysMenu> menus = sysRoleService.getRoleMenuTreeselect(roleId);
        List<SysMenu> menuList = new MenuTree(menus).builTree();
        if (menuList != null && !menuList.isEmpty()) {

            return R.ok(menuList);
        }
        return R.ok(menus);
    }

    @RequestMapping("getRole")
    public R selectOne( SysRole sysRole) {
        return success(this.sysRoleService.getRoleById(sysRole.getRoleId()));
    }

    /**
     * 删除角色(设置del_flag为'2')
     * @param roleId
     * @return
     */
    @CustomAnnotation("system:role:remove")
    @Log(title = "角色管理", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除角色接口",notes = "删除角色接口的说明")
    @DeleteMapping("delete/{roleId}")
    public Map<String, Object> deleteRole(@PathVariable String roleId){
        Map<String, Object> map = new HashMap<>();
        //查询角色是否被分配
        List<SysUserRole> sysUserRoles = sysUserRoleService.roleIsUsed(roleId);
        if (sysUserRoles.size()!=0){
            //角色已经被分配
            map.put("msg","删除失败，角色已被分配");
            map.put("status","201");
            return map;
        }
        //删除角色
        Integer integer = sysRoleService.deleteRole(roleId);
        if (integer==1){
            //成功
            map.put("msg","成功删除");
            map.put("status","200");
            return map;
        }
        map.put("msg","删除失败");
        map.put("status","201");
        return map;
    }

    @RequestMapping("getMenuIds/{roleId}")
    public List getMenuIds(@PathVariable Long roleId){
        List<SysRoleMenu> sysRoleMenu = sysRoleService.getMenuIds(roleId);
        List<Long> menuIds = new ArrayList();
        for (SysRoleMenu menuId : sysRoleMenu) {
            menuIds.add(menuId.getMenuId());
        }
        return menuIds;
    }

    //状态
    @GetMapping("/roleStatusOption")
    public R statusOption() {
        return success(this.sysDictDataService.roleStatusOption());
    }
}

