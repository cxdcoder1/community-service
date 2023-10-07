package com.example.community.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.constant.AsyncFactory;
import com.example.community.constant.AsyncManager;
import com.example.community.constant.SystemConstant;
import com.example.community.dto.UserAndDeptAndPostAndRole;
import com.example.community.dto.UserAndDeptAndRole;
import com.example.community.dto.UserAndPostIdAndRoleId;
import com.example.community.entity.SysDept;
import com.example.community.entity.SysPost;
import com.example.community.entity.SysRole;
import com.example.community.entity.SysUser;
import com.example.community.service.SysDeptService;
import com.example.community.service.SysDictDataService;
import com.example.community.service.SysUserService;
import com.example.community.utils.Constants;
import com.example.community.utils.DeptTree;
import com.example.community.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息表(SysUser)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
//@Api(tags = "用户管理") //  tags：你可以当作是这个组的名字。
@Api(tags = "用户管理")
@RestController
@Controller
@RequestMapping("sysUser")
@CrossOrigin
public class SysUserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysDeptService sysDeptService;
    @Resource
    private SysDictDataService sysDictDataService;

    //状态
    @GetMapping("userInfoSex")
    public R userInfoSex() {
        return success(this.sysDictDataService.userInfoSex());
    }


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param sysUser 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "获取用户列表接口",notes = "获取用户列表接口的说明")
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
    @ApiOperation(value = "用户登录接口",notes = "用户登录接口的说明")
    @RequestMapping("login")
    public Map<String,Object> login(@RequestBody SysUser user, HttpServletRequest request) throws Exception {
        Map<String,Object> result = new HashMap<>();

        //校验用户名和密码
        QueryWrapper queryWrapper = new QueryWrapper<SysUser>();
        queryWrapper.eq("phonenumber", user.getPhonenumber());
        //根据电话查询用户z
        SysUser user1 = sysUserService.getOne(queryWrapper);
        if (user1 != null){
            if (user1.getPassword().equals(user.getPassword())){
                //校验用户是否被停用
                String status = user1.getStatus();
                if (status.equals("1")){
                    //账号被停用
                    result. put("success", false);
                    result. put("msg", "用户已被停用!");
                    result.put("status","201");
                    AsyncManager.me().execute(AsyncFactory.recordLogininfor(user1.getUserName(), Constants.LOGIN_FAIL,"用户已被停用"));
                    return result;
                }
                //校验部门是否被停用
                if (user1.getDeptId()!=null){
                    SysDept dept = sysDeptService.getById(user1.getDeptId() + "");
                    if (dept.getStatus().equals("1")){
                        //用户的部门被停用
                        result. put("success", false);
                        result. put("msg", "该用户所属部门已被停用!");
                        result.put("status","201");
                        AsyncManager.me().execute(AsyncFactory.recordLogininfor(user1.getUserName(), Constants.LOGIN_FAIL,"该用户所属部门已被停用"));
                        return result;
                    }
                }
                //校验岗位是否被禁用
                SysPost post= sysUserService.getPostStatus(user1.getUserId() + "");
                if (post!=null){
                    if (post.getStatus().equals("1")){
                        //岗位被禁用
                        result. put("success", false);
                        result. put("msg", "该用户所属岗位已被停用!");
                        result.put("status","201");
                        AsyncManager.me().execute(AsyncFactory.recordLogininfor(user1.getUserName(), Constants.LOGIN_FAIL,"该用户所属岗位已被停用"));
                        return result;
                    }
                }

                //将用户信息存储到Session  //登入成功
                HttpSession session = request.getSession();
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(user1.getUserName(), Constants.LOGIN_SUCCESS,"登录成功"));
                session.setAttribute("userInfo", user1);  //1.用于拦截器的判断  2.界面显示用户信息
                result.put("user", user1);
                //把token返回给客户端-->客户端保存至localStorage-->客户端每次请求附带localStorage参数
                //SystemConstant.JWT_TTL：token有效时间
                String JWT = JwtUtil.createJWT("1", JSON.toJSONString(user1), SystemConstant.JWT_TTL);
//                log.info(JWT);
                result.put("JWT", JWT);
                result.put("status", "200");
                return result;
            }
//            //登录失败 ，密码错误
//            result. put("success", false);
//            result. put("msg", "密码错误!");
//            return result;
        }
        //登录失败，用户名错误或不存在
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(user1.getUserName(), Constants.LOGIN_FAIL,"登录失败，账号密码或验证码错误"));
        result.put("success", false);
        result.put("msg", "用户名或密码错误!");
        result.put("status", "201");
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
    @ApiOperation(value = "修改用户接口",notes = "修改用户接口的说明")
    @PutMapping("updataUser")
    public R update(@RequestBody SysUser sysUser) {
//        System.err.println(sysUser);
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

//    @GetMapping("listUser")
//    public HashMap<String,Object> listUser(){
//        HashMap<Object, Object> map = new HashMap<>();
//
//
//
//        return map;
//    }

    @GetMapping("sysUserList")
    public R selectPageAll(Page<UserAndDeptAndPostAndRole> page, UserAndDeptAndPostAndRole userAndDeptAndPostAndRole) {

        System.err.println(userAndDeptAndPostAndRole);
        List<String> s = new ArrayList<>();
        s.add(userAndDeptAndPostAndRole.getDeptId()+"");
        //获取部门的子集
        List<String> ids = sysUserService.getByDeptId(userAndDeptAndPostAndRole.getDeptId());
        if (ids.size()!=0){
            //说明有子集
            ids.add(userAndDeptAndPostAndRole.getDeptId()+"");
            userAndDeptAndPostAndRole.setDeptIds(ids);
            //根据部门以及子集id查询
            return success(this.sysUserService.selUserListByP(page, userAndDeptAndPostAndRole));
        }


        return success(this.sysUserService.selUserlist(page, userAndDeptAndPostAndRole));
    }

    @GetMapping("getUser")
    public HashMap<String, Object> getUser() {
        HashMap<String, Object> map = new HashMap<>();
        List<SysPost> allPost = sysUserService.getAllPost();
        List<SysRole> allRole = sysUserService.getAllRole();

        map.put("posts", allPost);
        map.put("roles", allRole);

        return map;
    }

    @ApiOperation(value = "修改用户接口",notes = "修改用户接口的说明")
    @PutMapping("updateUser")
    public HashMap<String, Object> updateUser(@RequestBody UserAndPostIdAndRoleId userAndPostIdAndRoleId) {
        HashMap<String, Object> map = new HashMap<>();
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userAndPostIdAndRoleId.getUserId());
        sysUser.setDeptId(userAndPostIdAndRoleId.getDeptId());
        sysUser.setSex(userAndPostIdAndRoleId.getSex());
        sysUser.setUserName(userAndPostIdAndRoleId.getUserName());
        sysUser.setEmail(userAndPostIdAndRoleId.getEmail());
        sysUser.setStatus(userAndPostIdAndRoleId.getStatus());
        sysUser.setRemark(userAndPostIdAndRoleId.getRemark());
        sysUser.setNickName(userAndPostIdAndRoleId.getNickName());
        sysUser.setPhonenumber(userAndPostIdAndRoleId.getPhonenumber());
        //验重
        if (sysUserService.isok(sysUser) == 0) {
            System.out.println(sysUser);
            //更新user信息
            sysUserService.updateUser(sysUser);
            //更新user职位
            sysUserService.updatePost(userAndPostIdAndRoleId.getUserId(), userAndPostIdAndRoleId.getPostIds());
            //更新user角色
            sysUserService.updateRole(userAndPostIdAndRoleId.getUserId(), userAndPostIdAndRoleId.getRoleIds());

            map.put("data", 1);

            return map;
        }
        map.put("data", 0);
        return map;
    }

    @ApiOperation(value = "新增用户接口",notes = "新增用户接口的说明")
    @PutMapping("addUser")
    public HashMap<String, Object> addUser(@RequestBody UserAndPostIdAndRoleId userAndPostIdAndRoleId) {
        HashMap<String, Object> map = new HashMap<>();
        System.err.println(userAndPostIdAndRoleId);
        SysUser sysUser = new SysUser();
        sysUser.setPhonenumber(userAndPostIdAndRoleId.getPhonenumber());
        sysUser.setDeptId(userAndPostIdAndRoleId.getDeptId());
        sysUser.setUserName(userAndPostIdAndRoleId.getUserName());
        sysUser.setEmail(userAndPostIdAndRoleId.getEmail());
        sysUser.setPassword(userAndPostIdAndRoleId.getPassword());
        sysUser.setStatus(userAndPostIdAndRoleId.getStatus());
        sysUser.setRemark(userAndPostIdAndRoleId.getRemark());
        sysUser.setNickName(userAndPostIdAndRoleId.getNickName());
        //验重
        if (sysUserService.isok(sysUser) == 0) {

            //插入user信息并返还对象
            sysUserService.insertUser(sysUser);
            //插入新user职位
            sysUserService.insertPost(sysUser.getUserId(), userAndPostIdAndRoleId.getPostIds());
            //插入新user角色
            sysUserService.insertRole(sysUser.getUserId(), userAndPostIdAndRoleId.getRoleIds());

            map.put("data", 1);
            return map;
        }
        map.put("data", 0);
        return map;
    }
    //密码重置
    @ApiOperation(value = "用户重置密码接口",notes = "用户重置密码接口的说明")
    @PutMapping("resetPwd")
    public R resetPwd(@RequestParam("id") int id,@RequestParam("pwd") Long pwd) {

        return success(this.sysUserService.restUserPwd(id,pwd));
    }

    //状态
    @PutMapping("updateUserStatus")
    public R updateUser(@RequestParam("id") int id,@RequestParam("status") String status) {
        return success(this.sysUserService.upDataStatus(id,status));
    }

    @PostMapping("getDeptList")
    public Map<String, Object> getMenuList(@RequestBody SysDept sysDept) {
        Map<String, Object> result = new HashMap<>();
        List<SysDept> sysDeptList = sysUserService.selAllDept(sysDept);
        int len = sysDeptList.size();
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (sysDeptList.get(i).getParentId().equals(sysDeptList.get(j).getDeptId())) {
                    count++;
                }
            }
            if (count == 0) {
                sysDeptList.get(i).setParentId(0L);
            }
        }
        DeptTree deptTree = new DeptTree(sysDeptList);
        List<SysDept> sysDepts = deptTree.builTree();
        result.put("menuList", sysDepts);
        result.put("msg", "获取成功");
        System.err.println(result);
        return result;
    }

    ;

    //状态下拉框
    @GetMapping("/userStatusOption")
    public R statusOption() {
        return success(this.sysDictDataService.userStatusOption());
    }


    @ApiOperation(value = "批量删除用户接口",notes = "批量删除用户接口的说明")
    @PostMapping("deleteUsers")
    public HashMap<String, Object> deleteUsers(@RequestBody List<String> list) {
        HashMap<String, Object> map = new HashMap<>();
        Integer i = sysUserService.deleteUsers(list);
        if (i!=0){
            map.put("status","200");
            map.put("msg","删除成功");
        }else {
            map.put("status","201");
            map.put("msg","删除失败");
        }
        return map;
    }

    @ApiOperation(value = "删除用户接口",notes = "删除用户接口的说明")
    @DeleteMapping("delUser/{id}")
    public HashMap<String, Object> deleteUsers(@PathVariable String id) {
        HashMap<String, Object> map = new HashMap<>();
        Integer i = sysUserService.delById(id);
        if (i!=0){
            map.put("status","200");
            map.put("msg","删除成功");
        }else {
            map.put("status","201");
            map.put("msg","删除失败");
        }
        return map;
    }


}

