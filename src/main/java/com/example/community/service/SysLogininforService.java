package com.example.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.dto.LogDto;
import com.example.community.entity.SysDictData;
import com.example.community.entity.SysLogininfor;

import java.util.List;

/**
 * 系统访问记录(SysLogininfor)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
public interface SysLogininforService extends IService<SysLogininfor> {

    /**
     * 新增系统登录日志
     *
     * @param logininfor 访问日志对象
     */
    public void insertLogininfor(SysLogininfor logininfor);

    /**
     * 查询系统登录日志集合
     */
    public List<SysLogininfor> selectLogininforList(LogDto logDto,long index,long size);

    public List<SysDictData> getStatus();

    /**
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return 结果
     */
    public int deleteLogininforByIds(Long[] infoIds);

    /**
     * 清空系统登录日志
     */
    public void cleanLogininfor();

    List<SysLogininfor>getLoginUser();

}

