package com.example.spring_basic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 *@description
 *@author dangren
 *@create 2023/11/1 17:48
 */
public class TreeMapTest {
    /**
     * @description treeMap和hashMap的使用方法及区别
     * @author dangren
     * @time 2023/11/1 17:58
     */
    @Test
    public void testMap() {
        // 创建一个 TreeMap 和一个 HashMap
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        HashMap<Integer, String> hashMap = new HashMap<>();

        // 添加键值对
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");

        hashMap.put(3, "Three");
        hashMap.put(1, "One");
        hashMap.put(2, "Two");

        // 查找键对应的值
        int keyToFind = 2;
        String valueFromTreeMap = treeMap.get(keyToFind);
        String valueFromHashMap = hashMap.get(keyToFind);
        System.out.println("Value for key " + keyToFind + " in TreeMap: " + valueFromTreeMap);
        System.out.println("Value for key " + keyToFind + " in HashMap: " + valueFromHashMap);

        // 删除键值对
        int keyToDelete = 3;
        treeMap.remove(keyToDelete);
        hashMap.remove(keyToDelete);

        // 遍历 TreeMap
        System.out.println("TreeMap:");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 遍历 HashMap
        System.out.println("HashMap:");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    /**
     * @description 希尔排序
     * @author dangren
     * @time 2023/11/2 14:06
     */
    public int[] shellSort(int[] arr) {

        return arr;
    }


}

