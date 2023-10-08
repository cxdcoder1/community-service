package com.example.community.mini;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 通用处理
 */
@RestController
@RequestMapping("/mini/community/common")
public class MiniCommonController {
    @Resource
    private MiniCommonService miniCommonService;

    // @PostMapping("/upload")
    // public ZyResult<String> commonUpload(MultipartFile file) {
    //     return miniCommonService.uploadFile(file);
    // }


    @GetMapping("/dict/{type}")
    public ZyResult<List<DictDto>> findDictByType(@PathVariable("type") String type){
        return miniCommonService.selectDictByType(type);
    }

    // @GetMapping("/existsBind/{communityId}")
    // public ZyResult<Boolean> findCurrentUserHasBindInfo(@PathVariable("communityId") Long communityId) {
    //     return miniCommonService.findCurrentUserHasBindInfo(communityId);
    // }
}
