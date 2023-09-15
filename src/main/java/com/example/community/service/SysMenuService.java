package com.example.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.SysMenu;

import java.util.List;

/**
 * 菜单权限表(SysMenu)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> MenuTree(int id);
}

