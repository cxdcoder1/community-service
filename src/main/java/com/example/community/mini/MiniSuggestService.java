package com.example.community.mini;

import com.example.community.dao.ZyComplaintSuggestDao;
import com.example.community.entity.ZyComplaintSuggest;
import com.example.community.entity.ZyFiles;
import com.example.community.mini.dto.SuggestAndOwnerDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MiniSuggestService {

    @Resource
    private ZyComplaintSuggestDao zyComplaintSuggestDao;

    /**
     * 保存投诉信息
     * @param suggestAndOwnerDto
     * @return
     */
    public String saveSuggest(SuggestAndOwnerDto suggestAndOwnerDto, List<ZyFiles> list){
        //插入投诉信息
        String s = zyComplaintSuggestDao.insertBySuggest(suggestAndOwnerDto) + "";

        //批量插入files
        if (list.size()!=0){
            Integer integer = zyComplaintSuggestDao.insertFiles(list);
            if (integer<=0){
                s="-1";
            }
        }
        return s;
    }

    /**
     * 获取投诉列表
     * @param communityId
     * @param userId
     * @return
     */
    public List<ZyComplaintSuggest> getSuggestions(String communityId, String userId){

        return zyComplaintSuggestDao.getSuggestions(communityId,userId);
    }


}
