package com.itCs520.deanProject.Basic2.linkedList;/*
 *ClassName:TestSinglyLinkedList
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/15 19:30
 */

import com.sun.tools.javac.util.List;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TestSinglyLinkedListSentinel {

    @Test
    @DisplayName("测试  addlast")
    public void test1(){
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

//        list.loop(value->{
//            System.out.println(value);
//        });

        list.loop2(value->
                System.out.println(value));
    }

    @Test
    public void test2(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test3(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.loop2(value ->
                System.out.println(value));
    }

    @Test
    @DisplayName("get method")
    public void test4(){
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        //list.test();
        System.out.println(list.get(2));

    }

    @Test
    @DisplayName("insert")
    public void test5(){
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.insert(2,5);

        for (Integer value:list) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("remove")
    public void test6(){
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.insert(2,5);

        for (Integer value:list) {
            System.out.println(value);
        }
        System.out.println("===================");
        list.removeFirst();
        System.out.println("===================");
        for (Integer value:list) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("remove")
    public void test7() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        for (Integer value:list) {
            System.out.println(value);
        }
        System.out.println("==================");

        list.remove(4);
        list.remove(3);
        list.remove(2);
        list.remove(1);
        list.remove(0);
//        list.remove(5);
        for (Integer value:list) {
            System.out.println(value);
        }
    }
}
