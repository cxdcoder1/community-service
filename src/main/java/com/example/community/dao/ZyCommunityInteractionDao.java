package com.example.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.FeilsImgs;
import com.example.community.dto.InterCationAndOwner;
import com.example.community.dto.OwnerRoomList;
import com.example.community.entity.ZyFiles;
import org.apache.ibatis.annotations.Param;
import com.example.community.entity.ZyCommunityInteraction;
import com.example.community.mini.ZyCommunityInteractionDto;
import com.example.community.mini.dto.dto.InteractionDetailDto;
import com.example.community.mini.dto.dto.InteractionDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 社区互动表(ZyCommunityInteraction)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyCommunityInteractionDao extends BaseMapper<ZyCommunityInteraction> {

    /**
     * 查询列表
     * @param zyCommunityInteraction
     * @return
     */
    @Select("<script>" +
            "SELECT " +
            "d.interaction_id,d.community_id,d.create_time," +
            "d.content," +
            "d.remark ,a.owner_nickname as ownerNickname,a.owner_real_name as ownerRealName," +
            "a.owner_phone_number as ownerPhoneNumber " +
            "FROM zy_community_interaction d " +
            "LEFT JOIN zy_owner a on a.owner_id = d.user_id " +
            "<where>" +
            "<if test=\"ownerNickname !=null and ownerNickname != ''\">" +
            "and a.owner_nickname like concat('%',#{ownerNickname},'%') " +
            "</if>" +
            "<if test=\"ownerRealName !=null and ownerRealName != ''\">" +
            "and a.owner_real_name like concat('%',#{ownerRealName},'%') " +
            "</if>" +
            "<if test=\"ownerPhoneNumber !=null and ownerPhoneNumber != ''\">" +
            "and a.owner_phone_number like concat('%',#{ownerPhoneNumber},'%') " +
            "</if>" +
            "<if test=\"createBy !=null and createBy != ''\">" +
            "and d.user_id = #{userId} " +
            "</if>" +
            "and d.community_id = #{communityId} and del_flag = 0 " +
            "</where>" +
            " order by d.create_time DESC" +
            "</script>")
    List<ZyCommunityInteractionDto> selectInteractionList(ZyCommunityInteractionDto zyCommunityInteraction);


    @Select("SELECT\n" +
            "\ta.interaction_id as interactionId,\n" +
            "\ta.create_time as createTime,\n" +
            "\ta.content as content,\n" +
            "\tb.owner_nickname as nickName,\n" +
            "\tb.owner_portrait as avatar\n" +
            "FROM\n" +
            "\tzy_community_interaction a LEFT JOIN zy_owner b on a.user_id = b.owner_id\n" +
            "where a.community_id =#{communityId} and a.del_flag = 0 \n" +
            "order by a.create_time desc limit 4")
    List<InteractionDto> findTop4Interactions(@Param("communityId") Long communityId);

    List<InteractionDetailDto> findTop3Interactions(@Param("communityId") Long communityId);

    @Select("SELECT\n" +
            "\ta.interaction_id as interactionId,\n" +
            "\ta.content as \tcontent,\n" +
            "\tb.owner_nickname as nickname,\n" +
            "\ta.create_time as createTime,\n" +
            "\tb.owner_portrait as avatar,\n" +
            "\tc.files_url as fileUrl,\n" +
            "\t c.files_id as fileId \n"+
            "FROM\n" +
            "\t`zy_community_interaction` a LEFT JOIN zy_owner b on a.user_id = b.owner_id\n" +
            "\tLEFT JOIN zy_files c on a.interaction_id = c.parent_id\n" +
            "\twhere  a.community_id = #{communityId} and a.del_flag = 0 " +
            " order by a.create_time desc ")
    @ResultMap("interactionDetailMap")
    List<InteractionDetailDto> findPageInteractions(@Param("communityId") Long communityId);



    @Select("SELECT\n" +
            "\ta.interaction_id as interactionId,\n" +
            "\ta.create_time as createTime,\n" +
            "\ta.content as content,\n" +
            "\tb.owner_nickname as ownerNickname,\n" +
            "\tb.owner_portrait as avatar\n" +
            "FROM\n" +
            "\tzy_community_interaction a LEFT JOIN zy_owner b on a.user_id = b.owner_id\n" +
            "where a.interaction_id =#{interactionId} " )
    ZyCommunityInteractionDto selectInteractionById(@Param("interactionId") Long interactionId);


    @Select("SELECT\n" +
            "\ta.interaction_id as interactionId,\n" +
            "\ta.user_id as userId,\n" +
            "\ta.content as \tcontent,\n" +
            "\tb.owner_nickname as nickname,\n" +
            "\ta.create_time as createTime,\n" +
            "\tb.owner_portrait as avatar,\n" +
            "\tc.files_url as fileUrl,\n" +
            "\t c.files_id as fileId \n"+
            "FROM\n" +
            "\t`zy_community_interaction` a LEFT JOIN zy_owner b on a.user_id = b.owner_id\n" +
            "\tLEFT JOIN zy_files c on a.interaction_id = c.parent_id\n" +
            "\twhere  a.interaction_id = #{interactionId} and a.del_flag = 0")
    @ResultMap("interactionDetailMap")
    InteractionDetailDto findById(@Param("interactionId") Long interactionId);

    int  insertInteraction(ZyCommunityInteraction interaction);

    List<InterCationAndOwner> getInterCationAll(@Param("index") Long index, @Param("size") Long size, @Param("interCationAndOwner") InterCationAndOwner interCationAndOwner);

    List<InterCationAndOwner> getInterCationList(@Param("interactionId") String interactionId);

    String getUserName(String parentId);

    Long getCount(InterCationAndOwner interCationAndOwner);

    int deleteByUserId(@Param("id") String id,@Param("type") String type);

    List<FeilsImgs> getFeilsUrl(String id);

    List<String> getRoomParentIds(List<String> parentId);

    int updCommentId(List<String> id);

    int delCom(String comId);

    int delCom2(String interId);

    int delInter(String interId);
}

