package com.example.community.mini;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.community.dao.ZyOwnerDao;
import com.example.community.entity.ZyOwner;
import com.example.community.mini.dto.OwnerRecordDto;
import com.example.community.mini.dto.RepairDto;
import com.example.community.mini.dto.SuggestAndOwnerDto;
import com.example.community.service.ZyRepairService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mini/community/repairs")
public class MiniRepairsList {

    @Resource
    private ZyOwnerDao zyOwnerMapper;

    @Resource
    private ZyRepairService zyRepairService;

    /**
     * 获取报修列表
     * @param communityId
     * @param openId
     * @return
     */
    @GetMapping("/getList")
    public Map<String, Object> findCurrentUserHasBindInfo(String communityId ,String openId) {
        HashMap<String, Object> result = new HashMap<>();

        //未处理、已派遣、已完成、已取消 四个状态的集合
        List<RepairDto> applyList = new ArrayList();
        List<RepairDto> bindList = new ArrayList();
        List<RepairDto> rejectList = new ArrayList();
        List<RepairDto> cancelList = new ArrayList();

        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", openId));
        List<RepairDto> repairs = zyRepairService.getRepairByK(communityId, zyOwner.getOwnerId() + "");
        for (RepairDto repair : repairs) {
            if (repair.getRepairState().equals("0")){
                applyList.add(repair);
            }else if (repair.getRepairState().equals("1")){
                bindList.add(repair);
            }else if (repair.getRepairState().equals("2")){
                rejectList.add(repair);
            }else if (repair.getRepairState().equals("3")){
                cancelList.add(repair);
            }
        }
        result.put("applyList",applyList);
        result.put("bindList",bindList);
        result.put("rejectList",rejectList);
        result.put("cancelList",cancelList);
        result.put("status",200);
        return result;
    }

    /**
     * 删除报修表
     * @param repairId
     * @return
     */
    @GetMapping("/deleteRepair/{repairId}/{openId}")
    public Map<String, Object> deleteRepair(@PathVariable("repairId") String repairId ,@PathVariable("openId") String openId) {
        HashMap<String, Object> result = new HashMap<>();
        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", openId));
        Integer integer = zyRepairService.deleteRepair(repairId,zyOwner.getOwnerRealName());
        if (integer.equals(1)){
            result.put("status",200);
            result.put("msg","删除成功");
            return result;
        }
        result.put("status",201);
        result.put("msg","删除失败");
        return  result;
    }

    /**
     * 完成订单
     * @param repairId
     * @return
     */
    @GetMapping("/complete/{repairId}/{openId}")
    public Map<String, Object> completeRepair(@PathVariable("repairId") String repairId,@PathVariable("openId") String openId) {
        HashMap<String, Object> result = new HashMap<>();
        ZyOwner zyOwner = zyOwnerMapper.selectOne(new QueryWrapper<ZyOwner>().eq("owner_open_id", openId));
        Integer integer = zyRepairService.completeRepair(repairId,zyOwner.getOwnerRealName());
        if (integer.equals(1)){
            result.put("status",200);
            result.put("msg","修改成功");
            return result;
        }
        result.put("status",201);
        result.put("msg","修改失败");
        return  result;
    }

    /**
     * 重新报修
     * @param repairDto
     * @return
     */
    @GetMapping("/reRepair")
    public Map<String, Object> reRepair(@RequestBody RepairDto repairDto) {
        HashMap<String, Object> result = new HashMap<>();
        Integer integer = zyRepairService.reRepair(repairDto);
        if (integer.equals(1)){
            result.put("status",200);
            result.put("msg","重新报修成功");
            return result;
        }
        result.put("status",201);
        result.put("msg","重新报修失败");
        return  result;
    }
}
