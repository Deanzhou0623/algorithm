package com.itCs520.deanProject.services.Day08.uf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Traffic_project_Test {
    public static void main(String[] args)  throws Exception{
        //构建缓冲读取流  BufferReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Traffic_project_Test.class.getClassLoader().getResourceAsStream("traffic_project.txt")));
        //读取第一行的数据
        int totalNumber = Integer.parseInt(bufferedReader.readLine());
        //构建一个并查集对象
        UF_tree_Weighted weighted = new UF_tree_Weighted(totalNumber);
        //读取第二行数据
        int roadNumber=Integer.parseInt(bufferedReader.readLine());
        //循环读取七条道路
        for (int i = 1; i <roadNumber ; i++) {
              String line = bufferedReader.readLine();
            String[] s = line.split(" ");
            int p=Integer.parseInt(s[0]);
            int q=Integer.parseInt(s[1]);

            //调用并查集对象union方法让两个城市想通
            weighted.union(p,q);

        }
        //获取当前并查集分组数量-1
        int road=weighted.count()-1;
        System.out.println("还需要修建"+road+" 条道路");
    }

}
