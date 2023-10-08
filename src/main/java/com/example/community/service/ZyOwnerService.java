package com.example.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.ZyOwner;

/**
 * 业主 (ZyOwner)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyOwnerService extends IService<ZyOwner> {

    /**
     * 更新业主身份证号
     * @param zyOwner
     * @return
     */
    Integer updateIdCard(ZyOwner zyOwner);

    /**
     * 根据身份证号查询业主
     * @param idCard
     * @return
     */
    ZyOwner getByIdCard(String idCard);

    /**
     * 根据openid获取业主信息
     * @param openId
     * @return
     */
    ZyOwner getByOpenId(String openId);
}

