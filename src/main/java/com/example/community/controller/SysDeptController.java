package com.example.community.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.entity.SysDept;
import com.example.community.entity.SysUser;
import com.example.community.log.BusinessType;
import com.example.community.log.Log;
import com.example.community.service.SysDeptService;
import com.example.community.service.SysDictDataService;
import com.example.community.utils.DeptTree;
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
 * 部门表(SysDept)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
@Api(tags = "部门管理")
@RestController
@RequestMapping("sysDept")
@CrossOrigin
public class SysDeptController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysDeptService sysDeptService;

    @Resource
    private SysDictDataService sysDictDataService;

    //状态
    @GetMapping("/deptStatusOption")
    public R statusOption() {
        return success(this.sysDictDataService.deptStatusOption());
    }




    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param sysDept 查询实体
     * @return 所有数据
     */

    @GetMapping("selectAll")
    public R selectAll(Page<SysDept> page, SysDept sysDept) {
        return success(this.sysDeptService.page(page, new QueryWrapper<>(sysDept)));
    }



    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "查询单个部门接口",notes = "查询单个部门接口的说明")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysDeptService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysDept 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysDept sysDept) {
        return success(this.sysDeptService.save(sysDept));
    }

    /**
     * 修改数据
     *
     * @param sysDept 实体对象
     * @return 修改结果
     */
//    @PutMapping
//    public R update(@RequestBody SysDept sysDept) {
//        return success(this.sysDeptService.updateById(sysDept));
//    }

    /**
     * 删除部门
     * @param deptId
     * @return
     */
    @Log(title = "部门管理", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除部门接口",notes = "删除部门接口的说明")
    @DeleteMapping("/delete/{deptId}")
    public Map<String,Object> deleteDept(@PathVariable String deptId){
        Map<String, Object> map = new HashMap<>();
        //查询是否有子集
        List<SysDept> children = sysDeptService.isChildren(deptId);
        if (children.size()!=0){
            //存在子集不能删除
            map.put("msg","删除失败,此类型下有其他部门");
            map.put("status","201");
            return map;
        }
        //查询是否有用户
        List<SysUser> user = sysDeptService.isUser(deptId);
        if (user.size()!=0){
            //存在员工不能删除
            map.put("msg","删除失败,此类型下有用户");
            map.put("status","201");
            return map;
        }
        Integer integer = sysDeptService.deleteDept(deptId);
        if (integer==1){
            map.put("msg","删除成功");
            map.put("status","200");
            return map;
        }else {
            map.put("msg","删除失败");
            map.put("status","201");
            return map;
        }
    }
    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysDeptService.removeByIds(idList));
    }

    /**
     * 获取列表
     * @param sysDept
     * @return
     */
    /**
     * 获取列表
     * @param sysDept
     * @return
     */
    @ApiOperation(value = "部门列表分页接口",notes = "部门列表分页接口的说明")
    @PostMapping("getDeptList")
    public Map<String,Object> getMenuList(@RequestBody SysDept sysDept){
        Map<String,Object> result = new HashMap<>();
        List<SysDept> sysDeptList = sysDeptService.selAllDept(sysDept);
        int len = sysDeptList.size();
        for(int i = 0; i < len; i++){
            int count = 0 ;
            for(int j = 0; j < len; j++){
                if(sysDeptList.get(i).getParentId().equals(sysDeptList.get(j).getDeptId())){
                    count++;
                }
            }
            if(count==0){
                sysDeptList.get(i).setParentId(0L);
            }
        }
        DeptTree deptTree = new DeptTree(sysDeptList);
        System.err.println(deptTree);
        List<SysDept> sysDepts = deptTree.builTree();
        result.put("menuList",sysDepts);
        result.put("msg","获取成功");
        System.err.println(result);
        return result;
    };

    //表单中的部门列表
    @ApiOperation(value = "获取树状部门接口",notes = "获取树状部门接口的说明")
    @PostMapping("treeDeptList")
    public Map<String,Object> treeMenuList(@RequestBody SysDept sysDept){
        Map<String,Object> result = new HashMap<>();
        List<SysDept> sysDeptList = sysDeptService.getDeptLists(sysDept);
        int len = sysDeptList.size();
        for(int i = 0; i < len; i++){
            int count = 0 ;
            for(int j = 0; j < len; j++){
                if(sysDeptList.get(i).getParentId().equals(sysDeptList.get(j).getDeptId())){
                    count++;
                }
            }
            if(count==0){
                sysDeptList.get(i).setParentId(0L);
            }
        }
        DeptTree deptTree = new DeptTree(sysDeptList);
        List<SysDept> sysDepts = deptTree.builTree();
        result.put("menuList",sysDepts);
        result.put("msg","获取成功");
        System.err.println(result);
        return result;
    }

    //表单中的部门列表
    @ApiOperation(value = "获取树状部门接口",notes = "获取树状部门接口的说明")
    @PostMapping("treeDeptLists")
    public Map<String,Object> treeMenuLists(@RequestBody SysDept sysDept){
        Map<String,Object> result = new HashMap<>();
        List<SysDept> sysDeptList = sysDeptService.getDept(sysDept);
        int len = sysDeptList.size();
        for(int i = 0; i < len; i++){
            int count = 0 ;
            for(int j = 0; j < len; j++){
                if(sysDeptList.get(i).getParentId().equals(sysDeptList.get(j).getDeptId())){
                    count++;
                }
            }
            if(count==0){
                sysDeptList.get(i).setParentId(0L);
            }
        }
        DeptTree deptTree = new DeptTree(sysDeptList);
        List<SysDept> sysDepts = deptTree.builTree();
        result.put("menuList",sysDepts);
        result.put("msg","获取成功");
        System.err.println(result);
        return result;
    }

    @Log(title = "部门管理", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增部门接口",notes = "新增部门接口的说明")
    @PostMapping("addDept")
    public Map<String,Object>insertDept(@RequestBody SysDept sysDept){
        Map<String, Object> result = new HashMap<>();

        List<SysDept> deptList = sysDeptService.selectRoleName(sysDept.getParentId());
        boolean isDuplicate = false;
        for (SysDept dept : deptList) {
            if (dept.getDeptName().equals(sysDept.getDeptName())) {
                isDuplicate = true;
                break;
            }
        }
        if (isDuplicate) {
            result.put("status", 201);
            result.put("success", false);
            result.put("msg", "同一级别下部门名重复");
            return result;
        }
        //开始新增
        SysDept parent = sysDeptService.getByDept(sysDept.getParentId()+"");
        String ancestors = parent.getAncestors()+","+parent.getDeptId();
        sysDept.setAncestors(ancestors);
        sysDeptService.insertDept(sysDept);
        result.put("msg","新增成功");
        result.put("status", 200);
        result.put("success", true);
        return result;
    }

    @Log(title = "部门管理", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改部门接口",notes = "修改部门接口的说明")
    @PutMapping("updateDept")
    public Map<String, Object> update(@RequestBody SysDept sysDept) {
        Map<String, Object> result = new HashMap<>();
        System.err.println(sysDept);
        Boolean t = sysDeptService.checkName(sysDept.getDeptName(), sysDept.getDeptId() + "", sysDept.getParentId() + "");
        if (!t){
            result.put("status", 201);
            result.put("success", false);
            result.put("msg", "同一级别下部门名重复");
            return result;
        }
        // 执行部门更新逻辑...
        sysDeptService.updateDept(sysDept);
        sysDeptService.updateDeptlis(sysDept.getStatus(),sysDept.getDeptId());
        result.put("msg", "修改成功");
        result.put("status", 200);
        result.put("success", true);
        return result;
    }




}

