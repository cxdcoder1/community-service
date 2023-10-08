package com.example.community.mini;


import com.example.community.entity.ZyCommunity;
import com.example.community.service.ZyCommunityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小区
 */
@RestController
@RequestMapping("/mini/community/community")
@CrossOrigin
public class MiniCommunityController {

    @Resource
    private ZyCommunityService zyCommunityService;


    /**
     * 获取小区集合
     *
     * @return
     */
    @GetMapping("/all")
    public Map<String, Object> getUCommunity() {
        HashMap<String, Object> result = new HashMap<>();
        List<ZyCommunity> uCommunity = zyCommunityService.getUCommunity();
        result.put("communityList", uCommunity);
        return result;
    }
}
