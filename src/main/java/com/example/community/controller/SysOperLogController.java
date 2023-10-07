package com.example.community.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.dto.OperLogDto;
import com.example.community.entity.SysOperLog;
import com.example.community.entity.SysRole;
import com.example.community.log.BusinessType;
import com.example.community.log.Log;
import com.example.community.service.SysOperLogService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 操作日志记录(SysOperLog)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Api(tags = "操作日志记录")
@RestController
@RequestMapping("sysOperLog")
@CrossOrigin
public class SysOperLogController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysOperLogService sysOperLogService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param sysOperLog 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysOperLog> page, SysOperLog sysOperLog) {
        return success(this.sysOperLogService.page(page, new QueryWrapper<>(sysOperLog)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysOperLogService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysOperLog 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysOperLog sysOperLog) {
        return success(this.sysOperLogService.save(sysOperLog));
    }

    /**
     * 修改数据
     *
     * @param sysOperLog 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysOperLog sysOperLog) {
        return success(this.sysOperLogService.updateById(sysOperLog));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysOperLogService.removeByIds(idList));
    }

    @GetMapping("operLoglist")
    public R selectPageAll(Page<OperLogDto> page, OperLogDto operLogDto) {
        System.err.println(operLogDto);
        return success(this.sysOperLogService.operLogList(page,operLogDto));
    }

    //状态下拉框
    @GetMapping("/statusOption")
    public R statusOption() {
        System.err.println();
        return success(this.sysOperLogService.statusOption());
    }

    @GetMapping("/operOption")
    public R operOption() {
        System.err.println();
        return success(this.sysOperLogService.operTypeList());
    }

    @GetMapping("getOper")
    public R getOper(int id) {
        System.err.println();
        return success(this.sysOperLogService.getOperLog(id));
    }

    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    @PostMapping("deletes")
    public Map<String,Object> deletes(@RequestBody Long[] ids){
        Map<String,Object> result = new HashMap<>();
        boolean deletes = sysOperLogService.deletesOperLog(ids);
        if(deletes){
            result.put("status",200);
            result.put("msg","删除成功");
        }else{
            result.put("status",201);
            result.put("msg","删除失败");
        }
        return result;
    }

    @PostMapping("dels")
    public Map<String,Object> dels(){
        Map<String,Object> result = new HashMap<>();
        Integer dels = sysOperLogService.dels();
        if(dels>0){
            result.put("status",200);
            result.put("msg","清空成功");
        }else{
            result.put("status",201);
            result.put("msg","清空失败");
        }
        return result;
    }
}

