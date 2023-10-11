package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.ZyOwnerRoomDto;
import com.example.community.entity.ZyVisitor;

/**
 * 访客邀请 (ZyVisitor)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:04
 */
public interface ZyVisitorService extends IService<ZyVisitor> {

    Page<ZyVisitor> zyVisitorList(Page<ZyVisitor> page, ZyVisitor zyVisitor, long id);

    Integer updateRemark(long id);
}

