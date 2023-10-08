package com.example.community.mini;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.community.dao.ZyOwnerDao;
import com.example.community.entity.ZyOwner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 小程序的登录、注册、发送短信服务
 */
@Service
public class MiniLoginService {
    @Resource
    private WeChatComponent weChatComponent;

    @Resource
    private ZyOwnerDao zyOwnerMapper;
    // @Resource
    // private StringRedisTemplate stringRedisTemplate;
    @Resource
    private SmsComponent smsComponent;
    @Resource
    private OwnerFactory ownerFactory;

    private final static String SMS_PREFIX = "MINI_LOGIN_CODE_";

    /**
     * 小程序登录处理
     *
     * @param code 小程序登录码
     * @return 登录结果
     */
    @Transactional
    public ZyResult<MiniUserDto> weChatLogin(String code) {
        ZyResult<String> openIdByCode = weChatComponent.getOpenIdByCode(code);
        System.out.println(openIdByCode);
        if (openIdByCode.getCode() != 200) {
            return ZyResult.fail(500, "网络异常,请稍后重试");
        }
        String openId = openIdByCode.getData();
        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", openId));
        if (zyOwner == null) {
            //如果没有用户,那么需要前台进行进行注册,返回需要注册的标记
            ZyOwner zyOwner1 = new ZyOwner();
            zyOwner1.setOwnerOpenId(openId);
            zyOwner1.setOwnerId(System.currentTimeMillis());
            zyOwner1.setOwnerRealName("whx");
            zyOwner1.setOwnerGender("Male");
            zyOwner1.setOwnerNickname("哈哈");
            zyOwnerMapper.insert(zyOwner1);
            ZyOwner zyOwner2 = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", openId));
            return ZyResult.data(ownerFactory.transFromZyOwner(zyOwner2));
        } else {
            //如果注册了,那么进行返回登录信息
            return ZyResult.data(ownerFactory.transFromZyOwner(zyOwner));
        }
    }

    // @Transactional
    // public ZyResult<MiniUserDto> weChatRegister(RegisterDto registerDto) {
    //     //校验验证码
    //     if (!verifyCode(registerDto.getPhoneNum(), registerDto.getCode())) {
    //         return ZyResult.fail("验证码错误或已失效,请重新发送验证码");
    //     }
    //     //注册用户
    //     ZyOwner zyOwner = ownerFactory.createOwnerWithRegisterDto(registerDto);
    //     int insert = zyOwnerMapper.insert(zyOwner);
    //     if (insert > 0) {
    //         //注册成功返回
    //         return ZyResult.data(ownerFactory.transFromZyOwner(zyOwner));
    //     } else {
    //         return ZyResult.fail(500, "用户注册失败");
    //     }
    //
    // }

    // /**
    //  * 发送验证码
    //  *
    //  * @param phoneNum 手机号
    //  * @return 发送结果
    //  */
    // public ZyResult<String> sendCode(String phoneNum) {
    //     if (StringUtils.isEmpty(phoneNum)) return ZyResult.fail("手机号不能为空");
    //     String key = SMS_PREFIX + phoneNum;
    //     String code = RandomUtils.nextInt(1000, 9999) + "";
    //     stringRedisTemplate.opsForValue().set(key, code,5, TimeUnit.MINUTES);
    //     return smsComponent.sendVerifyCode(phoneNum, code);
    // }

    // /**
    //  * 校验验证码
    //  *
    //  * @param phoneNum   手机号
    //  * @param verifyCode 传入的验证码
    //  * @return true:校验通过,false:校验失败
    //  */
    // private boolean verifyCode(String phoneNum, String verifyCode) {
    //     String key = SMS_PREFIX + phoneNum;
    //     String code = stringRedisTemplate.opsForValue().get(key);
    //     if (StringUtils.isEmpty(code)) {
    //         return false;
    //     }
    //     //删除key
    //     stringRedisTemplate.delete(key);
    //     return code.equals(verifyCode);
    // }
}
