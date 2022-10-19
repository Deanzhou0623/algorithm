package com.itCs520.deanProject.services.Day04.linear;

public class StackTest {
    public static void main(String[] args) {
        //创建栈对象
        Stack<String> stack = new Stack<>();

        //测试压栈
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        for (String item : stack) {
            System.out.println(item);
        }
        System.out.println("------------------------------");
        //测试弹栈
        String pop = stack.pop();
        System.out.println("弹栈元素是"+pop);
        System.out.println("剩下元素个数为"+stack.size());
    }
}
