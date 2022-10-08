package com.itCs520.deanProject.services.Day04.linear;

public class LinkListTest {
    public static void main(String[] args) {
        //创建顺序表对象

        LinkList<String> s1 = new LinkList<>();

        //测试插入
        s1.insert("Max");
        s1.insert("zhou");
        s1.insert("sainz");
        s1.insert(1,"perkz");

        for (String s:s1) {
            System.out.println(s);
        }
        
        //测试获得
        String getResult = s1.get(1);
        System.out.println("获得结果："+ getResult);
        //测试删除
        String removeResult = s1.remove(1);
        System.out.println("删除元素："+ removeResult);
        //测试情况
//        s1.clear();
        System.out.println(s1.length());
    }
}