package com.example.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.OperLogDto;
import com.example.community.entity.SysDictData;
import com.example.community.entity.SysOperLog;
import com.example.community.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 操作日志记录(SysOperLog)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
public interface SysOperLogService extends IService<SysOperLog> {
    Page<OperLogDto> operLogList(Page<OperLogDto> page, OperLogDto operLogDto);

    List<SysDictData> statusOption();

    List<SysDictData>operTypeList();

    SysOperLog  getOperLog(int id);

    Integer insert(SysOperLog sysOperLog);

    boolean deletesOperLog(@Param("ids") Long [] ids);

    Integer dels();
}

