package com.example.community.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.entity.SysArea;
import com.example.community.service.SysAreaService;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 区域表(SysArea)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:52:57
 */
@ApiIgnore
@RestController
@RequestMapping("sysArea")
public class SysAreaController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysAreaService sysAreaService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param sysArea 查询实体
     * @return 所有数据
     */
    @GetMapping("selectAll")
    public R selectAll(Page<SysArea> page, SysArea sysArea) {
        return success(this.sysAreaService.page(page, new QueryWrapper<>(sysArea)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysAreaService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysArea 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysArea sysArea) {
        return success(this.sysAreaService.save(sysArea));
    }

    /**
     * 修改数据
     *
     * @param sysArea 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysArea sysArea) {
        return success(this.sysAreaService.updateById(sysArea));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysAreaService.removeByIds(idList));
    }
}

