package com.example.community.mini;

import com.example.community.mini.dto.RoomDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 生活服务的API
 */
@RestController
@RequestMapping("/mini/community/life")
public class MiniLifeController {
    @Resource
    private MiniLifeService miniLifeService;

    /**
     * 根据社区Id查询楼栋信息
     *
     * @param communityId 社区Id
     * @return 楼栋集合
     */
    @GetMapping("/building/{communityId}")
    public ZyResult<List<RoomDto>> findBuildingsByCommunityId(@PathVariable("communityId") Long communityId) {
        return miniLifeService.findBuildingsByCommunityId(communityId);
    }

    /**
     * 根据楼栋Id查询单元信息
     *
     * @param buildingId 楼栋Id
     * @return 单元信息
     */
    @GetMapping("/unit/{buildingId}")
    public ZyResult<List<RoomDto>> findUnitsByBuildingId(@PathVariable("buildingId") Long buildingId) {
        return miniLifeService.findUnitsByBuildingId(buildingId);
    }

    /**
     * 根据单元Id查询房屋信息
     *
     * @param unitId 单元Id
     * @return 房屋信息
     */
    @GetMapping("/room/{unitId}")
    public ZyResult<List<RoomDto>> findRoomsByUnitId(@PathVariable("unitId") Long unitId) {
        return miniLifeService.findRoomsByUnitId(unitId);
    }

}
