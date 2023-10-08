package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyOwnerDao;
import com.example.community.entity.ZyOwner;
import com.example.community.service.ZyOwnerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

