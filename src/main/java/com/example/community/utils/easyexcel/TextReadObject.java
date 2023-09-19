package com.example.community.utils.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextReadObject {

    @ExcelProperty(index = 0)
    private Integer studentId;

    @ExcelProperty(index = 1)
    private String studentName;

    @ExcelProperty(index = 2)
    private String institute;

    @ExcelProperty(index = 3)
    private Integer level_11;

    @ExcelProperty(index = 4)
    private Integer level_12;

    @ExcelProperty(index = 5)
    private Integer level_21;

    @ExcelProperty(index = 6)
    private Integer level_22;
}