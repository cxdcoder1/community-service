package com.example.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.OwnerRoomList;
import com.example.community.entity.ZyOwnerRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 房屋绑定表 (ZyOwnerRoom)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyOwnerRoomDao extends BaseMapper<ZyOwnerRoom> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<ZyOwnerRoom> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<ZyOwnerRoom> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<ZyOwnerRoom> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<ZyOwnerRoom> entities);


    List<OwnerRoomList> getRoomAll(@Param("index") Long index, @Param("size") Long size, @Param("zyOwnerRoom") OwnerRoomList ownerRoomList);

    Long getCount(OwnerRoomList ownerRoomList);

    int updOwnerRoom(@Param("status") String status,@Param("id") String id);

    int insertRoom(ZyOwnerRoom zyOwnerRoom);

}

