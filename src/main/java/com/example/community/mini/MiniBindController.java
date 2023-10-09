package com.example.community.mini;

import com.example.community.mini.dto.BindDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 绑定的Api
 */
@RestController
@RequestMapping("/mini/community/bind")
public class MiniBindController {
    @Resource
    private MiniBindService miniBindService;

    /**
     * 绑定
     * @param dto 绑定提交信息
     * @param result 绑定结果
     * @return 绑定结果
     */
    @PostMapping("/room")
    public ZyResult<String> bindRoomInfo(@RequestBody @Valid BindDto dto, BindingResult result){
        if (result.hasErrors()){
            return ZyResult.fail(400,result.getFieldError().getDefaultMessage());
        }
        return miniBindService.bindRoom(dto);
    }


}
