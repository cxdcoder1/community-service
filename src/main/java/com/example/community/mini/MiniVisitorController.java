package com.example.community.mini;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.community.dao.ZyOwnerDao;
import com.example.community.entity.ZyOwner;
import com.example.community.entity.ZyVisitor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 访客邀请
 */
@RestController
@RequestMapping("/mini/community")
public class MiniVisitorController {

    @Resource
    private MiniVisitorService miniVisitorService;

    @Resource
    private ZyOwnerDao zyOwnerMapper;


    /**
     * 查询业主是否有绑定的房屋
     *
     * @param communityId
     * @return
     */
    @GetMapping("/common/existsBind/{communityId}/{openId}")
    public Map<String, Object> findCurrentUserHasBindInfo(@PathVariable("communityId") Long communityId, @PathVariable("openId") String openId) {
        HashMap<String, Object> result = new HashMap<>();
        Boolean currentUserHasBindInfo = miniVisitorService.findCurrentUserHasBindInfo(communityId, openId);
        if (currentUserHasBindInfo) {
            result.put("msg", "存在");
        } else {
            result.put("msg", "不存在");
        }
        result.put("status", currentUserHasBindInfo);
        return result;
    }

    /**
     * 保存访客邀请记录
     *
     * @param zyVisitor 访客邀请dto
     * @return 结果
     */
    @PostMapping("/visitor/save")
    public Map<String, Object> saveVisitor(@RequestBody ZyVisitor zyVisitor) {
        HashMap<String, Object> result = new HashMap<>();
        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", zyVisitor.getCreateByOpenId()));
        zyVisitor.setCreateById(zyOwner.getOwnerId());
        zyVisitor.setUpdateBy(zyOwner.getOwnerRealName());
        zyVisitor.setRemark("2");
        Integer integer = miniVisitorService.insertByV(zyVisitor);
        if (integer.equals(1)) {
            result.put("msg", "保存成功");
            result.put("status", 200);
            result.put("data", zyVisitor.getVisitorId());
            return result;
        }
        result.put("msg", "保存失败");
        result.put("status", 201);
        return result;
    }

    /**
     * 查询最新的3位到访人
     * @return 到访人列表
     */
    @GetMapping("/visitor/top3/{communityId}/{openId}")
    public Map<String, Object> findLatest3Visitor(@PathVariable("communityId") String communityId,@PathVariable("openId") String openId){
        HashMap<String, Object> result = new HashMap<>();
        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", openId));
        List<ZyVisitor> byCommunityId = miniVisitorService.getByCommunityId(Long.parseLong(communityId), zyOwner.getOwnerId());
        result.put("status",200);
        result.put("data",byCommunityId);
        return result;
    }


    /**
     * 获取所有访客列表
     * @param communityId
     * @return
     */
    @GetMapping("/visitor/page")
    public Map<String, Object> findVisitorPage(String communityId ,String openId ){
        HashMap<String, Object> result = new HashMap<>();
        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", openId));
        List<ZyVisitor> byComS = miniVisitorService.getByComS(communityId, zyOwner.getOwnerId() + "");
        result.put("status",200);
        result.put("list",byComS);
        return result;
    }
}
