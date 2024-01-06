package com.itCs520.deanProject.LeetCode;/*
 *ClassName:LeetCode20
 *Description:
 *@Author:deanzhou
 *@Date:2023/2/7 00:30
 */

import java.util.Stack;

public class LeetCode20 {
    /*1. 通过stack去做 利用FILO
    * */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c:s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop()==c)
                return false;
        }
        return stack.isEmpty();
    }
}
