package com.example.community.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.entity.SysDept;
import com.example.community.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import com.example.community.entity.SysPost;

/**
 * 岗位信息表(SysPost)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
public interface SysPostDao extends BaseMapper<SysPost> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<SysPost> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<SysPost> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<SysPost> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<SysPost> entities);

    /**
     * 根据条件分页查询岗位
     *
     *  role 岗位
     * @return 岗位
     */
    List<SysPost> selectPost(@Param("index") Long index, @Param("size") Long size , @Param("sysPost") SysPost sysPost);

    long count(SysPost sysPost);


    Integer insertPost(SysPost sysPost);

    Integer getPostByCodeOrName(@Param("postCode") String postCode, @Param("postName") String postName);

    List<SysPost> checkName(String postName, String postId , String postCode);

    Integer updateDept(SysPost sysPost);

    Integer selCode(SysPost sysPost);

    Integer selNamePost(SysPost sysPost);

    int deletes(@Param("ids") int[] ids);

    int getUserByPost(Integer postId);

    /**
     * 删除岗位信息
     *
     * @param postId 岗位ID
     * @return 结果
     */
    public int deletePostById(Long postId);

    Integer deletePostIds(Long[] houseIds);

    List<SysPost> getPostList(List<String> list);
}

