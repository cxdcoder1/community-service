// package com.example.community.mini.my.auth;
//
// import com.example.community.mini.ZyResult;
// import com.example.community.mini.my.auth.dto.AuthenticationDto;
// import com.zy.community.mini.service.my.auth.MiniAuthService;
// import org.springframework.web.bind.annotation.*;
//
// import javax.annotation.Resource;
//
// /**
//  * 实名认证
//  */
// @RestController
// @RequestMapping("/mini/community/auth")
// public class MiniAuthController {
//     @Resource
//     private MiniAuthService miniAuthService;
//
//     /**
//      * 获取用户的实名信息
//      * @return 实名信息
//      */
//     @GetMapping("/owner")
//     public ZyResult<AuthenticationDto> getAuthenticationInfo() {
//         return miniAuthService.getAuthenticationInfo();
//     }
//
//     /**
//      * 实名认证信息提交
//      * @param authenticationDto 实名信息
//      * @return 实名结果
//      */
//     @PostMapping("/authenticated")
//     public ZyResult<String> authenticated(@RequestBody AuthenticationDto authenticationDto) {
//         return miniAuthService.authenticated(authenticationDto);
//     }
//
//     /**
//      * 获取短信码
//      * @param newPhone 新手机号
//      * @return 短信结果
//      */
//     @GetMapping("/getEditPhoneCode/{newPhone}")
//     public ZyResult<String> getEditPhoneCode(@PathVariable("newPhone") String newPhone){
//         return miniAuthService.getEditPhoneCode(newPhone);
//     }
//
//     /**
//      * 更新手机号
//      * @param phoneNum  新的手机号
//      * @param code 验证码
//      * @return 更新结果
//      */
//     @PutMapping("/bindNewPhone/{phoneNum}/{code}")
//     public ZyResult<String> bindNewPhone(@PathVariable("phoneNum") String phoneNum, @PathVariable("code") String code){
//         return miniAuthService.updateNewPhone(phoneNum,code);
//     }
// }
