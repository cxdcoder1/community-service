package com.example.community.mini.my.basic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.community.dao.ZyOwnerDao;
import com.example.community.entity.ZyOwner;
import com.example.community.mini.MiniUserDto;
import com.example.community.mini.OwnerFactory;
import com.example.community.mini.ZyResult;
import com.example.community.mini.my.basic.dto.UserBasicDto;
import com.example.community.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 业主基础信息处理服务
 */
@Service
public class MiniBasicService {
    @Resource
    private ZyOwnerDao zyOwnerMapper;
    @Resource
    private OwnerFactory ownerFactory;

    @Transactional
    public ZyResult<MiniUserDto> editBasicInfo(UserBasicDto dto) {
        String openId = dto.getOpenId();
        if (StringUtils.isEmpty(openId)) {
            return ZyResult.fail(401,"用户未认证");
        }
        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", openId));
        if (zyOwner == null) {
            return ZyResult.fail(404, "用户不存在");
        }
        zyOwner.setUpdateTime(new Date());
        ownerFactory.transFromBasicDtoWithZyOwner(dto, zyOwner);
        zyOwnerMapper.updateOwnerById(zyOwner);
        return ZyResult.data(ownerFactory.transFromZyOwner(zyOwner));
    }

}
