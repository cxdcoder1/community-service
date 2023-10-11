package com.example.community.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.dto.ZyOwnerRoomDto;
import com.example.community.entity.ZyVisitor;
import com.example.community.service.ZyVisitorService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 访客邀请 (ZyVisitor)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@Api(tags = "访客邀请")
@RestController
@RequestMapping("zyVisitor")
@CrossOrigin
public class ZyVisitorController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ZyVisitorService zyVisitorService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param zyVisitor 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ZyVisitor> page, ZyVisitor zyVisitor) {
        return success(this.zyVisitorService.page(page, new QueryWrapper<>(zyVisitor)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.zyVisitorService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param zyVisitor 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ZyVisitor zyVisitor) {
        return success(this.zyVisitorService.save(zyVisitor));
    }

    /**
     * 修改数据
     *
     * @param zyVisitor 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ZyVisitor zyVisitor) {
        return success(this.zyVisitorService.updateById(zyVisitor));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.zyVisitorService.removeByIds(idList));
    }
    @GetMapping("zyVisitorList")
    public R zyVisitorList(Page<ZyVisitor> page, ZyVisitor zyVisitor, long communityId) {
        return success(this.zyVisitorService.zyVisitorList(page,zyVisitor,communityId));
    }
    @PutMapping("updateRemark/{id}")
    public Map<String, Object> updateRemark(@PathVariable long id){
        Map<String, Object> map = new HashMap<>();
        Integer integer = zyVisitorService.updateRemark(id);
        if (integer>0){
            map.put("msg","操作成功");
            map.put("status", 200);
            map.put("success", true);
            return map;
        }
        map.put("msg","操作失败");
        map.put("status", 201);
        map.put("success", false);
        return map;
    }

    @PutMapping("updateRemarks/{id}")
    public Map<String, Object> updateRemarks(@PathVariable long id){
        Map<String, Object> map = new HashMap<>();
        Integer integer = zyVisitorService.updateRemarks(id);
        if (integer>0){
            map.put("msg","操作成功");
            map.put("status", 200);
            map.put("success", true);
            return map;
        }
        map.put("msg","操作失败");
        map.put("status", 201);
        map.put("success", false);
        return map;
    }

}

