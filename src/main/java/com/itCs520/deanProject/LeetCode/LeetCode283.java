package com.itCs520.deanProject.LeetCode;

public class LeetCode283 {
    /*题目：给定一个数组nums，编写一个函数将所有的0移动到数组末尾同时保持非0元素的相对顺序

    事例:
    输入：[0,1,0,3,12]
    输出：[1,3,12,0,0]

    说明：
    1. 必须在原数组上操作,不能拷贝额外数组
    2. 尽量减少操作次数
    * */

    /*1. solution1: 双指针指向数组
    * */
    public void moveZeros1(int[] nums){
        //1. 判断nums是否为空
        if (nums == null){
            return;
        }
        //2. 第一次遍历，j指针记录非0个数，只要是非0通通赋值给nums[j]；
        int j=0;
        for (int i = 0; i < nums.length; ++i) { // ++i 先运行 运行完后+1 保证 nums[0]也能判断到
            if (nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        //3. 非0元素统计完成，剩下就是0元素，第二次遍历将末尾元素都改成0即可 i=5
         //假设 j=3 ，即 还剩2个元素需要赋值
        for (int i=j;i<nums.length;++i){
            nums[i] = 0;
        }
    }
    /*2. solution2: 双指针指向数组 -- 简化写法
     * */
    public void moveZeros2(int[] nums){
        if (nums == null && nums.length == 0) return;

        int insertPos = 0;
        for (int num : nums) {
            if (num!=0) nums[insertPos++] = num;
        }

        while (insertPos< nums.length);
            nums[insertPos++] = 0;
    }

}
