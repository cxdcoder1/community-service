package com.example.community.mini;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.community.dao.ZyOwnerDao;
import com.example.community.dao.ZyOwnerRoomDao;
import com.example.community.dao.ZyOwnerRoomRecordDao;
import com.example.community.entity.ZyOwner;
import com.example.community.entity.ZyOwnerRoom;
import com.example.community.entity.ZyOwnerRoomRecord;
import com.example.community.mini.dto.BindDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 房屋绑定服务
 */
@Service
public class MiniBindService {
    @Resource
    private ZyOwnerRoomDao zyOwnerRoomMapper;
    @Resource
    private ZyOwnerRoomRecordDao zyOwnerRoomRecordMapper;
    @Resource
    private BindFactory bindFactory;
    @Resource
    private ZyOwnerDao zyOwnerMapper;

    /**
     * 房屋绑定
     * 事务的隔离级别控制在读未提交,可以使得事务中锁有作用
     *
     * @param bindDto 绑定信息
     * @return 绑定结果
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public ZyResult<String> bindRoom(BindDto bindDto) {
        String openId = bindDto.getOpenId();


        if (StringUtils.isEmpty(openId)) return ZyResult.fail("用户未绑定");
        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", openId));
        if (zyOwner == null) return ZyResult.fail(404, "该用户不存在");

        //校验是否绑定过
        ZyOwnerRoom zyOwnerRoom = zyOwnerRoomMapper.selectOne(new QueryWrapper<ZyOwnerRoom>().eq("room_id", bindDto.getRoomId())
                .eq("owner_id", zyOwner.getOwnerId()).not(wrapper -> wrapper.eq("room_status", 0)));
        if (zyOwnerRoom != null) return ZyResult.fail(500, "已经绑定过,请勿重新绑定");

        //查看是否是业主绑定
        bindDto.setOwnerId(zyOwner.getOwnerId());
        ZyOwnerRoom bindInfo = bindFactory.createBindInfo(bindDto);
        if (bindDto.getOwnerType().equals("yz")) {
            synchronized (this) {
                //如果是业主绑定,那么查看该房屋是否已经绑定了业主
                ZyOwnerRoom zyOwnerRoom1 = zyOwnerRoomMapper.selectOne(new QueryWrapper<ZyOwnerRoom>()
                        .eq("room_id", bindDto.getRoomId())
                        .eq("owner_type", "yz")
                        .eq("room_status", 0));
                if (zyOwnerRoom1 != null) return ZyResult.fail(500, "该房屋业主已经绑定,请绑定其他类型");
                zyOwnerRoomMapper.insert(bindInfo);
            }
        } else {
            System.out.println(bindInfo);
            zyOwnerRoomMapper.insert(bindInfo);
        }
        ZyOwnerRoomRecord bindRecord = bindFactory.createBindRecord(bindInfo);
        zyOwnerRoomRecordMapper.insert(bindRecord);
        return ZyResult.success("绑定成功!");
    }


}
