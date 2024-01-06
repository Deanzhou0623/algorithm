package com.itCs520.deanProject.LeetCode;/*
 *ClassName:LeetCode415
 *Description:
 *@Author:deanzhou
 *@Date:2023/2/8 21:01
 */

public class LeetCode415 {
    public String addStrings(String num1, String num2) {
        //1. StringBuilder 做字符串拼接
        StringBuilder sb = new StringBuilder();
        //2. define a parameter
        int count=0;
        //3. iterator the stringBuilder 当count ！=1 说明已经加到头
        for (int i = num1.length()-1, j=num2.length()-1;
             i >=0 || j >=0 || count == 1 ; i--,j--) {
            //4. transfer char to integer
            /*  1 2 3
                  4 5
                判断 j是否是 已经结束 但是 i还没有结束
                因此 i<0 , j<0
            * */
            int x = i<0 ? 0:num1.charAt(i) -'0';
            int y = j<0 ? 0:num2.charAt(i) -'0';
            //5. 字符串拼接 ，从最后一位开始，所以 123  ,先取 3，然后2，然后 1
            sb.append((x+y+count)%10);
            //6. 是否需要进一位 ，count+1
            count=(x+y+count)/10;
        }
        //7. return value
        return sb.reverse().toString();
    }
}
