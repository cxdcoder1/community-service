package com.example.community.mini;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录、注册、发送验证码
 */
@RestController
@RequestMapping("/mini/community")
public class MiniLoginController {

    @Resource
    private MiniLoginService miniLoginService;

    /**
     * 小程序登录按钮
     * @param loginDto 登录Dto
     * @return 登录结果
     */
    @PostMapping("/login")
    public ZyResult<MiniUserDto> weChatLogin(@RequestBody LoginDto loginDto) {
        System.out.println(loginDto.toString());
        if (loginDto == null) {
            return ZyResult.fail(400, "传递参数不能为空");
        }
        return miniLoginService.weChatLogin(loginDto.getCode());
    }

    // /**
    //  * 注册用户
    //  *
    //  * @param registerDto 注册信息
    //  * @return 注册后信息
    //  */
    // @PostMapping("/register")
    // public ZyResult<MiniUserDto> register(@RequestBody @Validated RegisterDto registerDto, BindingResult result) {
    //     if (result.hasErrors()) {
    //         String defaultMessage = result.getFieldError().getDefaultMessage();
    //         return ZyResult.fail(400, defaultMessage);
    //     }
    //     return miniLoginService.weChatRegister(registerDto);
    // }
    //
    // /**
    //  * 发送验证码
    //  * @param phoneNum 手机号
    //  * @return 发送结果
    //  */
    // @GetMapping("/sendCode/{phoneNum}")
    // public ZyResult<String> sendCode(@PathVariable("phoneNum") String phoneNum){
    //     return miniLoginService.sendCode(phoneNum);
    // }
}
