package com.example.community.mini;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.community.dao.ZyOwnerDao;
import com.example.community.entity.ZyComplaintSuggest;
import com.example.community.entity.ZyFiles;
import com.example.community.entity.ZyOwner;
import com.example.community.mini.dto.SuggestAndOwnerDto;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * 投诉意见
 */
@RestController
@RequestMapping("/mini/community/cs")
public class MiniSuggestController {

    @Resource
    private MiniSuggestService miniSuggestService;

    @Resource
    private ZyOwnerDao zyOwnerMapper;

    /**
     * 保存投诉意见
     *
     * @param suggestAndOwnerDto
     * @return
     */
    @PostMapping("/save")
    public Map<String, Object> findCurrentUserHasBindInfo(@RequestBody SuggestAndOwnerDto suggestAndOwnerDto) throws InterruptedException {
        HashMap<String, Object> result = new HashMap<>();
        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", suggestAndOwnerDto.getOpenId()));
        suggestAndOwnerDto.setUserId(zyOwner.getOwnerId());
        suggestAndOwnerDto.setCreateBy(zyOwner.getOwnerRealName());
        suggestAndOwnerDto.setCreateTime(new Date());
        suggestAndOwnerDto.setComplaintSuggestId(System.currentTimeMillis());
        //图片
        List<String> imageUrls = suggestAndOwnerDto.getImageUrls();
        List<ZyFiles> files = new ArrayList<>();
        if (imageUrls.size() > 0) {
            for (String imageUrl : imageUrls) {
                ZyFiles zyFiles = new ZyFiles();
                zyFiles.setFilesId(System.currentTimeMillis());
                zyFiles.setFilesUrl(imageUrl);
                zyFiles.setSource(0);//来源0APP端，1PC端
                zyFiles.setUserId(suggestAndOwnerDto.getUserId());
                zyFiles.setParentId(suggestAndOwnerDto.getComplaintSuggestId());//设置图片所属
                zyFiles.setRemark("ComplaintSuggest");
                files.add(zyFiles);
                Thread.sleep(2);
            }
        }
        System.err.println(files);

        //插入投诉信息
        String s = miniSuggestService.saveSuggest(suggestAndOwnerDto, files);
        if (s.equals("1")) {
            //插入成功
            result.put("status", 200);
            result.put("msg", "投诉成功");
            return result;
        }
        result.put("status", 201);
        result.put("msg", "投诉失败");
        return result;
    }


    @GetMapping("/suggestions")
    public Map<String, Object> getSuggestions(String communityId ,String openId)  {
        HashMap<String, Object> result = new HashMap<>();
        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", openId));
        List<ZyComplaintSuggest> suggestions = miniSuggestService.getSuggestions(communityId, zyOwner.getOwnerId() + "");
        result.put("status",200);
        result.put("msg","获取成功");
        result.put("list",suggestions);
        return result;
    }
}
