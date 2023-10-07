package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysLogininforDao;
import com.example.community.dto.LogDto;
import com.example.community.entity.SysDictData;
import com.example.community.entity.SysLogininfor;
import com.example.community.service.SysLogininforService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统访问记录(SysLogininfor)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Service("sysLogininforService")
public class SysLogininforServiceImpl extends ServiceImpl<SysLogininforDao, SysLogininfor> implements SysLogininforService {

    @Resource
    private SysLogininforDao logininforMapper;

    /**
     * 新增系统登录日志
     *
     * @param logininfor 访问日志对象
     */
    @Override
    public void insertLogininfor(SysLogininfor logininfor) {
        logininforMapper.insertLogininfor(logininfor);
    }

    /**
     * 查询系统登录日志集合
     *
     */
    @Override
    public List<SysLogininfor> selectLogininforList(LogDto logDto, long index, long size) {
        return logininforMapper.selectLogininforList(logDto,index,size);
    }

    @Override
    public List<SysDictData> getStatus() {
        return logininforMapper.getStatus();
    }

    /**
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return 结果
     */
    @Override
    public int deleteLogininforByIds(Long[] infoIds) {
        return logininforMapper.deleteLogininforByIds(infoIds);
    }

    /**
     * 清空系统登录日志
     */
    @Override
    public void cleanLogininfor() {
        logininforMapper.cleanLogininfor();
    }
}

