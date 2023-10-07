package com.example.community.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.OperLogDto;
import com.example.community.entity.SysDictData;
import com.example.community.entity.SysRole;
import com.example.community.entity.ZyBuilding;
import org.apache.ibatis.annotations.Param;
import com.example.community.entity.SysOperLog;

/**
 * 操作日志记录(SysOperLog)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
public interface SysOperLogDao extends BaseMapper<SysOperLog> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<SysOperLog> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<SysOperLog> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<SysOperLog> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<SysOperLog> entities);



    List<OperLogDto> selectSysoperLog(@Param("index") Long index, @Param("size") Long size , @Param("operLogDto") OperLogDto operLogDto);


    Integer count(OperLogDto operLogDto);

    List<SysDictData> statusOption();

    List<SysDictData>operTypeList();

    SysOperLog  getOperLog(int id);

    Integer insertSysOperLog(SysOperLog sysOperLog);

    Long deletesOperLog(@Param("ids") Long [] ids);


    List<SysOperLog> getOperLogList(List<String> list);


    Integer dels();
}

