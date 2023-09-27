package com.example.community.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.dto.RoomDto;
import com.example.community.entity.*;
import com.example.community.service.ZyRoomService;
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
@RestController
@RequestMapping("zyRoom")
@CrossOrigin
public class ZyRoomController extends ApiController {

    @Resource
    private ZyRoomService zyRoomService;

    @GetMapping("getRoomList")
    public HashMap<String, Object> getRoomList(Page<RoomDto> page, RoomDto roomDto) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.println("当前页" + page.getCurrent() + "" + page.getSize());
        List<RoomDto> roomList = zyRoomService.getRoomList(page.getCurrent(), page.getSize(), roomDto);
        int count = zyRoomService.getRoomList(0, 0, roomDto).size();

        map.put("total", count);
        map.put("data", roomList);

        return map;
    }

    @GetMapping("getBuilding")
    public HashMap<String, Object> getBuilding(ZyRoom zyRoom) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(zyRoom);

        List<ZyBuilding> building = zyRoomService.getBuilding(zyRoom);

        map.put("building", building);

        return map;
    }

    @GetMapping("getUnit")
    public HashMap<String, Object> getUnit(ZyRoom zyRoom) {
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

    @PutMapping("addRoom")
    public HashMap<String, Object> getaddRoom(@RequestBody ZyRoom zyRoom) {
        HashMap<String, Object> map = new HashMap<>();

        System.err.println(zyRoom);

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

    @PutMapping("editRoom")
    public HashMap<String, Object> editRoom(@RequestBody ZyRoom zyRoom) {
        HashMap<String, Object> map = new HashMap<>();

        System.err.println(zyRoom);

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

    @DeleteMapping("deleteRoom/{roomId}")
    public HashMap<String, Object> deleteRoom(@PathVariable Long roomId) {
        HashMap<String, Object> map = new HashMap<>();

        // System.err.println(zyRoom);

        int i = zyRoomService.deleteRoom(roomId);

        map.put("data", i);

        return map;
    }

}

