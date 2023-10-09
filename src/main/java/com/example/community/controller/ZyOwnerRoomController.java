package com.example.community.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.dto.OwnerRoomAndZyOwner;
import com.example.community.dto.OwnerRoomList;
import com.example.community.dto.ZyOwnerRoomDto;
import com.example.community.entity.ZyBuilding;
import com.example.community.entity.ZyOwnerRoom;
import com.example.community.entity.ZyOwnerRoomRecord;
import com.example.community.service.ZyOwnerRoomRecordService;
import com.example.community.service.ZyOwnerRoomService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 房屋绑定表 (ZyOwnerRoom)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@ApiIgnore
@RestController
@RequestMapping("zyOwnerRoom")
@CrossOrigin
public class ZyOwnerRoomController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ZyOwnerRoomService zyOwnerRoomService;

    @Resource
    private ZyOwnerRoomRecordService zyOwnerRoomRecordService;


    @PostMapping("insetRoomRecordList")
    @Transactional
    public Map<String,Object> insetAll(@RequestBody ZyOwnerRoomRecord zyOwnerRoomRecord) {
        System.err.println(zyOwnerRoomRecord);
        Map<String, Object> map = new HashMap<>();
        zyOwnerRoomRecordService.insetRoomRecordAll(zyOwnerRoomRecord);
        zyOwnerRoomService.updOwnerRoom(zyOwnerRoomRecord.getRoomStatus(), zyOwnerRoomRecord.getOwnerRoomId());
        map.put("msg", "审核成功");
        map.put("status", 200);

        return map;
    }

    @GetMapping("getRoomRecordList")
    public R selectAll(String name) {
        System.err.println(name);
        return success(this.zyOwnerRoomRecordService.getRoomRecordList(name));
    }

    @GetMapping("getOwnerRoomAll")
    public R selectAll(Page<OwnerRoomList> page, OwnerRoomList ownerRoomList) {
        return success(this.zyOwnerRoomService.getRoomAll(page,ownerRoomList));
    }


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param zyOwnerRoom 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ZyOwnerRoom> page, ZyOwnerRoom zyOwnerRoom) {
        return success(this.zyOwnerRoomService.page(page, new QueryWrapper<>(zyOwnerRoom)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.zyOwnerRoomService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param zyOwnerRoom 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ZyOwnerRoom zyOwnerRoom) {
        return success(this.zyOwnerRoomService.save(zyOwnerRoom));
    }

    /**
     * 修改数据
     *
     * @param zyOwnerRoom 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ZyOwnerRoom zyOwnerRoom) {
        return success(this.zyOwnerRoomService.updateById(zyOwnerRoom));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.zyOwnerRoomService.removeByIds(idList));
    }


}

