package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyCommunityDao;
import com.example.community.dto.CommunityAndDeptDto;
import com.example.community.entity.SysPost;
import com.example.community.entity.ZyCommunity;
import com.example.community.service.ZyCommunityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 小区 (ZyCommunity)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("zyCommunityService")
public class ZyCommunityServiceImpl extends ServiceImpl<ZyCommunityDao, ZyCommunity> implements ZyCommunityService {

    @Resource
    private ZyCommunityDao zyCommunityDao;


    @Override
    public Page<CommunityAndDeptDto> getCommunity(Page<CommunityAndDeptDto> page, CommunityAndDeptDto communityAndDeptDto) {
        // 获取满足条件的角色列表总数
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
//        long total = sysUserDao.selUserlist(0L,0L,userAndDeptAndPostAndRole).size();
        long total = zyCommunityDao.getCount(communityAndDeptDto);
        page.setTotal(total);

        // 计算总页数
        int totalPages = (int) Math.ceil(total * 1.0 / page.getSize());
        if (page.getCurrent() > totalPages) {
            page.setCurrent(totalPages);
        }

        if (page.getCurrent() <= 0) {
            page.setCurrent(1);
        }

        page.setPages(totalPages);
        List<CommunityAndDeptDto> list =  zyCommunityDao.getCommunity((page.getCurrent() - 1) * page.getSize(), page.getSize(), communityAndDeptDto);
        System.err.println(list);
        page.setRecords(list);

        return page;
    }

    @Override
    public long delCommunity(String id) {
        return zyCommunityDao.delCommunity(id);
    }

    @Override
    public List<ZyCommunity> getCommunityDeriveList(List<String> list) {
        return zyCommunityDao.getCommunityDeriveList(list);
    }

    @Override
    public int deleteCommunity(List<String> id) {
        return zyCommunityDao.deleteCommunity(id);
    }

    @Override
    public int insCommunit(ZyCommunity zyCommunity) {
        return zyCommunityDao.insCommunit(zyCommunity);
    }

    @Override
    public List<ZyCommunity> selCommunityDerive(ZyCommunity zyCommunity) {
        return zyCommunityDao.selCommunityDerive(zyCommunity);
    }

    @Override
    public int updCommunityDerive(ZyCommunity zyCommunity) {
        return zyCommunityDao.updCommunityDerive(zyCommunity);
    }

    @Override
    public int updCommunity(String communityId, String deptId) {
        return zyCommunityDao.updCommunity(communityId, deptId);
    }


    @Override
    public List<ZyCommunity> getCommunityList() {
        return zyCommunityDao.getCommunityList();
    }




    @Override
    public List<ZyCommunity> getUCommunity() {
        return zyCommunityDao.getUCommunity();
    }
}

