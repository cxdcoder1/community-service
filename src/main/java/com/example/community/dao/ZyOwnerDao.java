package com.example.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.entity.ZyOwner;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 业主 (ZyOwner)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyOwnerDao extends BaseMapper<ZyOwner> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<ZyOwner> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<ZyOwner> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<ZyOwner> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<ZyOwner> entities);

    @Select("select owner_id from zy_owner where owner_open_id=#{openId}")
    Long findOwnerIdByOpenId(@Param("openId") String openId);

    int updateOwnerById(ZyOwner zyOwner);

    Integer updateIdCard(ZyOwner zyOwner);

    ZyOwner getByIdCard(String idCard);

    ZyOwner getByOpenId(String openId);

}

