package com.itCs520.deanProject.Basic.Day04.linear;

public class TwoWayLinkListTest {
    public static void main(String[] args) {
        //创建顺序表对象

        TwoWayLinkList<String> s1 = new TwoWayLinkList<>();

        //测试插入
        s1.insert("Max");
        s1.insert("zhou");
        s1.insert("sainz");
        s1.insert(1,"perkz");

        for (String s:s1) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------------");
        //测试获得
        String getResult = s1.get(1);
        System.out.println("获得结果："+ getResult);
        //测试删除
        String removeResult = s1.remove(1);
        System.out.println("删除元素："+ removeResult);
        //测试情况
        s1.clear();
        System.out.println(s1.length());

        System.out.println("-------------------------------------------");

        System.out.println("第一个元素是："+s1.getFirst());
        System.out.println("最后一个元素是："+s1.getLast());
    }
}
