package com.example.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单权限表(SysMenu)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
public interface SysMenuDao extends BaseMapper<SysMenu> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysMenu> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysMenu> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysMenu> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysMenu> entities);
    /**
     * 系统菜单
     *
     * @return
     */
    List<SysMenu> selectMenuTreeByUserId(int id);

    List<SysMenu> getMenuList(@Param("menuName") String menuName, @Param("status") String status);

    List<SysMenu> getMenuByParentId(Long id);
    /**
     * 验证同级别下菜单名
     * @param menuName
     * @param parentId
     * @return
     */
    Long checkName(String menuName,String parentId);

    /**
     * 验证菜单路径
     * @param menuName
     * @param menuId
     * @return
     */
    Long checkPath(String menuName,String menuId);

    Integer updateMenu(SysMenu sysMenu);

    Integer addMenu(SysMenu sysMenu);

    SysMenu getParent(SysMenu sysMenu);

    int deleteByMenuId(Long id);

    List<SysMenu> getMenuChildren(SysMenu sysMenu);

    Integer upTypeToM(SysMenu sysMenu);


}

