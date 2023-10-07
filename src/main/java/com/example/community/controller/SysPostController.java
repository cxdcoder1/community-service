package com.example.community.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.entity.SysDept;
import com.example.community.entity.SysPost;
import com.example.community.log.BusinessType;
import com.example.community.log.Log;
import com.example.community.service.SysDictDataService;
import com.example.community.service.SysPostService;
import com.example.community.service.SysUserPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 岗位信息表(SysPost)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Api(tags = "岗位管理")
@RestController
@RequestMapping("sysPost")
@CrossOrigin
public class SysPostController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysPostService sysPostService;


    @Resource
    private SysUserPostService sysUserPostService;

    @Resource
    private SysDictDataService sysDictDataService;

    //状态
    @GetMapping("/postStatusOption")
    public R statusOption() {
        return success(this.sysDictDataService.postStatusOption());
    }
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param sysPost 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysPost> page, SysPost sysPost) {
        return success(this.sysPostService.page(page, new QueryWrapper<>(sysPost)));
    }

    /**
     * 分页加条件查询
     * @param page
     * @param sysPost
     * @return
     */
    @ApiOperation(value = "获取岗位列表接口",notes = "获取岗位列表接口的说明")
    @GetMapping("postList")
    public R selectPost(Page<SysPost>page,SysPost sysPost){
        return success(this.sysPostService.postList(page,sysPost));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysPostService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysPost 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "新增岗位接口",notes = "新增岗位接口的说明")
    @PostMapping
    public R insert(@RequestBody SysPost sysPost) {
        return success(this.sysPostService.save(sysPost));
    }

    /**
     * 修改数据
     *
     * @param sysPost 实体对象
     * @return 修改结果
     */

    @PutMapping
    public R updatea(@RequestBody SysPost sysPost) {
        return success(this.sysPostService.updateById(sysPost));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysPostService.removeByIds(idList));
    }

    /**
     * 新增岗位
     * @param sysPost
     * @return
     * @throws Exception
     */
    @Log(title = "岗位管理", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增岗位接口",notes = "新增岗位接口的说明")
    @GetMapping("insertPost")
    public Map<String, Object>insertPost(SysPost sysPost) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Integer integer = sysPostService.selName(sysPost);
        if (integer!=0){
            map.put("status", 201);
            map.put("success", false);
            map.put("msg", "编码或者名字重复");
            return map;
        }
        int i = sysPostService.insertPost(sysPost);
        map.put("msg","新增成功");
        map.put("status", 200);
        map.put("success", true);
        return map;
    }

    /**
     * 修改岗位
     * @param sysPost
     * @return
     */
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改岗位接口",notes = "修改岗位接口的说明")
    @PutMapping("updatePosts")
    public Map<String, Object> update(@RequestBody SysPost sysPost) {
        Map<String, Object> map = new HashMap<>();
        Integer integer = sysPostService.selName(sysPost);
        if (integer==0){
            int i = sysPostService.update(sysPost);
            map.put("msg","修改成功");
            map.put("status", 200);
            map.put("success", true);
            return map;
        }
        map.put("status", 201);
        map.put("success", false);
        map.put("msg", "编码或者名字重复");
        return map;
    }

    /**
     * 单个删除
     * @param postId
     * @return
     */
    @Log(title = "岗位管理", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除岗位接口",notes = "删除岗位接口的说明")
    @DeleteMapping("delPost/{postId}")
    public Map<String ,Object> delPost(@PathVariable Integer postId){
        Map<String, Object> map = new HashMap<>();
        Integer integer = sysUserPostService.setUserPost(postId);
        if (integer!=0){
            map.put("status", 201);
            map.put("success", false);
            map.put("msg", "该岗位下有员工不能删除");
            return map;
        }
        sysPostService.delPost(postId);
        map.put("msg","删除成功");
        map.put("status", 200);
        map.put("success", true);
        return map;
    }

    /**
     * 批量删除
     * @param
     * @return
     */
    @Log(title = "岗位管理", businessType = BusinessType.DELETE)
    @ApiOperation(value = "批量删除岗位接口",notes = "批量删除岗位接口的说明")
    @PostMapping("deletes")
    public Map<String,Object> deletes(@RequestBody int[] ids){
        Map<String,Object> result = new HashMap<>();
        boolean deletes = sysPostService.deletes(ids);
        if(deletes){
            result.put("status",200);
            result.put("msg","删除成功");
        }else{
            result.put("status",400);
            result.put("msg","删除的岗位中绑定了个人信息,删除失败");
        }
        return result;
    }


}

