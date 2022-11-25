package com.itCs520.deanProject.LeetCode;

import java.util.HashSet;

public class Offer53 {
    /*一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
      在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     示例 1:
    输入: [0,1,3]
    输出: 2
    示例 2:
    输入: [0,1,2,3,4,5,6,7,9]
    输出: 8
限制：
1 <= 数组长度 <= 10000
    * */

    /*1. solution1: 数学方法  1+...... +n-1 =  [n(n-1)]* 0.5 - n
    * */
    public int missingNumber(int[] nums){
        //1. 正常 0-n-1 的和为n(n-1)
        //2. 因为 0-n-1数组中缺失一个数因此 需要+1
        int n=nums.length+1;
        int sum= n*(n-1)/2;
        //3.定义变量存储nums数组和
        int arrSum=0;
        //4. 扫描该数组所有的数并计算出和
        for (int i = 0; i < nums.length; i++) {
            arrSum+=nums[i];
        }
        //3. 两数相减即为缺的数
       return sum-arrSum;
    }
    /*2.solution2: 直接hash遍历
    * */
    public int missingNumber2(int[] nums){
        //1创建hashSet对象
        HashSet<Integer> set = new HashSet<>();
        //2循环遍历nums
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int missing=-1;
        for (int i = 0; i <=n; i++) {
            if (!set.contains(i)){
                missing=i;
                break;
            }
        }
        return missing;
    }
    /*3.solution3: 通过 nums[i] 直接与i进行对比
     * */
    public int missingNumber3(int[] nums){
        //1创建对象存储nums长度
        int n=nums.length;
        //2循环比较i
        for (int i = 0; i < n; i++) {
            if (nums[i]!=i){
                return i;
            }
        }
        return n;
    }
}
