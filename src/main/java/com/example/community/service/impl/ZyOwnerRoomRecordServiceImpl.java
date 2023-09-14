package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyOwnerRoomRecordDao;
import com.example.community.entity.ZyOwnerRoomRecord;
import com.example.community.service.ZyOwnerRoomRecordService;
import org.springframework.stereotype.Service;

/**
 * 房屋绑定记录表 (ZyOwnerRoomRecord)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@Service("zyOwnerRoomRecordService")
public class ZyOwnerRoomRecordServiceImpl extends ServiceImpl<ZyOwnerRoomRecordDao, ZyOwnerRoomRecord> implements ZyOwnerRoomRecordService {

}

