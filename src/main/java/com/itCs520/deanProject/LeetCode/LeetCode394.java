package com.itCs520.deanProject.LeetCode;

import com.itCs520.deanProject.Basic.Day04.linear.Stack;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class LeetCode394 {
    /*给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。

示例 1：
输入：s = "3[a]2[bc]"
输出："aaabcbc"
示例 2：
输入：s = "3[a2[c]]"
输出："accaccacc"
示例 3：
输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"
    * */

    /*solution1: 采用LinkedList方法实现
    * */
    int ptr;

    public String decodeString(String s) {
        //1. 创建一个LinkedList对象
        LinkedList<String> stk = new LinkedList<>();
        //2. 定义变量记录次数
         ptr=0;
        //3. 循环字符串
        while (ptr<s.length()){
            //4. 处理数字，如果数字是 2位需要合并
            char cur=s.charAt(ptr);
            if (Character.isDigit(cur)){
                //如果cur是数字则进stack
                String dights = getDights(s);
                stk.addLast(dights);
            }else if (Character.isLetter(cur) || cur == '[' ){
                //5. 处理普通字符和"["
                    //获取字母进站
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            }else {
                //6. 处理"[" 和 "]" 之间的字符
                ++ ptr;
                //7. 创建新的linkedList对象进行组合
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())){
                    sub.addLast(stk.removeLast());
                }
                //8. 因为是FILO的结构，所以需要反转
                Collections.reverse(sub);
                /*左括号出栈*/
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                //9. 构造字符串
                while (repTime-->0){
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }

        }
        return getString(stk);
    }
    //获取数字可能是 1位或者2位
    private String getDights(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))){
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    //获取字符串
    public String getString(LinkedList<String> v){
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    /*solution2: 基于stack实现
    * */
    public String decodeString2(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        final Stack<String> resStack = new Stack<>();
        int idx=0;

        //循环该字符串
        while (idx < s.length()){
            char cur =s.charAt(idx);
            /*处理数据*/
            if (Character.isDigit(cur)){
                StringBuffer ret = new StringBuffer();
                while (Character.isDigit(s.charAt(idx))){
                    ret.append(s.charAt(idx++));
                }
                countStack.push(Integer.parseInt(ret.toString()));
            }
            else if (cur=='['){
                /*处理"["*/
                resStack.push(res);
                res="";
                idx++;
            }
            else if ( cur == ']'){
                /*处理"]" ,处理相匹配的"[" 之间的字符*/
                StringBuffer temp = new StringBuffer(resStack.pop());
                int repeaTimes = countStack.pop();
                for (int i = 0; i < repeaTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                /*处理普通字符*/
                res +=s.charAt(idx++);
            }
        }
        return res;
    }
}
