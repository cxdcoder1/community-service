package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyRoomDao;
import com.example.community.entity.ZyRoom;
import com.example.community.service.ZyRoomService;
import org.springframework.stereotype.Service;

/**
 * 房间 (ZyRoom)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
@Service("zyRoomService")
public class ZyRoomServiceImpl extends ServiceImpl<ZyRoomDao, ZyRoom> implements ZyRoomService {

}

