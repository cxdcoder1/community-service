package com.example.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.RolesAndMenuIds;
import com.example.community.entity.SysMenu;
import com.example.community.entity.SysRole;
import com.example.community.entity.SysRoleMenu;
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
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRole> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysRole> entities);


    /**
     * 新增角色信息
     *
     * @param role 角色信息
     * @return 结果
     */
    public Integer insertRole(RolesAndMenuIds rolesAndMenuIds);

    /**
     * 新增和修改的验重
     * @param RoleName
     * @return
     */
    public SysRole selectRoleName(String RoleName);


    /**
     * 根据条件分页查询角色数据
     *
     *  role 角色信息
     * @return 角色数据集合信息
     */
    List<SysRole> selectRoleList(@Param("index") Long index, @Param("size") Long size , @Param("sysRole") SysRole sysRole);

    long count(SysRole sysRole);

    public int updateRole(RolesAndMenuIds rolesAndMenuIds);

    public List<SysMenu> getRoleMenuTreeselect(Integer roleId);

    public SysRole selectRoleById(Long id);

    List<SysRole> getDeriveList(List<String> list);

    Integer deleteRole(@Param("roleId") String roleId);
    public int upDataStatus(long roleId,String status);


    public int deleteMenu(Long roleId);

    public int addMenu(@Param("roleId") Long roleId,@Param("menuId")Object menuId);

    public List<SysRoleMenu>  getMenuIds(Long roleId);

}

