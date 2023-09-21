package com.example.community.controller;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.community.entity.DeriveList;
import com.example.community.entity.SysDictType;
import com.example.community.entity.SysMenu;
import com.example.community.entity.SysRole;
import com.example.community.service.SysDictDataService;
import com.example.community.service.SysDictTypeService;
import com.example.community.service.SysRoleService;
import com.example.community.utils.easyexcel.StyleUtils;
import com.example.community.utils.easyexcel.TextWriteObject;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Excel表格导出
 */
@RestController
@RequestMapping("excel")
@CrossOrigin
public class ExcelController {

    @Resource
    private SysRoleService sysRoleService;

    @Resource
    private SysDictTypeService sysDictTypeService;
    /**
     * 导出数据
     * @param fileName
     * @param list
     */
    public static void simpleWrite(String fileName,List<SysRole> list){
        //"E:\\lx.xls"
        List<SysRole> dataList = new ArrayList<>();

        for (SysRole sysRole : list) {
            dataList.add(sysRole);
        }
        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());
        EasyExcel.write(fileName, SysRole.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }

    //Dictexcel
    public static void Dictexcel(String fileName,List<SysDictType> Dictlist){
        //"E:\\lx.xls"
        List<SysDictType> dataList = new ArrayList<>();

        for (SysDictType sysDictType : Dictlist) {
            dataList.add(sysDictType);
        }
        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());
        EasyExcel.write(fileName, SysDictType.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }


    /**
     * 表格导出
     * @param lists
     * @return
     */
    @PostMapping("list")
    public Map<String, Object> menuList(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        //根据需要导出的角色id查询对应信息
        if (lists.size()==0){
            lists=null;
        }
        System.err.println(lists);

        List<SysRole> deriveList = sysRoleService.getDeriveList(lists);
        String path = "D:\\lx.xls";
        simpleWrite(path,deriveList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

    /**
     * 表格导出
     * @param lists
     * @return
     */
    @PostMapping("DictList")
    public Map<String, Object> DictList(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        //根据需要导出的角色id查询对应信息
        if (lists.size()==0){
            lists=null;
        }
        System.err.println(lists);

        List<SysDictType> deriveList = sysDictTypeService.getDeriveList(lists);

        String path = "F:\\lx.xls";
        Dictexcel(path,deriveList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }
}
