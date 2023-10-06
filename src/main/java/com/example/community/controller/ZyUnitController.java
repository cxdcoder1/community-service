package com.example.community.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.dto.UnitAndCommunityAndBuilding;
import com.example.community.entity.SysDictData;
import com.example.community.entity.ZyCommunity;
import com.example.community.entity.ZyRoom;
import com.example.community.entity.ZyUnit;
import com.example.community.service.ZyUnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单元 (ZyUnit)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@Api(tags = "单元管理")
@RestController
@RequestMapping("zyUnit")
@CrossOrigin
public class ZyUnitController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ZyUnitService zyUnitService;

    /**
     * 分页查询单元信息
     *
     * @param page 分页对象
     *
     * @return 所有数据
     */
    @ApiOperation(value = "获取单元列表接口",notes = "获取单元列表接口的说明")
    @GetMapping("getUnits")
    public R selectAll(Page<UnitAndCommunityAndBuilding> page, UnitAndCommunityAndBuilding unitAndCommunityAndBuilding) {

        return success(this.zyUnitService.getUnitList(page, unitAndCommunityAndBuilding));
    }


    /**
     * 添加单元
     * @param zyUnit
     * @return
     */
    @ApiOperation(value = "添加单元接口",notes = "添加单元接口的说明")
    @PostMapping("addUnit")
    public Map<String, Object> addUnit(@RequestBody ZyUnit zyUnit) {
        HashMap<String, Object> result = new HashMap<>();
        //验重
        zyUnit.setCreateTime(new Date());
        Boolean t1 = zyUnitService.checkUName(zyUnit);
        if (!t1){
            result.put("status",201);
            result.put("msg","新增失败单元名称重复");
            return result;
        }
        if (zyUnit.getUnitCode()!=null){
            Boolean t2 = zyUnitService.checkCode(zyUnit);
            if (!t2){
                result.put("status",201);
                result.put("msg","新增失败单元编号重复");
                return result;
            }
        }
        //新增操作
        Integer save = zyUnitService.addUnit(zyUnit);
        if (!save.equals(0)){
            result.put("status",200);
            result.put("msg","新增成功");
            return result;
        }else {
            result.put("status",201);
            result.put("msg","新增失败");
            return result;
        }
    }

    @ApiOperation(value = "修改单元接口",notes = "修改单元接口的说明")
    @PostMapping("updateUnit")
    public Map<String, Object> updateUnit(@RequestBody ZyUnit zyUnit) {
        HashMap<String, Object> result = new HashMap<>();
        //验重
        Boolean t1 = zyUnitService.checkUName(zyUnit);
        if (!t1){
            result.put("status",201);
            result.put("msg","修改失败单元名称重复");
            return result;
        }
        if (zyUnit.getUnitCode()!=null){
            Boolean t2 = zyUnitService.checkCode(zyUnit);
            if (!t2){
                result.put("status",201);
                result.put("msg","修改失败单元编号重复");
                return result;
            }
        }

        //修改
        Integer b = zyUnitService.updateUnit(zyUnit);
        if (!b.equals(0)){
            result.put("status",200);
            result.put("msg","修改成功");
            return result;
        }
        result.put("status",201);
        result.put("msg","修改失败");
        return result;
    }

    /**
     * 删除单个单元
     * @param id
     * @return
     */
    @ApiOperation(value = "删除单元接口",notes = "删除单元接口的说明")
    @GetMapping("delUnit/{id}")
    public Map<String, Object> delUnit(@PathVariable("id") String id) {
        HashMap<String, Object> result = new HashMap<>();

        //验证是否能删除
        List<ZyRoom> byUnit = zyUnitService.getByUnit(id);
        if (byUnit.size()!=0){
            result.put("status",201);
            result.put("msg","删除失败,此单元下还有房间");
            return result;
        }
        //删除
        Integer i = zyUnitService.delById(id);
        if (i!=1){
            result.put("status",201);
            result.put("msg","删除失败");
            return result;
        }else {
            result.put("status",200);
            result.put("msg","删除成功");
            return result;
        }
    }

    /**
     * 删除多个单元
     * @param list
     * @return
     */
    @ApiOperation(value = "批量删除单元接口",notes = "批量删除单元接口的说明")
    @PostMapping("delUnits")
    public HashMap<String, Object> delUnits(@RequestBody List<String> list) {
        HashMap<String, Object> map = new HashMap<>();

        //验证是否能删除
        List<ZyRoom> byUnit = zyUnitService.getByUnits(list);
        System.out.println(list);
        if (byUnit.size()!=0){
            map.put("status",201);
            map.put("msg","删除失败,单元下还有房间");
            return map;
        }


        Integer i = zyUnitService.delUnits(list);
        if (i!=0){
            map.put("status","200");
            map.put("msg","删除成功");
        }else {
            map.put("status","201");
            map.put("msg","删除失败");
        }
        return map;
    }

    /**
     * 获取电梯状态字典
     * @param id
     * @return
     */
    @ApiOperation(value = "获取电梯状态字典接口",notes = "获取电梯状态字典接口的说明")
    @GetMapping("getElevatorStatus/{id}")
    public HashMap<String, Object> getElevatorStatus(@PathVariable("id") String id) {
        HashMap<String, Object> result = new HashMap<>();
        List<SysDictData> statusList = zyUnitService.statusList(id);
        result.put("statusList",statusList);
        return result;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.zyUnitService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param zyUnit 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ZyUnit zyUnit) {
        return success(this.zyUnitService.save(zyUnit));
    }

    /**
     * 修改数据
     *
     * @param zyUnit 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ZyUnit zyUnit) {
        return success(this.zyUnitService.updateById(zyUnit));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.zyUnitService.removeByIds(idList));
    }
}

