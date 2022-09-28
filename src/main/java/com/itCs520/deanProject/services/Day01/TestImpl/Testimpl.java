package com.itCs520.deanProject.services.Day01.TestImpl;

import com.itCs520.deanProject.services.Day01.Test;

public class Testimpl implements Test {

    @Override
    public void test1() {
        int sum= 0;
        int n= 100;
        for (int i = 1; i < n; i++) {
            sum+=i;
        }
        System.out.println("第一种方法："+sum );
    }

    @Override
    public void test2() {
        int sum= 0;
        int n= 100;
        sum = (n+1)*n/2;
        System.out.println("第二种方法：" + sum);
    }
}
