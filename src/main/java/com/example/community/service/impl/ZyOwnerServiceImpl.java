package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyOwnerDao;
import com.example.community.dto.ExZyOwnerRoom;
import com.example.community.dto.ZyOwnerRoomDto;
import com.example.community.entity.ZyOwner;
import com.example.community.service.ZyOwnerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业主 (ZyOwner)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("zyOwnerService")
public class ZyOwnerServiceImpl extends ServiceImpl<ZyOwnerDao, ZyOwner> implements ZyOwnerService {

    @Resource
    private ZyOwnerDao zyOwnerDao;
    @Override
    public Page<ZyOwnerRoomDto> zyOwnerRoomList(Page<ZyOwnerRoomDto> page, ZyOwnerRoomDto zyOwnerRoomDto, long id) {
        long total = zyOwnerDao.count(zyOwnerRoomDto, id);
        page.setTotal(total);
        int totalPages = (int) Math.ceil(total * 1.0 / page.getSize());
        if (page.getCurrent() > totalPages) {
            page.setCurrent(totalPages);
        }
        if(page.getCurrent()<=0){
            page.setCurrent(1);
        }
        page.setPages(totalPages);
        page.setRecords(zyOwnerDao.selectOwnerRoom((page.getCurrent()-1)*page.getSize(),page.getSize(),zyOwnerRoomDto,id));
        return page;
    }

    @Override
    public Integer updateStatus(long ownerId) {
        return zyOwnerDao.updateStatus(ownerId);
    }

    @Override
    public List<ExZyOwnerRoom> getzyOwnerRoomDtoList(List<String> list) {
        return zyOwnerDao.getzyOwnerRoomDtoList(list);
    }

    @Override
    public Integer updateIdCard(ZyOwner zyOwner) {
        return zyOwnerDao.updateIdCard(zyOwner);
    }

    @Override
    public ZyOwner getByIdCard(String idCard) {
        return zyOwnerDao.getByIdCard(idCard);
    }

    @Override
    public ZyOwner getByOpenId(String openId) {
        return zyOwnerDao.getByOpenId(openId);
    }
}

