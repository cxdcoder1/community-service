package com.example.community.mini.my.handle;

import com.example.community.dto.RepairPostDto;
import com.example.community.entity.ValueLabel;
import com.example.community.mini.ZyResult;
import com.example.community.service.ZyRepairService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/mini/community")
public class MiniHandleController {
    @Resource
    private ZyRepairService zyRepairService;

    @GetMapping("/repair/house/{communityId}/{ownerId}")
    public ZyResult repairHouse(@PathVariable("communityId")Long communityId, @PathVariable("ownerId")Long ownerId){
        List<ValueLabel> repairHouse = zyRepairService.repairHouse(communityId, ownerId);

        return ZyResult.data(repairHouse);
    }

    @PostMapping("/repair/post")
    public ZyResult repairPost(@RequestBody RepairPostDto repairPostDto){

        return zyRepairService.repairPost(repairPostDto);

    }


}
