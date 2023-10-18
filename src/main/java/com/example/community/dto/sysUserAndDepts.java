package com.example.community.dto;

public class sysUserAndDepts {

    private String deptName;

    private String deptNum;


    public sysUserAndDepts() {
    }

    public sysUserAndDepts(String deptName, String deptNum) {
        this.deptName = deptName;
        this.deptNum = deptNum;
    }

    /**
     * 获取
     * @return deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取
     * @return deptNum
     */
    public String getDeptNum() {
        return deptNum;
    }

    /**
     * 设置
     * @param deptNum
     */
    public void setDeptNum(String deptNum) {
        this.deptNum = deptNum;
    }

    public String toString() {
        return "sysUserAndDepts{deptName = " + deptName + ", deptNum = " + deptNum + "}";
    }
}
