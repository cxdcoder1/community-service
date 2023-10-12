package com.example.community.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.dto.FeilsImgs;
import com.example.community.dto.InterCationAndOwner;
import com.example.community.entity.ZyComment;
import com.example.community.entity.ZyCommunityInteraction;
import com.example.community.entity.ZyFiles;
import com.example.community.service.ZyCommentService;
import com.example.community.service.ZyCommunityInteractionService;
import com.example.community.service.ZyOwnerService;
import io.swagger.annotations.Api;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Length;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.io.Serializable;
import java.util.*;

/**
 * 社区互动表(ZyCommunityInteraction)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Api(tags = "社区互动")
@RestController
@RequestMapping("zyCommunityInteraction")
@CrossOrigin
public class ZyCommunityInteractionController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ZyCommunityInteractionService zyCommunityInteractionService;

    @Resource
    private ZyCommentService zyCommentService;

    @Resource
    private ZyOwnerService zyOwnerService;

    @PutMapping("getCommentParentIds")
    public Map<String,Object> getCommentParentIds(@PathParam("id") String id) {
        System.err.println(id);
        Map<String, Object> map = new HashMap<>();
        List<String> resultList = new ArrayList<>();
        int i = 0;
        List<String> ids=new ArrayList<>();
        ids.add(id);
        resultList.add(id);
        while (true) {
            i++;
            System.err.println(ids);
            List<String> sel = zyCommunityInteractionService.getRoomParentIds(ids); // 这是我查询的数据

            for(String s:sel){
                resultList.add(s);
            }

            if (sel == null || sel.isEmpty()) {
                break; // 退出循环（查询结果为空）
            }
            System.err.println(i + "|" + sel);
            ids = sel;
            System.err.println(id);
        }

        zyCommunityInteractionService.updCommentId(resultList);
        System.err.println("删除数据" + resultList);
        map.put("msg","删除成功");
        return map;
    }


    @GetMapping("getParentIds")
    public Map<String,Object> getParentIds(@PathParam("id") String id) {

        Map<String, Object> map = new HashMap<>();
        List<InterCationAndOwner> parentIds = zyCommentService.getParentIds(id);
        System.out.println(parentIds);
        List<String> objectsName = new ArrayList<>();
        for(InterCationAndOwner parentId:parentIds){
            System.err.println(parentId);
            String zyOwnerName = zyCommunityInteractionService.getUserName(parentId.getParentId());
            objectsName.add(zyOwnerName);
        }
        System.err.println(objectsName);
        map.put("objectsName",objectsName);
        return map;
    }



    @GetMapping("getFeilsUrl")
    public Map<String,Object> getFeilsUrl(String id) {
        Map<String, Object> map = new HashMap<>();
        List<FeilsImgs> feilsUrl = zyCommunityInteractionService.getFeilsUrl(id);
        System.err.println(feilsUrl);
        List<String> ParentId = new ArrayList<>();
        List<String> FilesUrl = new ArrayList<>();
        for(FeilsImgs fls:feilsUrl){
            ParentId.add(fls.getParentId());
            FilesUrl.add(fls.getFilesUrl());
        }
        map.put("ParentId",ParentId);
        map.put("FilesUrl",FilesUrl);
        return map;
    }

//    @GetMapping("getFeilsUrl")
//    public Map<String,Object> getFeilsUrl(String id) {
//        Map<String, Object> map = new HashMap<>();
//        List<ZyFiles> feilsUrl = zyCommunityInteractionService.getFeilsUrl(id);
//
//        List<String> feilsUrlsName = new ArrayList<>();
//        for(ZyFiles fls:feilsUrl){
//            feilsUrlsName.add(fls.getFilesUrl());
//            feilsUrlsName.add(String.valueOf(fls.getParentId()));
//        }
//        System.err.println(feilsUrl);
//        map.put("Urls",feilsUrl);
//        return map;
//    }


//    @GetMapping("getUserName")
//    public R getUserName(@PathParam("id") String id) {
//        System.err.println(id);
//        return success(this.zyCommunityInteractionService.getUserName(id));
//    }


    @PutMapping("updDelFlag")
    @Transactional
    public Map<String,Object> update(@PathParam("id") String id) {
        Map<String, Object> map = new HashMap<>();
        zyCommentService.updDelFlag(id);
        map.put("msg", "删除成功");
        map.put("status", 200);
        return map;
    }

    @GetMapping("getInteractionService")
    public R selectAll(Page<InterCationAndOwner> page, InterCationAndOwner interCationAndOwner) {
        return success(this.zyCommunityInteractionService.getInterCationAll(page,interCationAndOwner));
    }

    @GetMapping("getInteractionList")
    public R selectAll(String  interactionId) {
        return success(this.zyCommunityInteractionService.getInterCationList(interactionId));
    }


    @PutMapping("delInteraction")
    public Map<String,Object> update(@PathParam("id") String id, @PathParam("type") String type) {
        Map<String, Object> map = new HashMap<>();
        zyCommunityInteractionService.deleteByUserId(id,type);
        map.put("msg", "删除成功");
        map.put("status", 200);
        return map;
    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param zyCommunityInteraction 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ZyCommunityInteraction> page, ZyCommunityInteraction zyCommunityInteraction) {
        return success(this.zyCommunityInteractionService.page(page, new QueryWrapper<>(zyCommunityInteraction)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.zyCommunityInteractionService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param zyCommunityInteraction 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ZyCommunityInteraction zyCommunityInteraction) {
        System.err.println(zyCommunityInteraction);
        return success(this.zyCommunityInteractionService.save(zyCommunityInteraction));
    }




    /**
     * 修改数据
     *
     * @param zyCommunityInteraction 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ZyCommunityInteraction zyCommunityInteraction) {
        return success(this.zyCommunityInteractionService.updateById(zyCommunityInteraction));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.zyCommunityInteractionService.removeByIds(idList));
    }
}

