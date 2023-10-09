package com.example.community.mini;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.community.dao.ZyBuildingDao;
import com.example.community.dao.ZyRoomDao;
import com.example.community.dao.ZyUnitDao;
import com.example.community.entity.ZyBuilding;
import com.example.community.entity.ZyRoom;
import com.example.community.entity.ZyUnit;
import com.example.community.mini.dto.RoomDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 生活相关的服务
 */
@Service
public class MiniLifeService {
    @Resource
    private ZyBuildingDao zyBuildingMapper;
    @Resource
    private ZyUnitDao zyUnitMapper;
    @Resource
    private ZyRoomDao zyRoomMapper;


    /**
     * 根据小区获取楼栋信息
     *
     * @param communityId 小区ID
     * @return 楼栋集合
     */
    public ZyResult<List<RoomDto>> findBuildingsByCommunityId(Long communityId) {
        if (communityId == null) return ZyResult.fail(400, "社区Id不能为空");
        List<ZyBuilding> zyBuildings = zyBuildingMapper.selectList(new QueryWrapper<ZyBuilding>()
                .select("building_id", "building_name")
                .eq("community_id", communityId));
        return ZyResult.data(zyBuildings.stream().map(building->{
            RoomDto roomDto = new RoomDto();
            roomDto.setLabel(building.getBuildingName());
            roomDto.setValue(building.getBuildingId().toString());
            return roomDto;
        }).collect(Collectors.toList()));
    }

    /**
     * 根据楼栋Id查询单元信息
     *
     * @param buildingId 楼栋Id
     * @return 单元信息
     */
    public ZyResult<List<RoomDto>> findUnitsByBuildingId(Long buildingId) {
        if (buildingId == null) return ZyResult.fail(400, "楼栋Id不能为空");
        List<ZyUnit> zyUnits = zyUnitMapper.selectList(new QueryWrapper<ZyUnit>()
                .select("unit_id", "unit_name")
                .eq("building_id", buildingId));
        return ZyResult.data(zyUnits.stream().map(unit->{
            RoomDto roomDto = new RoomDto();
            roomDto.setValue(unit.getUnitId().toString());
            roomDto.setLabel(unit.getUnitName());
            return roomDto;
        }).collect(Collectors.toList()));
    }

    /**
     * 根据单元Id查询房屋信息
     *
     * @param unitId 单元Id
     * @return 房屋信息
     */
    public ZyResult<List<RoomDto>> findRoomsByUnitId(Long unitId) {
        if (unitId == null) return ZyResult.fail(400, "单元Id不能为空");
        List<ZyRoom> zyRooms = zyRoomMapper.selectList(new QueryWrapper<ZyRoom>()
                .select("room_id", "room_name").eq("unit_id", unitId));
        return ZyResult.data(zyRooms.stream().map(room->{
            RoomDto roomDto = new RoomDto();
            roomDto.setLabel(room.getRoomName());
            roomDto.setValue(room.getRoomId().toString());
            return roomDto;
        }).collect(Collectors.toList()));
    }


}
