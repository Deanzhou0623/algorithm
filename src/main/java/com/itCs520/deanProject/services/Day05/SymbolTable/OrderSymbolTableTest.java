package com.itCs520.deanProject.services.Day05.SymbolTable;

public class OrderSymbolTableTest {
    public static void main(String[] args) {
        //创建符号对象表
        OrderSysmbolTable2<Integer, String> symbolTable = new OrderSysmbolTable2<>();

        //测试put方法
        symbolTable.put(1,"前锋");
        symbolTable.put(2,"后锋");
        symbolTable.put(4,"外锋");
        symbolTable.put(5,"里锋");
        symbolTable.put(3,"ccc");

        System.out.println("元素插入个数为"+symbolTable.size());
        symbolTable.put(2,"kunkun");
        System.out.println("替换完毕后的元素个数"+symbolTable.size());

        //测试get方法
        System.out.println("替换完毕后，键2对应的值"+symbolTable.get(2));

        //测试删除方法
        symbolTable.delete(2);
        System.out.println("删除完毕后，元素的个数"+symbolTable.size());
    }
}
