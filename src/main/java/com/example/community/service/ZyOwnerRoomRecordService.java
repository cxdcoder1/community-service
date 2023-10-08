package com.example.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.OwnerRoomAndZyOwner;
import com.example.community.entity.ZyOwnerRoomRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 房屋绑定记录表 (ZyOwnerRoomRecord)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
public interface ZyOwnerRoomRecordService extends IService<ZyOwnerRoomRecord> {

    List<OwnerRoomAndZyOwner> getRoomRecordList(String name);


    int insetRoomRecordAll(ZyOwnerRoomRecord zyOwnerRoomRecord);


}

