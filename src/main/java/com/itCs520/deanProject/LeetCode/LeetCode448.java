package com.itCs520.deanProject.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode448 {
    /*给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
    请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。

    事例：
    输入：nums = [4,3,2,7,8,2,3,1]
    输出：[5,6]

    输入：nums = [1,1]
    输出：[2]
    提示：

    n == nums.length
    1 <= n <= 105
    1 <= nums[i] <= n
    进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
     */

    /*1. solution1:利用下标记录数组中的数据，看哪些数据没有被改动
            [4][3][2][7][8][2][3][1]
             0  1  2  3  4  5  6  7

         操作 元素-1 ，并把 对应下标元素改为 负数
            nums[0] = 4
             4-1 =3
             因此 把 nums[3] = -7 或者 ➕一个n
              [-4][-3][-2][-7] [8] [2][-3][-1]
               0    1   2   3   4   5   6   7
    * */

    public List<Integer> findDisappearedNumbers(int[] nums){
        //1.确定长度
        int n=nums.length;
        //2.对数组元素-1
        for (int num : nums) {
            int x=(num-1)%n; //栈内存移除异常，因此要取模
            nums[x] +=n; // nums[x]  =  nums[x]+ n;
        }
        //3.处理对应下标对元素
        ArrayList<Integer> result = new ArrayList<>();
        //4.添加缺失的元素到数组并返回
        for (int i = 0; i < n; i++) {
            if (nums[i]<=n){
                result.add(i+1); //下标从0开始因此，对应元素 需要+1
            }
        }
        return result;
    }
}
