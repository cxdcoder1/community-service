package com.example.community.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.dto.CommunityAndDeptDto;
import com.example.community.entity.ZyBuilding;
import com.example.community.dto.RolesAndMenuIds;
import com.example.community.entity.ZyCommunity;
import com.example.community.log.BusinessType;
import com.example.community.log.Log;
import com.example.community.service.ZyBuildingService;
import com.example.community.service.ZyCommunityService;
import com.example.community.service.impl.ZyBuildingServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小区 (ZyCommunity)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Api(tags = "小区管理")
@RestController
@RequestMapping("zyCommunity")
@CrossOrigin
public class ZyCommunityController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ZyCommunityService zyCommunityService;

    @Resource
    private ZyBuildingService zyBuildingService;

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param zyCommunity 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "获取小区列表接口",notes = "获取小区列表接口的说明")
    @GetMapping("getCommunityAll")
    public R getcommunityAll(Page<CommunityAndDeptDto> page, CommunityAndDeptDto zyCommunity) {

        return success(this.zyCommunityService.getCommunity(page, zyCommunity));
    }

    /**
     * 批量删除数据
     *
     * @param
     * @return 删除
     */
    @Log(title = "小区管理", businessType = BusinessType.DELETE)
    @DeleteMapping("delCommunity")
    public Map<String, Object> delCommunity(@RequestBody List<String> id) {

        System.err.println(id);

        Map<String, Object> map = new HashMap<>();

        int zyBuildings = zyBuildingService.selectNames(id).size();

        System.err.println(zyBuildings);

        if (zyBuildings > 0) {
            map.put("msg", "该数据在别的地方存在");
            map.put("status", 201);
            map.put("success", false);
            return map;
        }
        zyCommunityService.deleteCommunity(id);
        map.put("msg", "删除成功");
        map.put("status", 200);
        map.put("success", true);
        return map;
    }


    /**
     * 删除数据
     *
     * @param id 主键结合
     * @return 删除结果
     */
    @Log(title = "小区管理", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除小区接口",notes = "删除小区接口的说明")
    @DeleteMapping("delCummunity")
    public Map<String, Object> delCummunity(@RequestParam("id") String id) {
        System.err.println(id);
        List<ZyBuilding> zyBuilding = zyBuildingService.selectName(id);

        Map<String, Object> map = new HashMap<>();

        if (zyBuilding.size() > 0) {
            map.put("msg", "删除失败，楼栋存在");
            map.put("status", 201);
            return map;
        }

        zyCommunityService.delCommunity(id);
        map.put("msg", "删除成功");
        map.put("status", 200);
        return map;
    }

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param zyCommunity 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ZyCommunity> page, ZyCommunity zyCommunity) {
        return success(this.zyCommunityService.page(page, new QueryWrapper<>(zyCommunity)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
//    @GetMapping("{id}")
//    public R selectOne(@PathVariable Serializable id) {
//        return success(this.zyCommunityService.getById(id));
//    }

    /**
     * 新增数据
     *
     * @param zyCommunity 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ZyCommunity zyCommunity) {
        return success(this.zyCommunityService.save(zyCommunity));
    }

    /**
     * 修改数据
     *
     * @param zyCommunity 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ZyCommunity zyCommunity) {
        return success(this.zyCommunityService.updateById(zyCommunity));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.zyCommunityService.removeByIds(idList));
    }

    /**
     * 新增数据
     *
     * @param zyCommunity 实体对象
     * @return 新增结果
     */
    @Log(title = "小区管理", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增小区接口",notes = "新增小区接口的说明")
    @PostMapping("insCommunity")
    public Map<String, Object> insCommunity(@RequestBody ZyCommunity zyCommunity) {
//        System.err.println(zyCommunity.toString());

        Map<String, Object> map = new HashMap<>();

        System.err.println(zyCommunity);

        String communityProvenceCode = zyCommunity.getCommunityProvenceCode();
        String communityCityCode = zyCommunity.getCommunityCityCode();

        List<ZyCommunity> zyCommunities1 = zyCommunityService.selCommunityCity(zyCommunity);

        List<ZyCommunity> zyCommunities = zyCommunityService.selCommunityDerive(zyCommunity);

        zyCommunity.setCreateTime(new Date());

        if (zyCommunities1.size() > 0) {
            if(zyCommunities.size() > 0){
                map.put("msg", "重复");
                map.put("status", 201);
                return map;
            }
        }
        zyCommunityService.insCommunit(zyCommunity);
        map.put("msg", "新增成功");
        map.put("status", 200);
        return map;
    }

    /**
     * 修改数据
     *
     * @param zyCommunity 实体对象
     * @return 新增结果
     */
    @Log(title = "小区管理", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改小区接口",notes = "修改小区接口的说明")
    @PutMapping("updCommunity")
    public Map<String, Object> updCommunity(@RequestBody ZyCommunity zyCommunity) {
        System.err.println(zyCommunity.toString());

        Map<String, Object> map = new HashMap<>();


        List<ZyCommunity> zyCommunities1 = zyCommunityService.selCommunityCity(zyCommunity);
        System.out.println(zyCommunities1);
//        List<ZyCommunity> zyCommunities = zyCommunityService.selCommunityDerive(zyCommunity);
//        System.out.println(zyCommunities);
        if (zyCommunities1.size() == 0) {
            zyCommunityService.updCommunityDerive(zyCommunity);
            map.put("msg", "修改成功");
            map.put("status", 200);
            return map;
        } else {

            ZyCommunity zyCommunity1 = zyCommunities1.get(0);

            String a = zyCommunity1.getCommunityId();
            String b = zyCommunity.getCommunityId();

            if (a.equals(b)) {
                zyCommunityService.updCommunityDerive(zyCommunity);
                map.put("msg", "修改成功");
                map.put("status", 200);
                return map;
            }
        }
        map.put("msg", "重复");
        map.put("status", 201);
        return map;
    }


    /**
     * 修改物业
     *
     * @param communityId deptId 实体对象
     * @return 新增结果
     */
    @Log(title = "小区管理", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改物业接口",notes = "修改物业接口的说明")
    @PutMapping("replacement")
    public Map<String, Object> replacement(@PathParam("communityId") String communityId, @PathParam("deptId") String deptId) {

        System.err.println(communityId + "|" + deptId);


        Map<String, Object> map = new HashMap<>();


        zyCommunityService.updCommunity(communityId, deptId);

        map.put("msg","成功");
        return map;
    }


    /**
     * 获取小区信息
     *
     * @return
     */
    @ApiOperation(value = "获取小区集合接口",notes = "获取小区集合接口的说明")
    @GetMapping("getUCommunity")
    public Map<String, Object> getUCommunity() {
        HashMap<String, Object> result = new HashMap<>();
        List<ZyCommunity> uCommunity = zyCommunityService.getUCommunity();
        result.put("communityList", uCommunity);
        return result;
    }

    @GetMapping("getRoom")
    public R getRoom() {
        return success(this.zyCommunityService.getZyCommunityS());
    }
}

