package com.example.community.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.InterCationAndOwner;
import org.apache.ibatis.annotations.Param;
import com.example.community.entity.ZyComment;

/**
 * 评论表(ZyComment)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyCommentDao extends BaseMapper<ZyComment> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<ZyComment> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<ZyComment> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<ZyComment> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
    int insertOrUpdateBatch(@Param("entities") List<ZyComment> entities);

    List<InterCationAndOwner> getParentIds(@Param("id") String id);

    int updDelFlag(@Param("id") String id);
}

