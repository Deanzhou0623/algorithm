package com.itCs520.deanProject.Basic.Day05.SymbolTable;

import com.itCs520.deanProject.Basic.Day05.SymbolTable.SysmbolTable2;

public class SymbolTableTest {
    public static void main(String[] args) {
        //创建符号对象表
//        SymbolTable<Integer, String> symbolTable = new SymbolTable<>();
        com.itCs520.deanProject.Basic.Day05.SymbolTable.SysmbolTable2<Integer, String> sysmbolTable = new SysmbolTable2<>();

        //测试put方法
        sysmbolTable.put(1,"前锋");
        sysmbolTable.put(2,"后锋");
        sysmbolTable.put(3,"外锋");
        sysmbolTable.put(4,"里锋");

        System.out.println("元素插入个数为"+sysmbolTable.size());
        sysmbolTable.put(2,"kunkun");
        System.out.println("替换完毕后的元素个数"+sysmbolTable.size());

        //测试get方法
        System.out.println("替换完毕后，键2对应的值"+sysmbolTable.get(2));

        //测试删除方法
        sysmbolTable.delete(2);
        System.out.println("删除完毕后，元素的个数"+sysmbolTable.size());
    }
}
