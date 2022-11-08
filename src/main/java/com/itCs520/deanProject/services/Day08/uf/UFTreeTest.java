package com.itCs520.deanProject.services.Day08.uf;

import java.util.Scanner;

public class UFTreeTest {
    public static void main(String[] args) {
        //创建并查集对象
        UF_tree uf = new UF_tree(5);
        System.out.println("默认情况下"+uf.count()+" 分组");
        //控制台录入要合并元素
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("第一个要合并元素:");
            int p=scanner.nextInt();
            System.out.println("第二个要合并元素:");
            int q=scanner.nextInt();

            //判断是否已经合并了
            if (uf.connnected(p,q)){
                System.out.println(p+"元素和"+q+"已经在同一个组中");
                continue;
            }
            uf.union(p,q);
            System.out.println("当前并查集还有"+uf.count()+"分组");
        }

    }
}
