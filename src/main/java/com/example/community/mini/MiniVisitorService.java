package com.example.community.mini;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.community.dao.ZyOwnerDao;
import com.example.community.dao.ZyOwnerRoomDao;
import com.example.community.dao.ZyVisitorDao;
import com.example.community.entity.ZyOwner;
import com.example.community.entity.ZyOwnerRoom;
import com.example.community.entity.ZyVisitor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MiniVisitorService {

    @Resource
    private ZyOwnerRoomDao zyOwnerRoomDao;

    @Resource
    private ZyOwnerDao zyOwnerMapper;

    @Resource
    private ZyVisitorDao zyVisitorDao;

    /**
     * 查询业主是否有绑定的房屋
     * @param communityId
     * @param openId
     * @return
     */
    public Boolean findCurrentUserHasBindInfo(Long communityId ,String openId) {
        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", openId));
        Integer integer = zyOwnerRoomDao.selectCount(new QueryWrapper<ZyOwnerRoom>()
                .eq("room_status", "1")
                .eq("owner_id", zyOwner.getOwnerId())
                .eq("community_id", communityId)
        );
        if (integer != null && integer > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 保存访客信息
     * @param zyVisitor
     * @return
     */
    public Integer insertByV(ZyVisitor zyVisitor) {
        return zyVisitorDao.insertByV(zyVisitor);
    }

    /**
     * 查询前三个访客列表
     * @param communityId
     * @param ownerId
     * @return
     */
    public List<ZyVisitor> getByCommunityId(Long communityId,Long ownerId){
        return zyVisitorDao.getByCommunityId(communityId,ownerId);
    }

    public List<ZyVisitor> getByComS(String communityId,String ownerId){

        return zyVisitorDao.getByComS(Long.parseLong(communityId),Long.parseLong(ownerId));
    }

}
