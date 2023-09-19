package com.example.community.utils.easyexcel;

import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public class StyleUtils {

    /**
     * 内容样式
     * @return
     */
    public static WriteCellStyle getContentStyle(){
        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);// 水平居中
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
        return contentWriteCellStyle;
    }

    /**
     * 标题样式
     * @return
     */
    public static WriteCellStyle getHeadStyle() {
        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        return headWriteCellStyle;
    }
}
