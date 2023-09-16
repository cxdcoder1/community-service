package com.example.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单权限表(SysMenu)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> MenuTree(int id);

    List<SysMenu> getMenuList(@Param("menuName") String menuName, @Param("status") String status);

    String deleteMenu(Long menuId,Long parentId);
}

