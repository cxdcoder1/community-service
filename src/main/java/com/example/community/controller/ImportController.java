package com.example.community.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.example.community.config.CommunityExcelListener;
import com.example.community.config.CustomAnnotation;
import com.example.community.dto.UserAndDeptImport;
import com.example.community.entity.ZyCommunity;
import com.example.community.listener.DemoDataListener;
import com.example.community.log.BusinessType;
import com.example.community.log.Log;
import com.example.community.service.ZyCommunityService;
import com.example.community.utils.easyexcel.StyleUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.io.IOException;
import java.util.*;

@Api(tags = "Excel表格导出")
@RestController
@RequestMapping("ExcelImport")
@CrossOrigin
public class ImportController {


    @Resource
    private ZyCommunityService zyCommunityService;

//
//    @RequestMapping("importCommunity")
//    public HashMap<String, Object> importimportCommunityRoom(@RequestParam("file") MultipartFile multiFile) {
//        HashMap<String, Object> map = new HashMap<>();
//        List<ZyCommunity> dataList = new ArrayList<>();
//        String fileName = multiFile.getOriginalFilename();
//        String prefix = fileName.substring(fileName.lastIndexOf("."));
//        System.err.println(multiFile.toString());
//        File file = null;
//        try {
//            file = File.createTempFile(fileName, prefix);
//            multiFile.transferTo(file);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//            EasyExcel.read(file, ZyCommunity.class, new UserExcelListener(dataList)).sheet(0)//读取第一个sheet
//                    .headRowNumber(1) //跳过前三行表头内容，假如是简单表头则这句可省略
//                    .doRead();
//// 操作完上面的文件 需要删除在根目录下生成的临时文件
//            File f = new File(file.toURI());
//            f.delete();
//        }
////必填字段
//        boolean bool = dataList.stream().anyMatch(m -> null == m.getCommunityName() || null == m.getCommunityDetailedAddress());
//        if (bool) {
//            map.put("status", 0);
//            map.put("msg", "导入的数据中有必填字段未填写，导入失败");
//            return map;
//        }
//
////电话号码正则
//        int n = 2;
//        for (ZyCommunity roomDto : dataList) {
//            roomDto.setCommunityCode("COMMUNITY_"+System.currentTimeMillis());
//            n++;
//        }
////过滤重复字段
//        List<String> names = dataList.stream().map(ZyCommunity::getCommunityName).collect(Collectors.toList());
////distinct()过滤重复的姓名 count()计算数量
//        long count = names.stream().distinct().count();
//        if (names.size() == count) {
////上传的文件中没有重复字段
//// 数组方式
//            ZyCommunity[] arr = new ZyCommunity[dataList.size()];
//            System.err.println(arr);
//            int i = 0;
//            for (ZyCommunity dl : dataList) {
//                arr[i++] = dl;
//            }
//            try {
//                map = zyCommunityService.insertCommunityFromExcel(arr);
//            } catch (Exception e) {
//                map.put("msg", e.getMessage());
//                map.put("status", 0);
//                return map;
//            }
//            return map;
//        } else {
////上传的文件中有重复字段
//            map.put("msg", "上传的文件中有重复字段，上传失败");
//            map.put("status", 0);
//            return map;
//        }
//    }



    public static void simpleWriteCommunity(String fileName,List<ZyCommunity> Communitylist){
        //"E:\\lx.xls"
        List<ZyCommunity> dataList = new ArrayList<>();

        for (ZyCommunity zyCommunity : Communitylist) {
            dataList.add(zyCommunity);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, ZyCommunity.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }

    /**
     * 生成随机文件名 并返回固定路径
     * @return
     */
    static String getPath() {
        UUID randomUUID = UUID.randomUUID();
        String s = randomUUID.toString().replaceAll("-", "");
        return "D:\\"+s+".xls";
    }

    /**
     * 用户导入模板
     * @return
     */
    @PostMapping("template")
    public Map<String, Object> template() {
        Map<String, Object> result = new HashMap<>();

        List<ZyCommunity> cummList = new ArrayList<>();
//        System.err.println(userList);
        String path = getPath();
        simpleWriteCommunity(path,cummList);
        result.put("msg","模板导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

    /**
     * 导入用户
     */
    @PostMapping("importCommunity")
    @ApiOperation(value = "用户导入接口",notes = "用户导入接口的说明")
    public Map<String,Object> simpleRead(@RequestParam("file") MultipartFile file) {
        Map<String,Object> result = new HashMap<>();
//        String fileName = "F:\\rdtext.xls";
        List<ZyCommunity> dataList = new ArrayList<>();
        //每次会读取100条数据然后返回过来，直接调用使用数据就行
        try {
            EasyExcel.read(file.getInputStream(), ZyCommunity.class, new CommunityExcelListener(dataList))
                    .sheet(0)//读取第一个sheet
                    //                .headRowNumber(3) //跳过前三行表头内容，假如是简单表头则这句可省略
                    .doRead();
        } catch (IOException e) {
            //文件类型不对
            e.printStackTrace();
        }

//        for (UserAndDeptImport dl : dataList) {
//            System.err.println(JSON.toJSONString(dl));
//            System.out.println("*****************");
//            System.err.println(dl);
//        }
        //验空
        if (dataList.size()==0){
            result.put("status",201);
            result.put("msg","请导入有数据的xls文件");
            return result;
        }
        //验重
//        Map<String, Object> m1 = sysUserService.checkUserName(dataList);
//        if (m1.get("status").equals("false")){
//            result.put("status",201);
//            result.put("msg",m1.get("msg"));
//            return result;
//        }
//        Map<String, Object> m2 = sysUserService.checkPhone(dataList);
//        if (m2.get("status").equals("false")){
//            result.put("status",201);
//            result.put("msg",m2.get("msg"));
//            return result;
//        }
        List<ZyCommunity> zyCommunities1 =new ArrayList<>();
        List<ZyCommunity> zyCommunities =new ArrayList<>();
        for(ZyCommunity data:dataList) {
            zyCommunities1 = zyCommunityService.selCommunityCity(data);
            zyCommunities = zyCommunityService.selCommunityDerive(data);
        }

        System.out.println(zyCommunities1);
        System.out.println(zyCommunities);
        //批量插入
        if(zyCommunities1.size() == 0 || zyCommunities.size() == 0 ) {
            try {
                System.err.println(dataList.toString());
                zyCommunityService.insertBatch(dataList);
                result.put("status",200);
                result.put("msg","导入成功");
                return result;
            } catch (Exception e) {
                result.put("status", 201);
                result.put("msg", "导入失败，您的导入数据有误");
                return result;
            }
        }
        result.put("status", 201);
        result.put("msg", "导入失败，有重复字段");
        return result;
    }

//    @PostMapping("importCommunity")
//    private void importCommunity(MultipartFile file) throws IOException {
//        System.err.println(file);
//        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
//        List<ZyCommunity> zyCommunities = reader.readAll(ZyCommunity.class);
//        zyCommunityService.saveBatch(zyCommunities);
//    }


}
