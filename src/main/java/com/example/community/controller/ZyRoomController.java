package com.example.community.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.dto.RoomDto;
import com.example.community.entity.*;
import com.example.community.log.BusinessType;
import com.example.community.log.Log;
import com.example.community.service.ZyRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 房间 (ZyRoom)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@Api(tags = "房屋管理")
@RestController
@RequestMapping("zyRoom")
@CrossOrigin
public class ZyRoomController extends ApiController {

    @Resource
    private ZyRoomService zyRoomService;



    @ApiOperation(value = "获取房屋列表接口",notes = "获取房屋列表接口的说明")
    @GetMapping("getRoomList")
    public HashMap<String, Object> getRoomList(Page<RoomDto> page, RoomDto roomDto) {
        HashMap<String, Object> map = new HashMap<>();
        List<RoomDto> roomList = zyRoomService.getRoomList(Math.max((page.getCurrent()-1)*page.getSize(),0),page.getSize(), roomDto);
        int count = zyRoomService.getRoomList(0, 0, roomDto).size();

        map.put("total", count);
        map.put("data", roomList);

        return map;
    }

    @ApiOperation(value = "获取楼栋列表接口",notes = "获取楼栋列表接口的说明")
    @GetMapping("getBuilding")
    public HashMap<String, Object> getBuilding(ZyRoom zyRoom) {
        HashMap<String, Object> map = new HashMap<>();

        List<ZyBuilding> building = zyRoomService.getBuilding(zyRoom);

        map.put("building", building);

        return map;
    }

    @ApiOperation(value = "获取单元列表接口",notes = "获取单元列表接口的说明")
    @GetMapping("getUnit")
    public HashMap<String, Object> getUnit( ZyRoom zyRoom) {
        HashMap<String, Object> map = new HashMap<>();

        List<ZyUnit> unit = zyRoomService.getUnit(zyRoom);

        map.put("unit11", unit);

        return map;
    }

    @GetMapping("getStatus")
    public HashMap<String, Object> getStatus() {
        HashMap<String, Object> map = new HashMap<>();

        List<SysDictData> roomStatus = zyRoomService.getroomStatus();
        List<SysDictData> houseType = zyRoomService.getroomHouseType();
        List<ZyCommunity> community = zyRoomService.getCommunity();

        map.put("community", community);
        map.put("roomStatus", roomStatus);
        map.put("houseType", houseType);

        return map;
    }

    @Log(title = "房屋管理", businessType = BusinessType.INSERT)
    @ApiOperation(value = "添加房屋接口",notes = "添加房屋接口的说明")
    @PutMapping("addRoom")
    public HashMap<String, Object> getaddRoom(@RequestBody ZyRoom zyRoom) {
        HashMap<String, Object> map = new HashMap<>();
        int check = zyRoomService.check(zyRoom);
        if (check == 0) {
            int i = zyRoomService.addRoom(zyRoom);

            map.put("msg", "修改成功");
            map.put("status", 200);
            map.put("success", true);

            return map;
        }
        //重复
        map.put("msg", "房屋名重复");
        map.put("status", 201);
        map.put("success", false);
        return map;
    }

    @Log(title = "房屋管理", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改房屋接口",notes = "修改房屋接口的说明")
    @PutMapping("editRoom")
    public HashMap<String, Object> editRoom(@RequestBody ZyRoom zyRoom) {
        HashMap<String, Object> map = new HashMap<>();
        int check = zyRoomService.check(zyRoom);
        if (check == 0) {
            int i = zyRoomService.editRoom(zyRoom);

            map.put("msg", "修改成功");
            map.put("status", 200);
            map.put("success", true);

            return map;
        }
        //重复
        map.put("msg", "房屋名重复");
        map.put("status", 201);
        map.put("success", false);
        return map;

    }

    @Log(title = "房屋管理", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除房屋接口",notes = "删除房屋接口的说明")
    @DeleteMapping("deleteRoom/{roomId}")
    public HashMap<String, Object> deleteRoom(@PathVariable Long roomId) {
        HashMap<String, Object> map = new HashMap<>();
        int i = zyRoomService.deleteRoom(roomId);
        if (i==1){
            map.put("data", i);
            map.put("msg","删除成功" );
            return map;
        }else {
            map.put("data",i);
            map.put("msg","删除失败" );
            return map;
        }

    }

    @Log(title = "房屋管理", businessType = BusinessType.DELETE)
    @ApiOperation(value = "批量删除房屋接口",notes = "批量删除房屋接口的说明")
    @PostMapping("deleteRooms")
    public HashMap<String, Object> deleteRooms(@RequestBody List<String> list) {
        HashMap<String, Object> map = new HashMap<>();

        //验证是否能删除
        int rooms = zyRoomService.getRooms(list);
        if (rooms!=0){
            map.put("status",201);
            map.put("msg","删除失败,有房屋已出售!");
            return map;
        }

        Integer i = zyRoomService.delRooms(list);
        if (i!=0){
            map.put("status","200");
            map.put("msg","删除成功");
        }else {
            map.put("status","201");
            map.put("msg","删除失败");
        }
        return map;
    }

    @GetMapping("getRoomListStatus")
    public R getRoom() {
        return success(this.zyRoomService.roomList());
    }

    @GetMapping("monthList")
    public R monthList() {
        return success(this.zyRoomService.monthList());
    }
}

