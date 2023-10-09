package com.example.community.mini;

import com.example.community.entity.ZyOwner;
import com.example.community.service.ZyOwnerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 实名认证
 */
@RestController
@RequestMapping("/mini/community/auth")
public class MiniOwnerIDCardController {

    @Resource
    private ZyOwnerService zyOwnerService;

    @Resource
    private OwnerFactory ownerFactory;

    /**
     * 实名认证信息提交
     *
     * @param zyOwner 业主信息
     * @return 实名结果
     */
    @PostMapping("/authenticated")
    public Map<String, Object> authenticated(@RequestBody ZyOwner zyOwner) {
        HashMap<String, Object> result = new HashMap<>();


        //验重
        ZyOwner owner = zyOwnerService.getByIdCard(zyOwner.getOwnerIdCard());
        if (owner != null) {
            //身份证号码已经存在
            result.put("msg", "认证失败,身份证号码已经存在");
            result.put("status", 201);
            return result;
        }

        //修改
        Integer i = zyOwnerService.updateIdCard(zyOwner);
        if (i != 1) {
            //修改失败
            result.put("msg", "认证失败");
            result.put("status", 201);
            return result;
        }
        //修改成功
        ZyOwner newOwner = zyOwnerService.getByIdCard(zyOwner.getOwnerIdCard());
        result.put("msg", "认证成功");
        result.put("status", 200);
        result.put("idCard", newOwner.getOwnerIdCard());
        result.put("realName", newOwner.getOwnerRealName());
        return result;
    }

    /**
     * 获取用户的实名信息
     *
     * @return 实名信息
     */
    @GetMapping("/owner")
    public Map<String, Object> getAuthenticationInfo( String openId) {
        HashMap<String, Object> result = new HashMap<>();
        ZyOwner owner = zyOwnerService.getByOpenId(openId);
        if (owner.getOwnerIdCard()==null||owner.getOwnerRealName()==null){
            //身份证跟姓名不存在
            result.put("msg","身份证跟姓名不存在");
            result.put("status",201);
            return result;
        }
        result.put("realName",owner.getOwnerRealName());
        result.put("idCardNum",owner.getOwnerIdCard());
        result.put("msg","获取成功");
        result.put("status",200);
        return result;
    }
}
