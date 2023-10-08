package com.example.community.mini.my.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.community.dao.ZyOwnerDao;
import com.example.community.entity.ZyOwner;
import com.example.community.mini.OwnerFactory;
import com.example.community.mini.SmsComponent;
import com.example.community.mini.ZyResult;
import com.example.community.mini.my.auth.dto.AuthenticationDto;
import com.example.community.mini.my.basic.MiniContextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 实名认证服务
 */
@Service
public class MiniAuthService {
    @Resource
    private ZyOwnerDao zyOwnerMapper;
    @Resource
    private OwnerFactory ownerFactory;
    @Resource
    private SmsComponent smsComponent;

    private final static String EDIT_PHONE_PREFIX = "EDIT_PHONE_";
    // @Resource
    // private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取认证信息
     *
     * @return 认证信息
     */
    @Transactional(readOnly = true)
    public ZyResult<AuthenticationDto> getAuthenticationInfo() {
        String openId = MiniContextUtils.getOpenId();
        if (StringUtils.isEmpty(openId)) return ZyResult.fail(401, "业主未登录认证");
        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>()
                .eq("owner_open_id", openId));
        if (zyOwner == null) {
            return ZyResult.fail(404, "用户信息不存在");
        }
        return ZyResult.data(ownerFactory.transAuthDtoFromZyOwner(zyOwner));
    }

    /**
     * 实名认证
     *
     * @param dto 实名dto
     * @return 结果
     */
    @Transactional
    public ZyResult<String> authenticated(AuthenticationDto dto) {
        String openId = MiniContextUtils.getOpenId();
        if (StringUtils.isEmpty(openId)) {
            return ZyResult.fail(401, "业主未登录认证");
        }
        try {
            zyOwnerMapper.update(null, new UpdateWrapper<ZyOwner>()
                    .set("owner_real_name", dto.getRealName())
                    .set("owner_id_card", dto.getIdCardNum()).eq("owner_open_id", openId));
            return ZyResult.success("实名数据更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ZyResult.fail(500, e.getMessage());
        }

    }

    // /**
    //  * 获取新绑定手机的手机号
    //  *
    //  * @param newPhoneNum 新的手机号
    //  * @return 发送验证码结果
    //  */
    // @Transactional(readOnly = true)
    // public ZyResult<String> getEditPhoneCode(String newPhoneNum) {
    //     if (StringUtils.isEmpty(newPhoneNum)) return ZyResult.fail(400, "绑定手机号不能为空");
    //     //查询新的手机号是否已经绑定过
    //     ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_phone_number", newPhoneNum));
    //     if (zyOwner != null) return ZyResult.fail(400, "手机号已被绑定过,请切换其他手机号");
    //     String code = RandomUtils.nextInt(1000, 10000) + "";
    //     stringRedisTemplate.opsForValue().set(EDIT_PHONE_PREFIX + newPhoneNum, code, 5, TimeUnit.MINUTES);
    //     return smsComponent.sendVerifyCode(newPhoneNum, code);
    // }

    // @Transactional
    // public ZyResult<String> updateNewPhone(String newPhone, String code) {
    //     if (StringUtils.isEmpty(newPhone)) return ZyResult.fail(400, "绑定手机号不能为空");
    //     if (StringUtils.isEmpty(code)) return ZyResult.fail(400,"验证码不能为空");
    //     String persistentCode = stringRedisTemplate.opsForValue().get(EDIT_PHONE_PREFIX + newPhone);
    //     if (StringUtils.isEmpty(persistentCode)) return ZyResult.fail(404,"验证码已经过期,请重新发送");
    //     if (!code.equals(persistentCode)) return ZyResult.fail(400,"验证码错误");
    //     stringRedisTemplate.delete(EDIT_PHONE_PREFIX + newPhone);
    //     //查询新的手机号是否已经绑定过
    //     ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_phone_number", newPhone));
    //     if (zyOwner != null) return ZyResult.fail(400, "手机号已被绑定过,请切换其他手机号");
    //     String openId = MiniContextUtils.getOpenId();
    //     if (StringUtils.isEmpty(openId)) return ZyResult.fail(401,"用户未曾登录认证");
    //     ZyOwner currentOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", openId));
    //     if (currentOwner==null) return ZyResult.fail(404,"该用户已经不存在");
    //
    //     try {
    //         zyOwnerMapper.update(null,new UpdateWrapper<ZyOwner>().set("owner_phone_number",newPhone).eq("owner_open_id",openId));
    //         return ZyResult.success("号码更新成功");
    //     }catch (Exception e){
    //         e.printStackTrace();
    //         return ZyResult.fail(500,e.getMessage());
    //     }
    //
    // }

    public ZyResult<String> updateNewPhone(String newPhone,String openId) {
        if (StringUtils.isEmpty(newPhone)) {
            return ZyResult.fail(400, "绑定手机号不能为空");
        }
        // 查询新的手机号是否已经绑定过
        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_phone_number", newPhone));
        if (zyOwner != null) {
            return ZyResult.fail(400, "手机号已被绑定过,请切换其他手机号");
        }
        // String openId = MiniContextUtils.getOpenId();
        if (StringUtils.isEmpty(openId)) {
            return ZyResult.fail(401, "用户未曾登录认证");
        }
        ZyOwner currentOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", openId));
        if (currentOwner == null) {
            return ZyResult.fail(404, "该用户已经不存在");
        }
        try {
            zyOwnerMapper.update(null, new UpdateWrapper<ZyOwner>().set("owner_phone_number", newPhone).eq("owner_open_id", openId));
            return ZyResult.success("号码更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ZyResult.fail(500, e.getMessage());
        }
    }

}
