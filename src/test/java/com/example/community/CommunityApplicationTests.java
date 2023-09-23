package com.example.community;

import com.example.community.utils.easyexcel.TextReadObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.SyncReadListener;
import com.alibaba.fastjson.JSON;

import java.util.*;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class CommunityApplicationTests {

    static String usingUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("-", "");
    }

    @Test
    void test(){
        String randomString = usingUUID();
        String path = "D:\\"+randomString+".xls";
        System.err.println(path);
    }

    @Test
    void contextLoads() {
    }

    @Test
    public static void simpleRead() {
        String fileName = "E:\\cs.xls";
        final List dataList = new ArrayList();
        EasyExcel.read(fileName, TextReadObject.class, new SyncReadListener() {
            @Override
            public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
                System.out.println("表头->"+headMap);
            }
            @Override
            public void invoke(Object object, AnalysisContext context) {
                dataList.add(object);
            }
        }).sheet(0).headRowNumber(3).doRead();
        for (Object o : dataList) {
            TextReadObject TOB = (TextReadObject) o;
            System.out.println(JSON.toJSONString(TOB));
        }
    }
    public static void main(String[] args) { simpleRead(); }

}
