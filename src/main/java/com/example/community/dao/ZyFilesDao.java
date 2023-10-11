package com.example.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.entity.ZyFiles;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 文件管理(ZyFiles)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyFilesDao extends BaseMapper<ZyFiles> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<ZyFiles> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<ZyFiles> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<ZyFiles> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
    /**根据ID数组查询列表*/
    @Select("<script>" +
            "SELECT " +
            "d.files_id,d.files_url,d.create_time " +
            "FROM zy_files d " +
            "<where>" +
            "d.parent_id = #{parentId} " +
            "</where>" +
            "</script>")
    public List<ZyFiles> selectWyglFilesListParentId(Long parentId);

    int insertFilesBatch(@Param("zyFiles") List<ZyFiles> zyFiles);

}

