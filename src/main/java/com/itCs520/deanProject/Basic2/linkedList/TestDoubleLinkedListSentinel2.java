package com.itCs520.deanProject.Basic2.linkedList;/*
 *ClassName:TestDoubleLinkedListSentinel
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/21 13:34
 */

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TestDoubleLinkedListSentinel2 {

    //1. getlist
    @Test
    @DisplayName("getlist")
    public  void getlist(){
        DoubleLinkedListSentinel2 list = new DoubleLinkedListSentinel2();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        for (Integer num:list) {
            System.out.println(num);
        }
    }

    @Test
    @DisplayName("removeByValue")
    public void test2(){
        DoubleLinkedListSentinel2 list = new DoubleLinkedListSentinel2();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.removeByValue(1);

        for (Integer num:list) {
            System.out.println(num);
        }
    }
}
