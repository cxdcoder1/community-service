package com.example.community.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.dto.ZyOwnerRoomDto;
import com.example.community.entity.ZyOwner;
import com.example.community.entity.ZyOwnerRoomRecord;
import com.example.community.log.BusinessType;
import com.example.community.log.Log;
import com.example.community.service.ZyOwnerRoomRecordService;
import com.example.community.service.ZyOwnerRoomService;
import com.example.community.service.ZyOwnerService;
import io.swagger.annotations.Api;
import org.checkerframework.checker.units.qual.A;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业主 (ZyOwner)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Api(tags = "业主管理")
@RestController
@RequestMapping("zyOwner")
@CrossOrigin
public class ZyOwnerController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ZyOwnerService zyOwnerService;
    @Resource
    private ZyOwnerRoomRecordService zyOwnerRoomRecordService;
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param zyOwner 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ZyOwner> page, ZyOwner zyOwner) {
        return success(this.zyOwnerService.page(page, new QueryWrapper<>(zyOwner)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.zyOwnerService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param zyOwner 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ZyOwner zyOwner) {
        return success(this.zyOwnerService.save(zyOwner));
    }

    /**
     * 修改数据
     *
     * @param zyOwner 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ZyOwner zyOwner) {
        return success(this.zyOwnerService.updateById(zyOwner));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.zyOwnerService.removeByIds(idList));
    }

    @GetMapping("zyOwnerList")
    public R zyOwnerRoomList(Page<ZyOwnerRoomDto> page, ZyOwnerRoomDto zyOwnerRoomDto, long communityId) {
        System.err.println(zyOwnerRoomDto);
        return success(this.zyOwnerService.zyOwnerRoomList(page,zyOwnerRoomDto,communityId));
    }

    @Log(title = "业主信息", businessType = BusinessType.UPDATE)
    @Transactional
    @PutMapping("updateStatus/{ownerId}")
    public Map<String, Object>updateStatus(@PathVariable long ownerId,@RequestBody ZyOwnerRoomRecord zyOwnerRoomRecord){
        Map<String, Object> map = new HashMap<>();
        Integer integer = zyOwnerService.updateStatus(ownerId);
        int i = zyOwnerRoomRecordService.insetRoomRecordAll(zyOwnerRoomRecord);
        if (integer==1){
            map.put("msg","解绑成功");
            map.put("status", 200);
            map.put("success", true);
            return map;
        }
        map.put("msg","解绑失败");
        map.put("status", 201);
        map.put("success", false);
        return map;
    }
}

