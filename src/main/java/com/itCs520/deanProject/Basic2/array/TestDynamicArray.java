package com.itCs520.deanProject.Basic2.array;/*
 *ClassName:TestDynamicArray
 *Description:
 *@Author:deanzhou
 *@Date:2023/6/13 21:01
 */


import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;

public class TestDynamicArray {

    @Test
    @DisplayName("测试遍历1")
    public void test1(){
        DynamicArray array = new DynamicArray();
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);
//        array.add(2,5);
//        for (int i = 0; i < 5; i++) {
//            System.out.print(array.get(i)+" ");
//        }


        //foreach
        array.foreach((element)->{
            System.out.println(element);
        });
    }

    @Test
    @DisplayName("测试遍历2")
    public void test2(){
        DynamicArray array = new DynamicArray();
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);

        for (Integer element: array){ //hashNext, next
            System.out.println(element);
        }
    }

    @Test
    @DisplayName("测试遍历3")
    public void test3(){
        DynamicArray array = new DynamicArray();
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);

        array.stream().forEach((element)->{
            System.out.println(element);
        });
    }

    @Test
    @DisplayName("测试remove方法")
    public void test4(){
        DynamicArray array = new DynamicArray();
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);

        int removed= array.remove(2);
        System.out.println(removed);

//        System.out.println("-----------------");
//
//        array.stream().forEach((element)->
//                System.out.println(element));
        //断言单独判断的方式
         Assert.assertEquals(3,removed);
         //断言循环判断
    }

    @Test
    public void test(){
        DynamicArray array = new DynamicArray();
        for (int i = 0; i < 9; i++) {
            array.addLast(i+1);
        }

        array.stream().forEach((element)->{
            System.out.println(element);
        });
    }
}
