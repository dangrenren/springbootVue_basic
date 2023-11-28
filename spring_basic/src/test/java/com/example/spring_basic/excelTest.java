package com.example.spring_basic;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.example.spring_basic.entity.DemoData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
public class excelTest {
    private List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    @Test
    public void simpleWrite() {
        String fileName = "D:/img/download/" + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
    }

    @Test
    public void testStream() {
        List<Integer> numbers = Arrays.asList(1, 3, 4, 5);
        Optional<Integer> allEven = numbers.stream()
                .filter(x -> x % 2 == 0)
                .findAny();
        System.out.println(allEven);

    }

    class parentClass {
        parentClass() {
            System.out.println("parentClass is created");
        }
    }

    class subClass extends parentClass {
        subClass() {
            super();
            System.out.println("subClass is created");
        }
    }

    @Test
    public void testSuper() {
        subClass d = new subClass();
    }


}
