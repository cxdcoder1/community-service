package com.example.community.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.constant.SystemConstant;
import com.example.community.dto.UserAndDeptAndRole;
import com.example.community.entity.SysUser;
import com.example.community.service.SysUserService;
import com.example.community.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息表(SysUser)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@RestController
@RequestMapping("sysUser")
@CrossOrigin
public class SysUserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param sysUser 查询实体
     * @return 所有数据
     */
    @GetMapping("/selectAll")
    public R selectAll(Page<SysUser> page, SysUser sysUser) {

        return success(this.sysUserService.page(page, new QueryWrapper<>(sysUser)));
    }

    @GetMapping("/selectAll2")
    public R selectAll2(Page<SysUser> page, SysUser sysUser) {

        return success(this.sysUserService.page(page, new QueryWrapper<>(sysUser)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public UserAndDeptAndRole selectOne(@PathVariable int id) {
        return sysUserService.getUserInfo(id);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping("login")
    public Map<String,Object> login(@RequestBody SysUser user, HttpServletRequest request) throws Exception {
        Map<String,Object> result = new HashMap<>();
        //校验用户名和密码
        QueryWrapper queryWrapper = new QueryWrapper<SysUser>();
        queryWrapper.eq("phonenumber",user.getPhonenumber());
        //根据电话查询用户z
        SysUser user1 = sysUserService.getOne(queryWrapper);
        if (user1 != null){
            if (user1.getPassword().equals(user.getPassword())){
                //将用户信息存储到Session  //登入成功
                HttpSession session = request. getSession();
                session. setAttribute("userInfo", user1);  //1.用于拦截器的判断  2.界面显示用户信息
                result. put("user", user1);
                //把token返回给客户端-->客户端保存至localStorage-->客户端每次请求附带localStorage参数
                //SystemConstant.JWT_TTL：token有效时间
                String JWT = JwtUtil.createJWT("1", JSON.toJSONString(user1), SystemConstant.JWT_TTL);
//                log.info(JWT);
                result.put("JWT",JWT);
                result.put("status","200");
                return result;
            }
//            //登录失败 ，密码错误
//            result. put("success", false);
//            result. put("msg", "密码错误!");
//            return result;
        }
        //登录失败，用户名错误或不存在
        result. put("success", false);
        result. put("msg", "用户名或密码错误!");
        result.put("status","201");
        return result;
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysUser sysUser) {
        return success(this.sysUserService.save(sysUser));
    }

    /**
     * 修改数据
     *
     * @param sysUser 实体对象
     * @return 修改结果
     */
//    @PutMapping("/updataUser")
//    public R update(SysUser sysUser) {
//        return success(this.sysUserService.updateById(sysUser));
//    }
    @PutMapping("updataUser")
    public R update(@RequestBody SysUser sysUser) {
        System.err.println(sysUser);
       return success(this.sysUserService.updateUser(sysUser));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysUserService.removeByIds(idList));
    }
}

