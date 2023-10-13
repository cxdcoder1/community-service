package com.example.community.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.community.dto.*;
import com.example.community.entity.ZyFiles;
import com.example.community.mini.dto.SuggestAndOwnerDto;
import org.apache.ibatis.annotations.Param;
import com.example.community.entity.ZyComplaintSuggest;

/**
 * 投诉建议 (ZyComplaintSuggest)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyComplaintSuggestDao extends BaseMapper<ZyComplaintSuggest> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ZyComplaintSuggest> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ZyComplaintSuggest> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ZyComplaintSuggest> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ZyComplaintSuggest> entities);

    long count(@Param("zyComplaintSuggestDto")ZyComplaintSuggestDto zyComplaintSuggestDto,@Param("id") long id);


    List<ZyComplaintSuggestDto> selectzyComplaintSuggestDto(@Param("index") Long index, @Param("size") Long size , @Param("zyComplaintSuggestDto") ZyComplaintSuggestDto zyComplaintSuggestDto, @Param("id")long id);

    List<ExSuggest> getExSuggestList(List<String> list);

    Integer updateRemark(String remark,long id);

    Integer insertBySuggest(SuggestAndOwnerDto suggestAndOwnerDto);

    Integer insertFiles(List<ZyFiles> files);

    List<SuggestAndOwnerDto> getSuggestions(@Param("communityId") String communityId,@Param("userId") String userId);
}

