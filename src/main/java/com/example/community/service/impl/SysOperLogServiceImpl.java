package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysOperLogDao;
import com.example.community.dto.OperLogDto;
import com.example.community.entity.SysDictData;
import com.example.community.entity.SysOperLog;
import com.example.community.service.SysOperLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 操作日志记录(SysOperLog)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Service("sysOperLogService")
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogDao, SysOperLog> implements SysOperLogService {

    @Resource
    private SysOperLogDao sysOperLogDao;
    @Override
    public Page<OperLogDto> operLogList(Page<OperLogDto> page, OperLogDto operLogDto) {
        // 获取满足条件的角色列表总数
        long total = sysOperLogDao.count(operLogDto);
        page.setTotal(total);
        // 计算总页数
        int totalPages = (int) Math.ceil(total * 1.0 / page.getSize());
        if (page.getCurrent() > totalPages) {
            page.setCurrent(totalPages);
        }
        if(page.getCurrent()<=0){
            page.setCurrent(1);
        }
        page.setPages(totalPages);
        page.setRecords(sysOperLogDao.selectSysoperLog((page.getCurrent()-1) * page.getSize(), page.getSize(), operLogDto));
        return page;
    }

    @Override
    public List<SysDictData> statusOption() {
        return sysOperLogDao.statusOption();
    }

    @Override
    public List<SysDictData> operTypeList() {
        return sysOperLogDao.operTypeList();
    }

    @Override
    public SysOperLog getOperLog(int id) {
        return sysOperLogDao.getOperLog(id);
    }

    @Override
    public Integer insert(SysOperLog sysOperLog) {
        return sysOperLogDao.insertSysOperLog(sysOperLog);
    }

    @Override
    public boolean deletesOperLog(Long[] ids) {
        if (sysOperLogDao.deletesOperLog(ids)>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Integer dels() {
        return sysOperLogDao.dels();
    }
}

