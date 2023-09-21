package com.example.community.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.entity.SysDictData;
import com.example.community.service.SysDictDataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 字典数据表(SysDictData)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:01
 */
@RestController
@RequestMapping("sysDictData")
@CrossOrigin
public class SysDictDataController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysDictDataService sysDictDataService;

    @GetMapping("listdata")
    //根据条件获取字典数据
    public HashMap<String, Object> listData(Page page, SysDictData sysDictData) {
        HashMap<String, Object> map = new HashMap<>();
        System.err.println("当前页：" + page.getCurrent() + "" + page.getSize());
        System.out.println("test sysDictData" + sysDictData);
        //符合条件的列表
        List<SysDictData> data = sysDictDataService.getData(sysDictData, (page.getCurrent() - 1) * page.getSize(), page.getSize());

        //符合条件总数
        int count = sysDictDataService.getData(sysDictData, 0, 0).size();
//
//        // 计算总页数
//        int totalPages = (int) Math.ceil(count * 1.0 / page.getSize());
//        if (page.getCurrent() > totalPages) {
//            page.setCurrent(totalPages);
//        }
//
//        if(page.getCurrent()<=0){
//            page.setCurrent(1);
//        }

        map.put("count", count);
        map.put("data", data);
//        map.put("current", page.getCurrent());

        return map;
    }

    @RequestMapping("updateData")
    public HashMap<String, Object> updateData(@RequestBody SysDictData sysDictData) {
        HashMap<String, Object> map = new HashMap<>();
        int isok = sysDictDataService.isok(sysDictData);
        if (isok == 0) {
            System.out.println(sysDictData.toString());
            int i = sysDictDataService.updateData(sysDictData);

            map.put("data", i);
            return map;
        }
        map.put("data", 0);
        return map;
    }

    @RequestMapping("addData")
    public HashMap<String, Object> addData(@RequestBody SysDictData sysDictData) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(sysDictData.toString());
        int isok = sysDictDataService.isok(sysDictData);
        System.err.println(isok + "ccccccccccccccccccccc");
        if (isok == 0) {
            boolean save = sysDictDataService.save(sysDictData);
            map.put("data", 1);
            return map;
        }
        map.put("data", 0);
        return map;
    }

    @DeleteMapping("delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(id);
        int save = sysDictDataService.removeDictById(id);
        map.put("data", save);
        return map;
    }


}

