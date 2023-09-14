package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.ZyFilesDao;
import com.example.community.entity.ZyFiles;
import com.example.community.service.ZyFilesService;
import org.springframework.stereotype.Service;

/**
 * 文件管理(ZyFiles)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
@Service("zyFilesService")
public class ZyFilesServiceImpl extends ServiceImpl<ZyFilesDao, ZyFiles> implements ZyFilesService {

}

