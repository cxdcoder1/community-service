package com.example.community.utils.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;


@ColumnWidth(15) //列宽,最大值为255
@HeadRowHeight(16) //表头行高
@ContentRowHeight(16) //数据行高
public class TextWriteObject {
    //复杂表头自动合并相同的内容
    @ExcelProperty(index = 0, value = {"学号", "学号", "学号"})
    private Integer studentId;

    @ExcelProperty(index = 1, value = {"姓名", "姓名", "姓名"})
    private String studentName;

    @ColumnWidth(25)//单独设置列宽
    @ExcelProperty(index = 2, value = {"学院", "学院", "学院"})
    private String institute;
    //复杂表头嵌套
    @ExcelProperty(index = 3, value = {"成绩", "第一学年", "第一学期"})
    private Integer level_11;

    @ExcelProperty(index = 4, value = {"成绩", "第一学年", "第二学期"})
    private Integer level_12;

    @ExcelProperty(index = 5, value = {"成绩", "第二学年", "第一学期"})
    private Integer level_21;

    @ExcelProperty(index = 6, value = {"成绩", "第二学年", "第二学期"})
    private Integer level_22;

    public TextWriteObject() {
    }

    public TextWriteObject(Integer studentId, String studentName, String institute, Integer level_11, Integer level_12, Integer level_21, Integer level_22) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.institute = institute;
        this.level_11 = level_11;
        this.level_12 = level_12;
        this.level_21 = level_21;
        this.level_22 = level_22;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public Integer getLevel_11() {
        return level_11;
    }

    public void setLevel_11(Integer level_11) {
        this.level_11 = level_11;
    }

    public Integer getLevel_12() {
        return level_12;
    }

    public void setLevel_12(Integer level_12) {
        this.level_12 = level_12;
    }

    public Integer getLevel_21() {
        return level_21;
    }

    public void setLevel_21(Integer level_21) {
        this.level_21 = level_21;
    }

    public Integer getLevel_22() {
        return level_22;
    }

    public void setLevel_22(Integer level_22) {
        this.level_22 = level_22;
    }
}