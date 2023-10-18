package com.example.community.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.example.community.config.CustomAnnotation;
import com.example.community.dao.*;
import com.example.community.dto.*;
import com.example.community.entity.*;
import com.example.community.listener.DemoDataListener;
import com.example.community.log.BusinessType;
import com.example.community.log.Log;
import com.example.community.service.*;
import com.example.community.utils.easyexcel.StyleUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * Excel表格导出
 */
@Api(tags = "Excel表格导入导出")
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
    private SysUserService sysUserService;
    @Resource
    private SysPostService sysPostService;
    @Resource
    private ZyUnitService zyUnitService;
    @Resource
    private ZyBuildingService zyBuildingService;
    @Resource
    private ZyCommunityDao zyCommunityDao;
    @Resource
    private ZyRoomDao zyRoomDao;
    @Resource
    private SysLogininforDao sysLogininforDao;
    @Resource
    private SysOperLogDao sysOperLogDao;
    @Resource
    private ZyOwnerDao zyOwnerDao;
    @Resource
    private ZyVisitorDao zyVisitorDao;
    @Resource
    private ZyComplaintSuggestDao zyComplaintSuggestDao;
    @Resource
    private ZyRepairDao zyRepairDao;
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
     * 楼栋表
     * @param fileName
     * @param list
     */
    public static void buildingLists(String fileName,List<ZyBuilding> list){
        //"E:\\lx.xls"
        List<ZyBuilding> dataList = new ArrayList<>();

        for (ZyBuilding zyBuilding : list) {
            dataList.add(zyBuilding);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, ZyBuilding.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }
    /**
     * 房屋表
     * @param fileName
     * @param list
     */
    public static void roomLists(String fileName,List<ZyRoom> list){
        //"E:\\lx.xls"
        List<ZyRoom> dataList = new ArrayList<>();

        for (ZyRoom zyRoom : list) {
            dataList.add(zyRoom);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, ZyRoom.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }

    /**
     * 登录日志表
     * @param fileName
     * @param list
     */
    public static void loginList(String fileName,List<SysLogininfor> list){
        //"E:\\lx.xls"
        List<SysLogininfor> dataList = new ArrayList<>();

        for (SysLogininfor sysLogininfor : list) {
            dataList.add(sysLogininfor);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, SysLogininfor.class)
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

    /**
     * 导出用户数据
     * @param fileName
     * @param list
     */
    public static void simpleWriteUser(String fileName,List<UserAndDeptImport> list){
        //"E:\\lx.xls"
        List<UserAndDeptImport> dataList = new ArrayList<>();

        for (UserAndDeptImport userAndDeptImport : list) {
            dataList.add(userAndDeptImport);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, UserAndDeptImport.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }

    /**
     * 导出单元数据
     * @param fileName
     * @param list
     */
    public static void outUnit(String fileName,List<ZyUnit> list){
        //"E:\\lx.xls"
        List<ZyUnit> dataList = new ArrayList<>();

        for (ZyUnit unit : list) {
            dataList.add(unit);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, ZyUnit.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }

    /**
     * 导入用户
     */
    @CustomAnnotation("system:user:import")
    @PostMapping("into")
    @ApiOperation(value = "用户导入接口",notes = "用户导入接口的说明")
    public Map<String,Object> simpleRead(@RequestParam("file") MultipartFile file) {
        Map<String,Object> result = new HashMap<>();
//        String fileName = "F:\\rdtext.xls";
        List<UserAndDeptImport> dataList = new ArrayList<>();
        //每次会读取100条数据然后返回过来，直接调用使用数据就行
        try {
            EasyExcel.read(file.getInputStream(), UserAndDeptImport.class, new DemoDataListener(dataList))
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
        Map<String, Object> m1 = sysUserService.checkUserName(dataList);
        if (m1.get("status").equals("false")){
            result.put("status",201);
            result.put("msg",m1.get("msg"));
            return result;
        }
        Map<String, Object> m2 = sysUserService.checkPhone(dataList);
        if (m2.get("status").equals("false")){
            result.put("status",201);
            result.put("msg",m2.get("msg"));
            return result;
        }
        //批量插入
        try {
            sysUserService.batchInsert(dataList);
        } catch (Exception e) {
            result.put("status",201);
            result.put("msg","导入失败，请检查字段是否填入完整");
            return result;
        }
        result.put("status",200);
        result.put("msg","导入成功");
        return result;
    }

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
    public static void simpleOper(String fileName,List<SysOperLog> list){
        //"E:\\lx.xls"
        List<SysOperLog> dataList = new ArrayList<>();

        for (SysOperLog sysOperLog : list) {
            dataList.add(sysOperLog);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, SysOperLog.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }

    //Dictexcel
    public static void Dictexcel(String fileName,List<SysDictType> userList){
        //"E:\\lx.xls"
        List<SysDictType> dataList = new ArrayList<>();

        for (SysDictType sysDictType : userList) {
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

    @Log(title = "小区管理", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "小区导出接口",notes = "小区导出接口的说明")
    @PostMapping("Communitylist")
    public Map<String, Object> Communitylist(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();


        if (lists.size() <= 0 || lists == null ){
            lists=null;
        }

        System.err.println(lists);

        List<ZyCommunity> CommunityList = zyCommunityDao.getCommunityDeriveList(lists);
        String path = getPath();
        simpleWriteCommunity(path,CommunityList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

    @CustomAnnotation("system:role:export")
    @Log(title = "菜单管理", businessType = BusinessType.EXPORT)
    @PostMapping("list")
    public Map<String, Object> menuList(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        //根据需要导出的角色id查询对应信息
        if (lists.size()==0){
            lists=null;
        }
        System.err.println(lists);

        List<SysRole> deriveList = sysRoleService.getDeriveList(lists);

        String path = getPath();
        simpleWrite(path,deriveList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }



    /**
     * 用户表格导出
     * @param lists
     * @return
     */
    @CustomAnnotation("system:user:export")
    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "用户导出接口",notes = "用户导出接口的说明")
    @PostMapping("userList")
    public Map<String, Object> UserList(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        //根据需要导出的角色id查询对应信息
        if (lists.size()==0){
            lists=null;
        }

        List<UserAndDeptImport> userList = sysUserService.getUserList(lists);
//        System.err.println(userList);
        String path = getPath();
        simpleWriteUser(path,userList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

    /**
     * 单元导出
     * @param lists
     * @return
     */
    @Log(title = "单元管理", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "单元导出接口",notes = "单元导出接口的说明")
    @PostMapping("unitList")
    public Map<String, Object> UnitList(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        //根据需要导出的角色id查询对应信息
        if (lists.size()==0){
            lists=null;
        }

        List<ZyUnit> units = zyUnitService.getUnitsById(lists);

        String path = getPath();
        outUnit(path,units);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

    /**
     * 用户导入模板
     * @return
     */

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @ApiOperation(value = "用户导入接口",notes = "用户导入接口的说明")
    @PostMapping("template")
    public Map<String, Object> template() {
        Map<String, Object> result = new HashMap<>();


        List<UserAndDeptImport> userList = new ArrayList<>();
//        System.err.println(userList);
        String path = getPath();
        simpleWriteUser(path,userList);
        result.put("msg","模板导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }



    @CustomAnnotation("system:config:export")
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
     * 角色表格导出
     * @param lists
     * @return
     */
    @CustomAnnotation("system:dict:export")
    @Log(title = "字典管理", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "字典管理导出接口",notes = "字典管理导出接口的说明")
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

    @CustomAnnotation("system:post:export")
    @Log(title = "岗位管理", businessType = BusinessType.EXPORT)
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

    @Log(title = "楼栋管理", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "楼栋导出接口",notes = "楼栋导出接口的说明")
    @PostMapping("buildingList")
    public Map<String, Object> buildingList(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        if (lists.size()==0){
            lists=null;
        }
        List<ZyBuilding> buildingList = zyBuildingService.getBuildingList(lists);
        String path="D:\\lx.xls";
        buildingLists(path,buildingList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

    @Log(title = "房屋管理", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "房屋导出接口",notes = "房屋导出接口的说明")
    @PostMapping("roomList")
    public Map<String, Object> roomList(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        if (lists.size()==0){
            lists=null;
        }
        List<ZyRoom> roomListExcel = zyRoomDao.getRoomListExcel(lists);
        String path="D:\\lx.xls";
        roomLists(path,roomListExcel);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

    @CustomAnnotation("monitor:logininfor:export")
    @Log(title = "登录日志", businessType = BusinessType.EXPORT)
    @PostMapping("loginList")
    public Map<String, Object> loginList(@RequestBody List<String> lists) {
        Map<String, Object> result = new HashMap<>();
        if (lists.size()==0){
            lists=null;
        }
        List<SysLogininfor> loginListExcel = sysLogininforDao.getLoginListExcel(lists);
        String path="D:\\lx.xls";
        loginList(path,loginListExcel);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }


    @CustomAnnotation("monitor:operlog:export")
    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @PostMapping("operlist")
    public Map<String, Object> operlist(@RequestBody List<String> list) {
        Map<String, Object> result = new HashMap<>();
        if (list.size()==0){
            list=null;
        }
        List<SysOperLog> operlist = sysOperLogDao.getOperLogList(list);
        String path="D:\\lx.xls";
        simpleOper(path,operlist);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

    /**
     * 业主信息
     * @param fileName
     * @param list
     */
    public static void ownerList(String fileName,List<ExZyOwnerRoom> list){
        //"E:\\lx.xls"
        List<ExZyOwnerRoom> dataList = new ArrayList<>();

        for (ExZyOwnerRoom zyOwnerRoomDto : list) {
            dataList.add(zyOwnerRoomDto);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, ExZyOwnerRoom.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }

    @Log(title = "业主信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("ownerList")
    public Map<String, Object> getOwnerList(@RequestBody List<String> list) {
        Map<String, Object> result = new HashMap<>();
        if (list.size()==0){
            list=null;
        }
        List<ExZyOwnerRoom> zyOwnerRoomDtos = zyOwnerDao.getzyOwnerRoomDtoList(list);
        String path="D:\\lx.xls";
        ownerList(path,zyOwnerRoomDtos);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

    //访客管理
    public static void zyVisitorList(String fileName,List<ExVisitor> list){
        //"E:\\lx.xls"
        List<ExVisitor> dataList = new ArrayList<>();

        for (ExVisitor zyVisitor : list) {
            dataList.add(zyVisitor);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, ExVisitor.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }

    @Log(title = "访客管理", businessType = BusinessType.EXPORT)
    @PostMapping("zyVisitorList")
    public Map<String, Object> getzyVisitorList(@RequestBody List<String> list) {
        Map<String, Object> result = new HashMap<>();
        if (list.size()==0){
            list=null;
        }
        List<ExVisitor> zyVisitorList = zyVisitorDao.getZyVisitorList(list);
        String path="D:\\lx.xls";
        zyVisitorList(path,zyVisitorList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }
    /**
     * 投诉建议导出
     * @param fileName
     * @param list
     */
    public static void suggestList(String fileName,List<ExSuggest> list){
        //"E:\\lx.xls"
        List<ExSuggest> dataList = new ArrayList<>();

        for (ExSuggest exSuggest : list) {
            dataList.add(exSuggest);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, ExSuggest.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }
    @Log(title = "投诉建议管理", businessType = BusinessType.EXPORT)
    @PostMapping("suggestList")
    public Map<String, Object> getsuggestList(@RequestBody List<String> list) {
        Map<String, Object> result = new HashMap<>();
        if (list.size()==0){
            list=null;
        }
        List<ExSuggest> exSuggestList = zyComplaintSuggestDao.getExSuggestList(list);
        String path="D:\\lx.xls";
        suggestList(path,exSuggestList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

    /**
     * 报修导出
     * @param fileName
     * @param list
     */
    public static void getZyRepairListS(String fileName,List<ExZyRepair> list){
        //"E:\\lx.xls"
        List<ExZyRepair> dataList = new ArrayList<>();

        for (ExZyRepair exSuggest : list) {
            dataList.add(exSuggest);
        }

        // 设置单元格样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy( StyleUtils.getHeadStyle(),StyleUtils.getContentStyle());

        EasyExcel.write(fileName, ExZyRepair.class)
                .sheet(0)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .doWrite(dataList);
    }

    @Log(title = "报修管理", businessType = BusinessType.EXPORT)
    @PostMapping("getZyRepairListS")
    public Map<String, Object> getZyRepairListS(@RequestBody List<String> list) {
        Map<String, Object> result = new HashMap<>();
        if (list.size()==0){
            list=null;
        }
        List<ExZyRepair> exSuggestList = zyRepairDao.getZyRepairListS(list);
        String path="D:\\lx.xls";
        getZyRepairListS(path,exSuggestList);
        result.put("msg","导出成功");
        result.put("status","200");
        result.put("path",path);
        return result;
    }

}
