package com.example.community.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.example.community.entity.SysDictData;
import com.example.community.entity.SysDictType;
import com.example.community.entity.SysPost;
import com.example.community.entity.SysRole;
import com.example.community.service.SysDictDataService;
import com.example.community.service.SysDictTypeService;
import com.example.community.service.SysPostService;
import com.example.community.service.SysRoleService;
import com.example.community.utils.easyexcel.StyleUtils;
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
    private SysDictDataService sysDictDataService;
    @Resource
    private SysDictTypeService sysDictTypeService;
    @Resource
    private SysPostService sysPostService;

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

    /**
     * 岗位
     * @param fileName
     * @param list
     */
    public static void simpleWrites(String fileName,List<SysPost> list){
        //"E:\\lx.xls"
        List<SysPost> dataList = new ArrayList<>();

        for (SysPost sysPost : list) {
            dataList.add(sysPost);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, SysPost.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }

    public static void simpleWrite1(String fileName,List<SysDictData> list){
        //"E:\\lx.xls"
        List<SysDictData> dataList = new ArrayList<>();

        for (SysDictData sysDictData : list) {
            dataList.add(sysDictData);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, SysDictData.class)
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

    @PostMapping("list2")
    public Map<String, Object> menuList1(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        //根据需要导出的角色id查询对应信息
        if (lists.size()==0){
            lists=null;
        }
        System.err.println(lists);

        List<SysDictData> deriveList = sysDictDataService.getDeriveList(lists);
        String path = "D:\\lx.xls";
        simpleWrite1(path,deriveList);
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

    @PostMapping("postListS")
    public Map<String, Object> postList(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        if (lists.size()==0){
            lists=null;
        }
        List<SysPost> postList = sysPostService.getPostList(lists);
        String path="D:\\lx.xls";
        simpleWrites(path,postList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }
}
