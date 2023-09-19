package com.example.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.entity.SysMenu;
import com.example.community.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色信息表(SysRole)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
public interface SysRoleDao extends BaseMapper<SysRole> {


    /**
     * 新增角色信息
     *
     * @param role 角色信息
     * @return 结果
     */
    public int insertRole(SysRole role);

    /**
     * 新增和修改的验重
     *
     * @param RoleName
     * @return
     */
    public int selectRoleName(String RoleName);

    public SysRole selectRoleById(Long id);


    /**
     * 根据条件分页查询角色数据
     *
     *  role 角色信息
     * @return 角色数据集合信息
     */
    List<SysRole> selectRoleList(@Param("index") Long index, @Param("size") Long size , @Param("sysRole") SysRole sysRole);


    public int updateRole(SysRole role);

    public List<SysMenu> getRoleMenuTreeselect(Long roleId);

}

