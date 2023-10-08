package com.example.community.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.entity.ZyBuilding;
import com.example.community.log.BusinessType;
import com.example.community.log.Log;
import com.example.community.service.ZyBuildingService;
import com.example.community.service.ZyCommunityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 楼栋 (ZyBuilding)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Api(tags = "楼栋管理")
@RestController
@RequestMapping("zyBuilding")
@CrossOrigin
public class ZyBuildingController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ZyBuildingService zyBuildingService;

    @Resource
    private ZyCommunityService zyCommunityService;


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param zyBuilding 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ZyBuilding> page, ZyBuilding zyBuilding) {
        return success(this.zyBuildingService.page(page, new QueryWrapper<>(zyBuilding)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.zyBuildingService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param zyBuilding 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ZyBuilding zyBuilding) {
        return success(this.zyBuildingService.save(zyBuilding));
    }

    /**
     * 修改数据
     *
     * @param zyBuilding 实体对象
     * @return 修改结果
     */

    @PutMapping
    public R update(@RequestBody ZyBuilding zyBuilding) {
        return success(this.zyBuildingService.updateById(zyBuilding));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.zyBuildingService.removeByIds(idList));
    }
    /**
     * 获取小区列表
     * @return
     */
    @ApiOperation(value = "获取小区列表接口",notes = "获取小区列表接口的说明")
    @GetMapping("getCommunityList")
    public R getCommunityList(){
        System.err.println(this.zyCommunityService.getCommunityList());
        return success(this.zyCommunityService.getCommunityList());
    }

    @ApiOperation(value = "获取楼栋列表接口",notes = "获取楼栋列表接口的说明")
    @GetMapping("buildingList")
    public R selectPageAll(Page<ZyBuilding> page, ZyBuilding zyBuilding,long communityId) {
        return success(this.zyBuildingService.buildingList(page,zyBuilding,communityId));
    }

    @ApiOperation(value = "添加楼栋接口",notes = "添加楼栋接口的说明")
    @Log(title = "楼栋管理", businessType = BusinessType.INSERT)
    @GetMapping("insertBuilding")
    public  Map<String, Object> insertBuilding(ZyBuilding zyBuilding){
        Map<String, Object> map = new HashMap<>();
        Boolean aBoolean = zyBuildingService.addBuilding(zyBuilding);
        System.err.println(zyBuilding);
        if (aBoolean){
            map.put("msg","新增成功");
            map.put("status", 200);
            map.put("success", true);
            return map;
        }

        map.put("msg","楼栋名重复");
        map.put("status", 201);
        map.put("success", false);
        return map;
    }

    @ApiOperation(value = "修改楼栋接口",notes = "修改楼栋接口的说明")
    @Log(title = "楼栋管理", businessType = BusinessType.UPDATE)
    @PutMapping("updateBuilding/{communityId}")
    public Map<String, Object> updateBuilding(@PathVariable long communityId,@RequestBody ZyBuilding zyBuilding){
        System.err.println(communityId);
        System.err.println(zyBuilding);
        Map<String, Object> map = new HashMap<>();
        Long aLong = zyBuildingService.selName(communityId,zyBuilding);
        System.err.println(zyBuilding.toString());
        if (aLong==0){
            int i=zyBuildingService.updateBuilding(zyBuilding);
            map.put("msg","修改成功");
            map.put("status", 200);
            map.put("success", true);
            return map;
        }
        map.put("msg","楼栋名重复");
        map.put("status", 201);
        map.put("success", false);
        return map;
    }

    @ApiOperation(value = "删除楼栋接口",notes = "删除楼栋接口的说明")
    @Log(title = "删除楼栋", businessType = BusinessType.DELETE)
    @DeleteMapping("delBuilding/{id}")
    public Map<String, Object> delBuilding(@PathVariable Long id){
        Map<String, Object> map = new HashMap<>();
        Long unitName = zyBuildingService.getUnitName(id);
        if (unitName==0){
            zyBuildingService.delBuilding(id);
            map.put("msg","删除成功");
            map.put("status", 200);
            map.put("success", true);
            return map;
        }
        map.put("msg","该楼栋下有单元无法删除");
        map.put("status", 201);
        map.put("success", false);
        return map;
    }

    @ApiOperation(value = "批量删除楼栋接口",notes = "批量删除楼栋接口的说明")
    @Log(title = "删除楼栋", businessType = BusinessType.DELETE)
    @PostMapping("deletes")
    public Map<String,Object> deletes(@RequestBody Long[] ids){
        Map<String,Object> result = new HashMap<>();
        boolean deletes = zyBuildingService.deletesBuilding(ids);
        if(deletes){
            result.put("status",200);
            result.put("msg","删除成功");
        }else{
            result.put("status",201);
            result.put("msg","删除的楼栋下绑定了单元,删除失败");
        }
        return result;
    }

    /**
     * 根据小区id获取楼栋信息
     * @return
     */
    @ApiOperation(value = "根据小区id获取楼栋接口",notes = "根据小区id获取楼栋接口的说明")
    @GetMapping("getUBuild/{communityId}")
    public Map<String, Object> getUBuild(@PathVariable("communityId") String communityId) {
        HashMap<String, Object> result = new HashMap<>();
        List<ZyBuilding> uBuild = zyBuildingService.getUBuild(communityId);
        result.put("buildList",uBuild);
        return result;
    }
}

