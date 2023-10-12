package com.example.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.InterCationAndOwner;
import com.example.community.entity.ZyComment;
import com.example.community.mini.ZyCommentDto;
import com.example.community.mini.dto.dto.CommentRootDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 评论表(ZyComment)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyCommentDao extends BaseMapper<ZyComment> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<ZyComment> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<ZyComment> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<ZyComment> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
    int insertOrUpdateBatch(@Param("entities") List<ZyComment> entities);

    @Select("<script> select wc.comment_id, wc.user_id, wc.update_by, wc.create_time, wc.update_time, wc.content, wc.parent_id,\n" +
            " wc.del_flag, wc.interaction_id,wo.owner_real_name ownerName,wo.owner_portrait ownerPortrait,\n" +
            " (SELECT owner_real_name FROM zy_owner wo1 WHERE wo1.owner_id =\n" +
            " (SELECT wc1.user_id FROM zy_comment wc1 WHERE wc1.comment_id = wc.parent_id ) ) passiveOwnerName\n" +
            " from zy_comment wc left join zy_owner wo on wc.user_id = wo.owner_id " +
            "<where>" +
            " <if test=\"userId != null \"> and wc.user_id = #{userId}</if>\n" +
            " <if test=\"content != null  and content != ''\"> and wc.content = #{content}</if>\n" +
            " <if test=\"parentId == 1 \"> and wc.parent_id = -1</if>\n" +
            " <if test=\"parentId == 2 \"> and wc.parent_id != -1</if>\n" +
            " <if test=\"interactionId != null \"> and wc.interaction_id = #{interactionId}</if>" +
            " and wc.del_flag = 0 " +
            "</where>"+
            " order by wc.create_time asc" +
            "</script>")
    List<ZyCommentDto> selectZyCommentByInteractionId(ZyCommentDto zyComment);


    @Select("SELECT\n" +
            "\t\n" +
            "\ta.comment_id as commentId,\n" +
            "\ta.parent_id as parentId,\n" +
            "\t\ta.root_id as rootId,\n" +
            "\ta.create_time as createTime,\n" +
            "\ta.content as comment,\n" +
            "\ta.user_id as createUserId,\n" +
            "\tc.owner_portrait as createAvatar,\n" +
            "\tc.owner_nickname as createNickname,\n" +
            "\n" +
            "\tb.user_id as parentUserId,\n" +
            "\td.owner_nickname as parentUserNickname,\n" +
            "\td.owner_portrait as parentAvatar\n" +
            "FROM\n" +
            "\tzy_comment a\n" +
            "\tLEFT JOIN zy_comment b ON a.parent_id = b.comment_id\n" +
            "\tLEFT JOIN zy_owner c on a.user_id = c.owner_id\n" +
            "\tLEFT JOIN zy_owner d on b.user_id = d.owner_id\n" +
            "where a.interaction_id = #{interactionId} and a.del_flag = 0\n" +
            "\n" +
            "ORDER BY a.create_time asc")
    List<CommentRootDto> findAllComment(@Param("interactionId") Long interactionId);


    List<InterCationAndOwner> getParentIds(@Param("id") String id);

    int updDelFlag(@Param("id") String id);


}

