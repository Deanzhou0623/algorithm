package com.itCs520.deanProject.services.Day03.Test;

import com.itCs520.deanProject.entity.Day03.Student;

// 定义测试类接口，在测试类中定义 compare getMax方法
public class TestComparable {
    //学生测试类
    public static void main(String[] args) {
        //学生对象
        Student s1 = new Student();
        s1.setAge(20);
        s1.setUsername("张三");
        //学生对象
        Student s2 = new Student();
        s2.setAge(40);
        s2.setUsername("李四");

        Comparable max = getMax(s1, s2);
        System.out.println(max);
    }

    public static Comparable getMax(Comparable c1 ,Comparable c2 ){
        int result = c1.compareTo(c2);
        // result <0 c1 < c2
        // result > 0 c1 > c2
        // = 0 , c1=c2
        if (result >=0){
            return c1;
        }else {
            return c2;
        }
    }

}
