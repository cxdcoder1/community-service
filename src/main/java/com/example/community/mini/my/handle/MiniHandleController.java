// package com.example.community.mini.my.handle;
//
// import com.example.community.mini.ZyResult;
// import com.example.community.mini.my.handle.dto.AuditingDto;
// import com.example.community.mini.my.handle.dto.BindInfoDto;
// import com.zy.community.mini.service.my.handle.MiniMyHandleService;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.*;
//
// import javax.annotation.Resource;
// import java.util.List;
//
// @RestController
// @RequestMapping("/mini/community/handle")
// public class MiniHandleController {
//     @Resource
//     private MiniMyHandleService miniMyHandleService;
//
//     /**
//      * 查询的数量
//      * @param communityId 社区Id
//      * @return 数量
//      */
//     @GetMapping("/count/{communityId}")
//     public ZyResult<Integer> countWaitMyHandle(@PathVariable("communityId") Long communityId){
//         return miniMyHandleService.countWaitMyHandle(communityId);
//     }
//
//     /**
//      * 查询待审批数据
//      * @param communityId 社区Id
//      * @return 审批数据集合
//      */
//     @GetMapping("/info/{communityId}")
//     public ZyResult<List<BindInfoDto>> findWaitHandleInfo(@PathVariable("communityId") Long communityId){
//         return miniMyHandleService.findAllHandleInfo(communityId);
//     }
//
//     /**
//      * 审批
//      * @param auditingDto 审批数据
//      * @param bindingResult 结果
//      * @return 审批结果
//      */
//     @PostMapping("/audit")
//     public ZyResult<String> auditOption(@RequestBody AuditingDto auditingDto, BindingResult bindingResult){
//         if (bindingResult.hasErrors()){
//             String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
//             return ZyResult.fail(400,defaultMessage);
//         }
//
//         return miniMyHandleService.auditOption(auditingDto);
//     }
//
// }
