package com.example.community.mini;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.community.dao.ZyOwnerDao;
import com.example.community.dto.ZyOwnerRoomDto;
import com.example.community.entity.ZyOwner;
import com.example.community.entity.ZyOwnerRoom;
import com.example.community.mini.dto.OwnerRecordDto;
import com.example.community.service.ZyOwnerRoomService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 我的房屋
 */
@RestController
@RequestMapping("/mini/community/house")
public class MiniMyRoomController {

    @Resource
    private ZyOwnerRoomService zyOwnerRoomService;

    @Resource
    private ZyOwnerDao zyOwnerMapper;

    /**
     * 获取房屋信息
     *
     * @param communityId
     * @return
     */
    @GetMapping("/info")
    public Map<String, Object> authenticated(String communityId, String openId) {
        HashMap<String, Object> result = new HashMap<>();
        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", openId));
        //获取房屋业主绑定信息
        List<OwnerRecordDto> roomList = zyOwnerRoomService.getRoomsByCommunityId(communityId, zyOwner.getOwnerId() + "");
        //审核、绑定、审核失败 三个状态的集合
        List<OwnerRecordDto> applyList = new ArrayList();
        List<OwnerRecordDto> bindList = new ArrayList();
        List<OwnerRecordDto> rejectList = new ArrayList();
        //给房屋信息分类
        for (OwnerRecordDto zyOwnerRoom : roomList) {
            if (zyOwnerRoom.getRoomStatus().equals("0")){
                applyList.add(zyOwnerRoom);
            }
            if (zyOwnerRoom.getRoomStatus().equals("1")){
                bindList.add(zyOwnerRoom);
            }
            if (zyOwnerRoom.getRoomStatus().equals("2")){
                rejectList.add(zyOwnerRoom);
            }
        }
        result.put("status",200);
        result.put("msg","获取业主房屋信息成功");
        result.put("applyList",applyList);
        result.put("bindList",bindList);
        result.put("rejectList",rejectList);
        return result;
    }
}
