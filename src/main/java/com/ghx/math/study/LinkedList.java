package com.ghx.math.study;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author：ghx
 * @date：2020/5/5 22:46
 * @describe：从尾到头打印链表
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class LinkedList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (listNode!=null){
            list.add(listNode.val);
            listNode=listNode.next;
        }
        for( int i = list.size()-1; i>=0; i--){
             result.add(list.get(i));
        }
        return  result;
    }
}