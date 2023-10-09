package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyOwnerRoomDao;
import com.example.community.dto.OwnerRoomList;
import com.example.community.dto.ZyOwnerRoomDto;
import com.example.community.entity.ZyOwnerRoom;
import com.example.community.mini.dto.OwnerRecordDto;
import com.example.community.service.ZyOwnerRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 房屋绑定表 (ZyOwnerRoom)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("zyOwnerRoomService")
public class ZyOwnerRoomServiceImpl extends ServiceImpl<ZyOwnerRoomDao, ZyOwnerRoom> implements ZyOwnerRoomService {

    @Resource
    private ZyOwnerRoomDao zyOwnerRoomDao;

    @Override
    public Page<OwnerRoomList> getRoomAll(Page<OwnerRoomList> page, OwnerRoomList ownerRoomList) {

        //条数
        long total=zyOwnerRoomDao.getCount(ownerRoomList);
        page.setTotal(total);

        // 计算总页数
        int totalPages = (int) Math.ceil(total * 1.0 / page.getSize());
        if (page.getCurrent() > totalPages) {
            page.setCurrent(totalPages);
        }

        if (page.getCurrent() <= 0) {
            page.setCurrent(1);
        }
        page.setPages(totalPages);

        List<OwnerRoomList> roomAll = zyOwnerRoomDao.getRoomAll((page.getCurrent() - 1) * page.getSize(), page.getSize(), ownerRoomList);

        return page.setRecords(roomAll);
    }

    @Override
    public int updOwnerRoom(String status,String id) {
        return zyOwnerRoomDao.updOwnerRoom(status,id);
    }

    @Override
    public List<OwnerRecordDto> getRoomsByCommunityId(String communityId, String ownerId) {
        return zyOwnerRoomDao.getRoomsByCommunityId(communityId,ownerId);
    }
}

