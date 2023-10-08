package com.example.community.mini;

import com.example.community.entity.ZyOwner;
import com.example.community.mini.my.auth.dto.AuthenticationDto;
import com.example.community.mini.my.basic.dto.UserBasicDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 业主转化工厂
 */
@Component
public class OwnerFactory {
    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private AesSecretComponent aesSecretComponent;

    /**
     * 将持久化实体转化为Dto
     *
     * @param zyOwner 持久化实体
     * @return dto
     */
    public MiniUserDto transFromZyOwner(ZyOwner zyOwner) {
        if (zyOwner == null) {
            return null;
        }
        MiniUserDto dto = new MiniUserDto();
        dto.setGender(transGenderFromEnum(zyOwner.getOwnerGender()));
        dto.setBirthday(Instant.ofEpochMilli(zyOwner.getOwnerBirthday().getTime()).atOffset(ZoneOffset.ofHours(8)).toLocalDate().toString());
        dto.setAvatar(zyOwner.getOwnerPortrait());
        dto.setNickName(zyOwner.getOwnerNickname());
        dto.setOpenId(zyOwner.getOwnerOpenId());
        dto.setPhoneNum(zyOwner.getOwnerPhoneNumber());
        dto.setMiniToken(getToken(zyOwner.getOwnerOpenId(), zyOwner.getOwnerPhoneNumber()));
        dto.setAuthenticated(!StringUtils.isEmpty(zyOwner.getOwnerIdCard()) && !StringUtils.isEmpty(zyOwner.getOwnerRealName()));
        return dto;
    }

    public ZyOwner createOwnerWithRegisterDto(RegisterDto registerDto){
        if(registerDto==null) {
            return null;
        }
        ZyOwner zyOwner = new ZyOwner();
        zyOwner.setOwnerBirthday(registerDto.getBirthday());
        if (registerDto.getBirthday() != null) {
            //年龄计算
            zyOwner.setOwnerAge(calculateAge(registerDto.getBirthday()));
        }
        String gender = registerDto.getGender();
        if (gender != null) {
            zyOwner.setOwnerGender(transGenderFromInt(gender));
        }
        zyOwner.setOwnerOpenId(registerDto.getOpenId());
        zyOwner.setOwnerLogonMode(LogonMode.WeChat+"");
        zyOwner.setOwnerPhoneNumber(registerDto.getPhoneNum());
        zyOwner.setOwnerNickname(registerDto.getNickName());
        zyOwner.setOwnerPortrait(registerDto.getAvatar());
        zyOwner.setOwnerStatus(OwnerStatus.Enable+"");
        zyOwner.setCreateTime(new Date());
        zyOwner.setUpdateTime(new Date());
        return zyOwner;
    }

    /**
     * 依赖zyOwner将basicInfo信息填充至持久化实体
     *
     * @param dto     dto
     * @param zyOwner 持久化实体
     * @return 持久化实体
     */
    public void transFromBasicDtoWithZyOwner(UserBasicDto dto, ZyOwner zyOwner) {
        if (dto == null) {
            return;
        }
        zyOwner.setOwnerGender(transGenderFromInt(dto.getGender()));
        zyOwner.setOwnerNickname(dto.getNickName());
        zyOwner.setOwnerPortrait(dto.getAvatar());
        zyOwner.setOwnerBirthday(transDateFromStr(dto.getBirthday()));
    }

    public AuthenticationDto transAuthDtoFromZyOwner(ZyOwner owner){
        if (owner==null) {
            return null;
        }
        AuthenticationDto dto = new AuthenticationDto();
        dto.setRealName(owner.getOwnerRealName());
        dto.setIdCardNum(owner.getOwnerIdCard());
        return dto;
    }




    private String transGenderFromEnum(String gender) {
        switch (gender) {
            case "Male":
                return "1";
            case "Female":
                return "2";
            default:
                return "0";
        }
    }

    private String transGenderFromInt(String gender) {
        switch (gender) {
            case "1":
                return Gender.Male+"";
            case "2":
                return Gender.Female+"";
            default:
                return Gender.UnKnown+"";
        }
    }

    /**
     * birthday的格式为; 2020-10-10
     *
     * @param birthday 日期字符串
     * @return 日期类型
     */
    private Date transDateFromStr(String birthday) {
        Instant instant = LocalDate.parse(birthday, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay().atOffset(ZoneOffset.ofHours(8)).toInstant();
        return Date.from(instant);
    }

    /**
     * 加密获取令牌
     *
     * @param openId   openId
     * @param phoneNum 手机号
     * @return 令牌
     */
    private String getToken(String openId, String phoneNum) {
        try {
            Map info = new HashMap();
            info.put("openId", openId);
            info.put("phoneNum", phoneNum);
            String infoStr = objectMapper.writeValueAsString(info);
            return aesSecretComponent.encrypt(infoStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 计算岁数
     *
     * @param birthday 生日
     * @return 岁数
     */
    private Integer calculateAge(Date birthday) {
        LocalDate localDate = Instant.ofEpochMilli(birthday.getTime()).atOffset(ZoneOffset.ofHours(8)).toLocalDate();
        int years = Period.between(localDate, LocalDate.now()).getYears();
        return years;
    }

}
