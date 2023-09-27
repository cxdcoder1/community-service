package com.example.community.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.dto.CommunityAndDeptDto;
import com.example.community.dto.UserAndDeptAndPostAndRole;
import com.example.community.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import com.example.community.entity.ZyCommunity;
import org.apache.ibatis.annotations.Select;

import javax.websocket.server.PathParam;

/**
 * 小区 (ZyCommunity)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyCommunityDao extends BaseMapper<ZyCommunity> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<ZyCommunity> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<ZyCommunity> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<ZyCommunity> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<ZyCommunity> entities);

    List<CommunityAndDeptDto> getCommunity(@Param("index") Long index, @Param("size") Long size, @Param("zyCommunity") CommunityAndDeptDto communityAndDeptDto);

    long getCount(CommunityAndDeptDto communityAndDeptDto);

    //删除
    long delCommunity(@Param("id") String id);

    List<ZyCommunity> getCommunityDeriveList(List<String> list);

    int deleteCommunity(@Param("id") List<String> id);

    int insCommunit(ZyCommunity zyCommunity);

    List<ZyCommunity> selCommunityDerive(ZyCommunity zyCommunity);

    int updCommunityDerive(ZyCommunity zyCommunity);

    int updCommunity(String communityId,String deptId);

    /**
     * 小区集合
     * @return
     */
    @Select("select * from zy_community")
    List<ZyCommunity>getCommunityList();

}

