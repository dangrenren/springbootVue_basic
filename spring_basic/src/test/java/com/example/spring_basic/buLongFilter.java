package com.example.spring_basic;/*
 *@description
 总结：一个名叫 Bloom 的人提出了一种来检索元素是否在给定大集合中的数据结构，这种数据结构是高效且性能很好的，
 但缺点是具有一定的错误识别率和删除难度。并且，理论情况下，添加到集合中的元素越多，误报的可能性就越大。
 这段代码使用了google编写的布隆过滤器。
 *@author dangren
 *@create 2023/11/1 23:50
 */


import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class buLongFilter {
    @Test
    public void testBuLongFilter() {
        // 创建布隆过滤器对象
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                15000,
                0.01);
        // 判断指定元素是否存在
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        // 将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
    }

    @Test
    public void test2() {
        int expectedInsertions = 1000; // 预期插入数量
        double falsePositiveProbability = 0.01; // 误判率
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), expectedInsertions, falsePositiveProbability);
        bloomFilter.put("element1");
        bloomFilter.put("element2");
        // 添加更多元素
        boolean exists = bloomFilter.mightContain("element1"); // 如果返回 true，表示元素可能存在
        boolean notExists = bloomFilter.mightContain("element3"); // 如果返回 false，表示元素肯定不存在
        System.out.println(exists);
        System.out.println(notExists);
    }
}
