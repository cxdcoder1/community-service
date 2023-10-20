package com.example.community.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.config.CustomAnnotation;
import com.example.community.entity.SysDictData;
import com.example.community.entity.SysDictType;
import com.example.community.service.SysDictDataService;
import com.example.community.service.SysDictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典类型表(SysDictType)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
@Api(tags = "字典类型管理")
@RestController
@RequestMapping("sysDictType")
@CrossOrigin
public class SysDictTypeController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysDictTypeService sysDictTypeService;

    @Resource
    private SysDictDataService sysDictDataService;

    //状态
    @GetMapping("/dictStatusOption")
    public R statusOption() {
        return success(this.sysDictDataService.dictStatusOption());
    }


    @CustomAnnotation("system:dict:list")
    //获取字典类型集合
    @ApiOperation(value = "获取字典类型集合接口",notes = "获取字典类型集合接口的说明")
    @GetMapping("getDictOptionselect")
    public HashMap<String, Object> getDictOptionselect() {
        List<SysDictType> dictOptionselect = sysDictTypeService.getDictOptionselect(null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", dictOptionselect);

        return map;
    }

    /**
     * 删除数据
     *
     * @param
     * @return 删除
     */
    @CustomAnnotation("system:dict:remove")
    @ApiOperation(value = "删除字典类型接口",notes = "删除字典类型接口的说明")
    @DeleteMapping("delType")
    public Map<String, Object> delType(@RequestBody List<Long> id, @RequestParam("type") List<String> type) {

        System.out.println(type);
        System.out.println(id);

        Map<String, Object> map = new HashMap<>();
        List<SysDictData> sysDictData = sysDictDataService.selectDataName(type);

        if (sysDictData.size() > 0) {
            map.put("msg", "该数据在别的地方存在");
            map.put("status", 201);
            map.put("success", false);
            return map;
        }

        sysDictTypeService.deleteDictType(id);
        map.put("msg", "删除成功");
        map.put("status", 200);
        map.put("success", true);
        return map;
    }

    //修改
    @CustomAnnotation("system:dict:edit")
    @ApiOperation(value = "修改字典类型接口",notes = "修改字典类型接口的说明")
    @PutMapping("updType")
    public Map<String, Object> updType(@RequestBody SysDictType sysDictType, @RequestParam("type") String type, @RequestParam("type2") String type2) {

        List<SysDictType> sysDictTypes = sysDictTypeService.selDictType(sysDictType.getDictName());
        SysDictType dictType = sysDictTypeService.getDictType(sysDictType.getDictType());
        Map<String, Object> map = new HashMap<>();

        if (sysDictTypes.size() == 0 || dictType == null) {
            sysDictDataService.updDictType(type, type2);
            sysDictTypeService.updDictType(sysDictType);
            map.put("msg", "修改成功");
            map.put("status", 200);
            map.put("success", true);
            return map;
        } else {
            SysDictType sysDictType1 = sysDictTypes.get(0);
            if (sysDictType1.getDictId().equals(sysDictType.getDictId()) && sysDictType1.getDictType().equals(sysDictType.getDictType())) {
                    sysDictDataService.updDictType(type, type2);
                    sysDictTypeService.updDictType(sysDictType);
                map.put("msg", "修改成功");
                map.put("status", 200);
                map.put("success", true);
                return map;
            }
        }
        map.put("msg", "重复参数");
        map.put("status", 201);
        map.put("success", false);
        return map;
    }

    @CustomAnnotation("system:dict:list")
    @GetMapping("selectDictType")
    public R selectDictType(Page<SysDictType> page, SysDictType sysDictType) {
        return success(this.sysDictTypeService.selectDictType(page, sysDictType));
    }

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param sysDictType 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysDictType> page, SysDictType sysDictType) {
        return success(this.sysDictTypeService.page(page, new QueryWrapper<>(sysDictType)));
    }

    @GetMapping("getDictType/{dictId}")
    public HashMap<String, Object> getDictType(@PathVariable Long dictId) {
        System.out.println("cxd" + dictId);
        List<SysDictType> dictOptionselect = sysDictTypeService.getDictOptionselect(dictId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", dictOptionselect.get(0));
        System.out.println("cccccccccccccc" + dictOptionselect.get(0));
        return map;
    }

    /**
     * 新增数据
     *
     * @param sysDictType 实体对象
     * @return 新增结果
     */
    @CustomAnnotation("system:dict:add")
    @ApiOperation(value = "新增字典类型接口",notes = "新增字典类型接口的说明")
    @PostMapping("insDictType")
    public Map<String, Object> insert(@RequestBody SysDictType sysDictType) {

        System.err.println(sysDictType.getDictType());
        System.err.println(sysDictType.getDictName());

        Map<String, Object> map = new HashMap<>();

        SysDictType sysDictType1 = sysDictTypeService.selectName(sysDictType.getDictName());
        SysDictType dictType = sysDictTypeService.getDictType(sysDictType.getDictType());

        if (sysDictType1 != null || dictType != null) {
            map.put("msg", "重复参数");
            map.put("status", 201);
            map.put("success", false);
            return map;
        }
        sysDictTypeService.insType(sysDictType);
//        try {
//            sysDictTypeService.insType(sysDictType);
//        } catch (Exception e) {
//            map.put("msg", sysDictType.getDictType() + "已存在");
//            map.put("status", 201);
//            map.put("success", false);
//            return map;
//        }
        map.put("msg", "添加成功");
        map.put("status", 200);
        map.put("success", true);
        return map;
    }

    /**
     * 修改数据
     *
     * @param sysDictType 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysDictType sysDictType) {
        return success(this.sysDictTypeService.updateById(sysDictType));
    }
    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @CustomAnnotation("system:dict:remove")
    @DeleteMapping("dleDelete")
    public Map<String, Object> delete(@RequestParam("idList") List<Long> idList, @RequestParam("type") List<String> type) {
//        System.out.println(type);
//        System.out.println(id);
        Map<String, Object> map = new HashMap<>();
        List<SysDictData> sysDictData = sysDictDataService.selectDataName(type);
        if (sysDictData.size() > 0) {
            map.put("msg", type + "在一个意想不到的地方存在");
            map.put("status", 201);
            map.put("success", false);
            return map;
        }
        sysDictTypeService.removeByIds(idList);
        map.put("msg", "删除成功");
        map.put("status", 200);
        map.put("success", true);
        return map;
    }
}

