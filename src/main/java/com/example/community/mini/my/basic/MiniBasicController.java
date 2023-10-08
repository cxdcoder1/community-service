package com.example.community.mini.my.basic;

import com.example.community.mini.MiniUserDto;
import com.example.community.mini.ZyResult;
import com.example.community.mini.my.basic.dto.UserBasicDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 修改基本信息
 */
@RestController
@RequestMapping("/mini/community/basic")
public class MiniBasicController {
    @Resource
    private MiniBasicService miniBasicService;

    @PostMapping("/edit")
    public ZyResult<MiniUserDto> editBasicInfo(@RequestBody UserBasicDto userBasicDto){
        System.out.println("修改信息"+userBasicDto.toString());
        return miniBasicService.editBasicInfo(userBasicDto);
    }
}
