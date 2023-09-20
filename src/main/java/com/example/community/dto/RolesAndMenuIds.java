package com.example.community.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Data
public class RolesAndMenuIds {
    //角色ID
    @ColumnWidth(8)//单独设置列宽
    @ExcelProperty(index = 0, value = {"ID"})
    private Long roleId;
    //角色名称
    @ExcelProperty(index = 1, value = {"角色名称"})
    private String roleName;
    //角色权限字符串
    @ExcelProperty(index = 2, value = {"权限字符"})
    private String roleKey;
    //显示顺序
    @ExcelProperty(index = 3, value = {"显示顺序"})
    private Integer roleSort;
    //数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
    @ExcelIgnore
    private String dataScope;
    //菜单树选择项是否关联显示
    @ExcelIgnore
    private Integer menuCheckStrictly;
    //部门树选择项是否关联显示
    @ExcelIgnore
    private Integer deptCheckStrictly;
    //角色状态（0正常 1停用）
    @ExcelProperty(index = 4, value = {"状态（0正常 1停用）"})
    private String status;
    //删除标志（0代表存在 2代表删除）
    @ExcelProperty(index = 5, value = {"删除标志（0存在 2删除）"})
    private String delFlag;
    //创建者
    @ExcelIgnore
    private String createBy;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ColumnWidth(19)//单独设置列宽
    @ExcelProperty(index = 6, value = {"创建时间"})
    private String createTime;
    //更新者
    @ExcelIgnore
    private String updateBy;
    //更新时间
    @ExcelIgnore
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String updateTime;
    //备注
    @ExcelIgnore
    private String remark;

    List menuIds;
}
