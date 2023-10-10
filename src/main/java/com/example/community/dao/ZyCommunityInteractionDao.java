package com.example.community.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.InterCationAndOwner;
import com.example.community.dto.OwnerRoomList;
import org.apache.ibatis.annotations.Param;
import com.example.community.entity.ZyCommunityInteraction;

/**
 * 社区互动表(ZyCommunityInteraction)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyCommunityInteractionDao extends BaseMapper<ZyCommunityInteraction> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<ZyCommunityInteraction> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<ZyCommunityInteraction> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<ZyCommunityInteraction> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<ZyCommunityInteraction> entities);

    List<InterCationAndOwner> getInterCationAll(@Param("index") Long index, @Param("size") Long size, @Param("interCationAndOwner") InterCationAndOwner interCationAndOwner);

    List<InterCationAndOwner> getInterCationList(@Param("interactionId") String interactionId);

    Long getCount(InterCationAndOwner interCationAndOwner);

    int deleteByUserId(@Param("id") String id,@Param("type") String type);
}

