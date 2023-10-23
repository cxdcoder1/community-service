package com.example.community.controller;

import com.example.community.entity.SystemHardwareInfo;
import com.example.community.service.impl.SystemServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@Controller
@RequestMapping("system")
@CrossOrigin
public class SystemController {

    @Resource
    private SystemServiceImpl systemService;

    @GetMapping("hardwareInfo")
    public SystemHardwareInfo getHardwareInfo() {
        return systemService.getSystemHardwareInfo();
    }

}
