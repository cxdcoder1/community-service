package com.example.community.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;


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

    public RolesAndMenuIds() {
    }

    public RolesAndMenuIds(Long roleId, String roleName, String roleKey, Integer roleSort, String dataScope, Integer menuCheckStrictly, Integer deptCheckStrictly, String status, String delFlag, String createBy, String createTime, String updateBy, String updateTime, String remark, List menuIds) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleKey = roleKey;
        this.roleSort = roleSort;
        this.dataScope = dataScope;
        this.menuCheckStrictly = menuCheckStrictly;
        this.deptCheckStrictly = deptCheckStrictly;
        this.status = status;
        this.delFlag = delFlag;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.remark = remark;
        this.menuIds = menuIds;
    }

    /**
     * 获取
     * @return roleId
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取
     * @return roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取
     * @return roleKey
     */
    public String getRoleKey() {
        return roleKey;
    }

    /**
     * 设置
     * @param roleKey
     */
    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    /**
     * 获取
     * @return roleSort
     */
    public Integer getRoleSort() {
        return roleSort;
    }

    /**
     * 设置
     * @param roleSort
     */
    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    /**
     * 获取
     * @return dataScope
     */
    public String getDataScope() {
        return dataScope;
    }

    /**
     * 设置
     * @param dataScope
     */
    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    /**
     * 获取
     * @return menuCheckStrictly
     */
    public Integer getMenuCheckStrictly() {
        return menuCheckStrictly;
    }

    /**
     * 设置
     * @param menuCheckStrictly
     */
    public void setMenuCheckStrictly(Integer menuCheckStrictly) {
        this.menuCheckStrictly = menuCheckStrictly;
    }

    /**
     * 获取
     * @return deptCheckStrictly
     */
    public Integer getDeptCheckStrictly() {
        return deptCheckStrictly;
    }

    /**
     * 设置
     * @param deptCheckStrictly
     */
    public void setDeptCheckStrictly(Integer deptCheckStrictly) {
        this.deptCheckStrictly = deptCheckStrictly;
    }

    /**
     * 获取
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取
     * @return delFlag
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置
     * @param delFlag
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取
     * @return createBy
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取
     * @return createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateBy
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取
     * @return updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取
     * @return menuIds
     */
    public List getMenuIds() {
        return menuIds;
    }

    /**
     * 设置
     * @param menuIds
     */
    public void setMenuIds(List menuIds) {
        this.menuIds = menuIds;
    }

    public String toString() {
        return "RolesAndMenuIds{roleId = " + roleId + ", roleName = " + roleName + ", roleKey = " + roleKey + ", roleSort = " + roleSort + ", dataScope = " + dataScope + ", menuCheckStrictly = " + menuCheckStrictly + ", deptCheckStrictly = " + deptCheckStrictly + ", status = " + status + ", delFlag = " + delFlag + ", createBy = " + createBy + ", createTime = " + createTime + ", updateBy = " + updateBy + ", updateTime = " + updateTime + ", remark = " + remark + ", menuIds = " + menuIds + "}";
    }
}
