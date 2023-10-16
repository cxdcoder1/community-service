package com.example.community.service.impl;

import com.example.community.entity.SystemHardwareInfo;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl {

    public SystemHardwareInfo getSystemHardwareInfo() {
        SystemHardwareInfo hardwareInfo = null;
        try {
            hardwareInfo = new SystemHardwareInfo();
            hardwareInfo.copyTo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hardwareInfo;
    }

}
