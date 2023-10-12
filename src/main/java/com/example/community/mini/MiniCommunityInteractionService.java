package com.example.community.mini;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.example.community.dao.ZyCommentDao;
import com.example.community.dao.ZyCommunityInteractionDao;
import com.example.community.dao.ZyFilesDao;
import com.example.community.entity.ZyComment;
import com.example.community.entity.ZyCommunityInteraction;
import com.example.community.entity.ZyFiles;
import com.example.community.mini.dto.dto.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 小程序的互动信息服务
 */
@Service
public class MiniCommunityInteractionService {
    @Resource
    private InteractionFactory interactionFactory;
    @Resource
    private ZyCommunityInteractionDao zyCommunityInteractionMapper;
    @Resource
    private ZyFilesDao zyFilesMapper;
    @Resource
    private ZyCommentDao zyCommentMapper;

    /**
     * 发帖
     *
     * @param dto 发布数据
     * @return 发布结果
     */
    @Transactional
    public ZyResult<String> savePostTopic(CommunityInteractionDto dto) {
        ZyCommunityInteraction byDto = interactionFactory.createByDto(dto);
        zyCommunityInteractionMapper.insertInteraction(byDto);
        //新增图片
        if (dto.getImageUrls().size() > 0) {
            List<ZyFiles> files = new ArrayList<>();
            DefaultIdentifierGenerator defaultIdentifierGenerator = new DefaultIdentifierGenerator();
            dto.getImageUrls().forEach(url -> {
                ZyFiles zyFiles = new ZyFiles();
                zyFiles.setFilesId(defaultIdentifierGenerator.nextId(null));
                zyFiles.setFilesUrl(url);
                zyFiles.setCreateTime(new Date());
                zyFiles.setSource(0);//来源0APP端，1PC端
                zyFiles.setUserId(byDto.getUserId());
                zyFiles.setParentId(byDto.getInteractionId());//设置图片所属
                zyFiles.setRemark("CommunityInteraction");
                files.add(zyFiles);
            });
            zyFilesMapper.insertFilesBatch(files);
        }
        return ZyResult.success("发布帖子成功");

    }

    public ZyResult<String> delCom(String comId) {
        int i = zyCommunityInteractionMapper.delCom(comId);

        return ZyResult.data(i+"");
    }

    public ZyResult<String> delInter(String interId) {
        int i = zyCommunityInteractionMapper.delInter(interId);
        int i1 = zyCommunityInteractionMapper.delCom2(interId);

        return ZyResult.data(i+"");
    }

    /**
     * 查询最新的4条记录
     *
     * @param communityId 社区Id
     * @return 结果
     */
    public ZyResult<List<InteractionDto>> findTop4Interaction(Long communityId) {
        return ZyResult.data(zyCommunityInteractionMapper.findTop4Interactions(communityId));
    }

    public ZyResult<List<InteractionDetailDto>> findTop3Interaction(Long communityId) {
        return ZyResult.data(zyCommunityInteractionMapper.findTop3Interactions(communityId));
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 记录数
     * @param communityId 社区Id
     * @return 分页信息
     */
    public ZyResult<PageInfo<InteractionDetailDto>> findInteractionByPage(Integer page, Integer size, Long communityId){
        PageHelper.startPage(page,size);
        List<InteractionDetailDto> pageInteractions = zyCommunityInteractionMapper.findPageInteractions(communityId);
        PageInfo<InteractionDetailDto> interactionDtoPageInfo = new PageInfo<>(pageInteractions);
        return ZyResult.data(interactionDtoPageInfo);
    }

    /**
     * 通过Id查找交互信息
     *
     * @param interactionId 交互Id
     * @return 交互信息
     */
    public ZyResult<InteractionDetailDto> findById(Long interactionId) {
        return ZyResult.data(zyCommunityInteractionMapper.findById(interactionId));
    }

    /**
     * 保存评论数据
     *
     * @param dto 评论数据
     * @return 评论结果(Id)
     */
    public ZyResult<ZyComment> postComment(CommentRequestDto dto) {
        ZyComment comment = interactionFactory.createComment(dto);
        zyCommentMapper.insert(comment);
        return ZyResult.data(comment);
    }

    /**
     * 获取互动信息下的所有评论信息
     *
     * @param interactionId 互动Id
     * @return 评论的所有信息
     */
    public ZyResult<List<CommentRootDto>> findCommentList(Long interactionId) {
        List<CommentRootDto> allComment = zyCommentMapper.findAllComment(interactionId);
        if (allComment != null && allComment.size() > 0) {

            List<CommentRootDto> roots = allComment.stream()
                    .filter(comment ->
                            comment.getParentId().equals(Long.valueOf("-1")))
                    .map(rootDto -> {
                        setChildren(rootDto,allComment);
                        return rootDto;
                    }).collect(Collectors.toList());
            return ZyResult.data(roots);
        }
        return ZyResult.data(new ArrayList<>());
    }

    private void setChildren(CommentRootDto root, List<CommentRootDto> all){
        List<CommentRootDto> collect = all.stream().filter(dto -> dto.getRootId()!=null && dto.getRootId().equals(root.getCommentId())).collect(Collectors.toList());
        root.setChildren(collect);
    }


}
