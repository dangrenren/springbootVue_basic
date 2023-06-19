package com.example.spring_basic;

import io.swagger.models.auth.In;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class leetcodeTest {
    @Test
    public void newQueue() {


        ListNode nodeSta = new ListNode(1);    //创建首节点
        ListNode nextNode;                     //声明一个变量用来在移动过程中指向当前节点
        nextNode = nodeSta;                      //指向首节点
/**
 //创建链表

 ListNode node1 = new ListNode(3);  //生成新的节点
 nextNode.next=node1;               //把新节点连起来
 nextNode=nextNode.next;           //当前节点往后移动

 ListNode node2 = new ListNode(2);  //生成新的节点
 nextNode=node2;
 //nextNode.next=node2;               //把新节点连起来
 // nextNode=nextNode.next;           //当前节点往后移动
 **/
        //nextNode=nodeSta;                     //重新赋值让它指向首节点

        Solution solution = new Solution();
        // solution.print(nextNode);
        int[] ints = solution.reversePrint(nodeSta);
        for (int s1 : ints
        ) {
            System.out.println(s1);
        }
    }


    public String replaceSpace(String s) {
        //用数组实现
        char[] chars = s.toCharArray();
        //找出来有空格的位置，然后记下来，然后按顺序，将%20填入到字符串中
        // ArrayList<Integer> position = new ArrayList<>();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                length += 2;
                for (int j = i; j < length; j++) {
                    //将空格后面的字符往后移动两位
                    chars[j + 2] = chars[j];
                }
                //position.add(i);//将空格位置放入到数组中
                chars[i] = '%';
                chars[i + 1] = '2';
                chars[i + 2] = '0';
            }
        }
        String string = chars.toString();
        return string;
    }


    @Test
    public void test1() {
        String testString = "我爱 你";
        String s1 = replaceSpace(testString);
        System.out.println(s1);

    }


}

class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    public void print(ListNode listNoed) {
        //创建链表节点
        while (listNoed != null) {
            System.out.println("节点:" + listNoed.val);
            listNoed = listNoed.next;
        }
        System.out.println("链表已经空了");
    }

}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }//有参构造方法

}