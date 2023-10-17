package com.example.community.mini;

import com.alibaba.fastjson.JSON;
import com.example.community.constant.SystemConstant;
import com.example.community.utils.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    public Map<String,Object> weChatLogin(@RequestBody LoginDto loginDto, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        System.out.println(loginDto.toString());
        if (loginDto == null) {
            result.put("status",400);
            result.put("msg","传递参数不能为空");
            return result;
        }
        ZyResult<MiniUserDto> miniUserDtoZyResult = miniLoginService.weChatLogin(loginDto.getCode());
        // session.setAttribute("openId",miniUserDtoZyResult);

        result.put("data",miniUserDtoZyResult.getData());
        System.out.println(miniUserDtoZyResult.getData());
        String JWT = JwtUtil.createJWT(miniUserDtoZyResult.getData().getOpenId(), JSON.toJSONString(miniUserDtoZyResult.getData()), SystemConstant.JWT_WE_CHAT);
//                log.info(JWT);
        result.put("token", JWT);
        return result;
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
