package com.example.community.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.community.dto.LogDto;
import com.example.community.entity.SysDictData;
import com.example.community.entity.SysJobLog;
import com.example.community.entity.SysLogininfor;
import com.example.community.service.SysLogininforService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 系统访问记录(SysLogininfor)表控制层
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Api(tags = "系统访问记录")
@RestController
@RequestMapping("sysLogininfor")
@CrossOrigin
public class SysLogininforController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysLogininforService logininforService;

    // @PreAuthorize("@ss.hasPermi('monitor:logininfor:list')")
    @GetMapping("/list")
    public HashMap<String, Object> list(LogDto logDto, Page<LogDto> page) {
        HashMap<String, Object> map = new HashMap<>();
        System.err.println(logDto);

        List<SysLogininfor> list = logininforService.selectLogininforList(logDto, (page.getCurrent() - 1) * page.getSize(), page.getSize());
        int total = logininforService.selectLogininforList(logDto, 0, 0).size();

        map.put("data", list);
        map.put("total", total);

        return map;
    }

    @GetMapping("getStatus")
    public HashMap getStatus(){
        HashMap<String, Object> map = new HashMap<>();

        List<SysDictData> status = logininforService.getStatus();

        map.put("data",status);

        return map;
    }

    // @Log(title = "登录日志", businessType = BusinessType.EXPORT)
    // @PreAuthorize("@ss.hasPermi('monitor:logininfor:export')")
    // @PostMapping("/export")
    // public void export(HttpServletResponse response, SysLogininfor logininfor) {
    //     List<SysLogininfor> list = logininforService.selectLogininforList(logininfor);
    //     ExcelUtil<SysLogininfor> util = new ExcelUtil<SysLogininfor>(SysLogininfor.class);
    //     util.exportExcel(response, list, "登录日志");
    // }

    // @PreAuthorize("@ss.hasPermi('monitor:logininfor:remove')")
    // @Log(title = "登录日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{infoIds}")
    public int remove(@PathVariable Long[] infoIds) {
        int i = logininforService.deleteLogininforByIds(infoIds);
        return i;
    }

    // @PreAuthorize("@ss.hasPermi('monitor:logininfor:remove')")
    // @Log(title = "登录日志", businessType = BusinessType.CLEAN)
    @DeleteMapping("/clean")
    public String clean() {
        logininforService.cleanLogininfor();
        return "11";
    }
    //
    // @PreAuthorize("@ss.hasPermi('monitor:logininfor:unlock')")
    // @Log(title = "账户解锁", businessType = BusinessType.OTHER)
    // @GetMapping("/unlock/{userName}")
    // public AjaxResult unlock(@PathVariable("userName") String userName)
    // {
    //     passwordService.clearLoginRecordCache(userName);
    //     return success();
    // }
    @GetMapping("getLoginUser")
    public R getLoginUser() {
        return success(this.logininforService.getLoginUser());
    }

}

