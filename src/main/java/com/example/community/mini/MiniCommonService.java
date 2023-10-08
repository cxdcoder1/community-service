package com.example.community.mini;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.community.dao.SysDictDataDao;
import com.example.community.dao.ZyOwnerDao;
import com.example.community.dao.ZyOwnerRoomDao;
import com.example.community.entity.SysDictData;
import com.example.community.entity.ZyOwnerRoom;
import com.example.community.mini.my.basic.MiniContextUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MiniCommonService {
    // @Resource
    // private MinioComponent minioComponent;

    @Resource
    private SysDictDataDao sysDictDataMapper;
    @Resource
    private ZyOwnerRoomDao zyOwnerRoomMapper;
    @Resource
    private ZyOwnerDao zyOwnerMapper;

    // /**
    //  * 上传文件
    //  *
    //  * @param file 文件
    //  * @return 上传后访问地址
    //  */
    // public ZyResult<String> uploadFile(MultipartFile file) {
    //     return minioComponent.uploadByFile(file);
    // }

    /**
     * 根据类型选择字典值
     *
     * @param type 类型
     * @return 字典值集合
     */
    public ZyResult<List<DictDto>> selectDictByType(String type) {
        List<DictDto> collect = sysDictDataMapper
                .selectList(new QueryWrapper<SysDictData>().select("dict_value", "dict_label").eq("dict_type", type))
                .stream()
                .map(dict -> {
                    DictDto dto = new DictDto();
                    dto.setLabel(dict.getDictLabel());
                    dto.setValue(dict.getDictValue());
                    return dto;
                }).collect(Collectors.toList());
        return ZyResult.data(collect);
    }

    /**
     * 查询当前用户在该小区下是否有已绑定的房子
     * @param communityId 小区Id
     * @return 是否存在
     */
    public ZyResult<Boolean> findCurrentUserHasBindInfo(Long communityId) {
        Integer integer = zyOwnerRoomMapper.selectCount(new QueryWrapper<ZyOwnerRoom>()
                .eq("room_status", "Binding")
                .eq("owner_id", zyOwnerMapper.findOwnerIdByOpenId(MiniContextUtils.getOpenId()))
                .eq("community_id", communityId)
        );
        if (integer != null && integer > 0) {
            return ZyResult.data(true);
        } else {
            return ZyResult.data(false);
        }
    }

}
