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

    /**
     * 管理员查询所有
     * @return
     */
    List<SysMenu>MenuList();
    /**
     * 验证同级别下菜单名
     *
     * @param menuName
     * @param parentId
     * @return
     */
    Boolean checkName(String menuName, String menuId, String parentId);

    /**
     * 验证菜单路径
     *
     * @param menuName
     * @param menuId
     * @return
     */
    Boolean checkPath(String menuName, String menuId);

    /**
     * 修改
     * @return
     */
    Integer updateMenu(SysMenu sysMenu);

    /**
     * 新增
     * @param sysMenu
     * @return
     */
    Integer addMenu(SysMenu sysMenu);

    /**
     * 查询上级菜单对象
     * @param sysMenu
     * @return
     */
    SysMenu getParent(SysMenu sysMenu);

    /**
     * 查询菜单子集
     * @param sysMenu
     * @return
     */
    List<SysMenu> getMenuChildren(SysMenu sysMenu);

    /**
     * 提升菜单为目录
     * @param sysMenu
     * @return
     */
    Integer upTypeToM(SysMenu sysMenu);
}

