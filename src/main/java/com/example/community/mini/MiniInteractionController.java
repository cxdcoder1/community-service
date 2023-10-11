package com.example.community.mini;

import com.example.community.entity.ZyComment;
import com.example.community.mini.dto.dto.*;
import com.github.pagehelper.PageInfo;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mini/community/interaction")
public class MiniInteractionController {
    @Resource
    private MiniCommunityInteractionService miniCommunityInteractionService;

    @GetMapping("delCom/{comId}")
    public ZyResult<String> delCom(@PathVariable("comId") String comId){

        return miniCommunityInteractionService.delCom(comId);
    }
    @GetMapping("delInter/{interactionId}")
    public ZyResult<String> delInter(@PathVariable("interactionId") String interactionId){

        return miniCommunityInteractionService.delInter(interactionId);
    }

    @PostMapping("/save")
    public ZyResult<String> saveInteraction(@RequestBody CommunityInteractionDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ZyResult.fail(400, bindingResult.getFieldError().getDefaultMessage());
        }
        return miniCommunityInteractionService.savePostTopic(dto);
    }

    @GetMapping("/{communityId}")
    public ZyResult<List<InteractionDto>> findTop4(@PathVariable("communityId") Long communityId) {
        return miniCommunityInteractionService.findTop4Interaction(communityId);
    }

    @GetMapping("hotTopic/{communityId}")
    public ZyResult<List<InteractionDetailDto>> findTop3(@PathVariable("communityId") Long communityId) {
        return miniCommunityInteractionService.findTop3Interaction(communityId);
    }

    @GetMapping("/page/{page}/{size}/{communityId}")
    public ZyResult<PageInfo<InteractionDetailDto>> findPageInfo(@PathVariable("page") Integer page,
                                                                 @PathVariable("size") Integer size,
                                                                 @PathVariable("communityId") Long communityId) {
        return miniCommunityInteractionService.findInteractionByPage(page, size, communityId);
    }


    @GetMapping("/detail/{id}")
    public ZyResult<InteractionDetailDto> findById(@PathVariable("id") Long id) {
        return miniCommunityInteractionService.findById(id);
    }

    @PostMapping("/comment")
    public ZyResult<ZyComment> postComment(@RequestBody @Valid CommentRequestDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ZyResult.fail(400, bindingResult.getFieldError().getDefaultMessage());
        }
        return miniCommunityInteractionService.postComment(dto);
    }

    @GetMapping("/allComments/{interactionId}")
    public ZyResult<List<CommentRootDto>> findAllComment(@PathVariable("interactionId") Long interactionId) {
        return miniCommunityInteractionService.findCommentList(interactionId);
    }
}
