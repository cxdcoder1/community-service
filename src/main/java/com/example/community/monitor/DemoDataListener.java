package com.example.community.monitor;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import java.util.Map;
import java.util.List;

import com.example.community.utils.easyexcel.TextReadObject;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DemoDataListener extends AnalysisEventListener<TextReadObject> {
    private List<TextReadObject> dataList;
    //读取表头的内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头->"+headMap);
    }
    //一行一行读取excel中的内容
    @Override
    public void invoke(TextReadObject data, AnalysisContext context) {
        dataList.add(data);
    }
    //读取完成之后执行的方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {}
}