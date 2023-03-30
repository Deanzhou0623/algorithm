package com.itCs520.deanProject.LeetCode;/*
 *ClassName:LeetCode121
 *Description:
 *@Author:deanzhou
 *@Date:2023/2/26 16:01
 */

public class LeetCode121 {
/*
    状态转移公式
                             未持有股票                           持有股票
    prices 数组                  [0]                               [1]
    |  |  dp[i-1]               |  |                              |  |
    i-1

   |  | dp[i]     max(dp[i-1][0],dp[i-1][1]+prices[i])       max(dp[i-1][1],-prices[i])
    i               两种情况： 1. 跟前一天一样 未持有股票             两种情况：1. 继续持有股票
                             2. 前一天持有股票，但是今天讲股票卖出             2. 前一天未持有股票，
                                                                             今天买入股票
* */
    public int maxProfit(int[] prices){
        //1.初始化dp数组
        int len=prices.length;
        //1.1 len代表买入/卖出股票的时间  2代表状态 0代表未持有 1代表持有
        int[][] dp=new int[len][2];
        //2.基于业务判断，当天数小于2无法购买彩票
        if (len<2) return 0;
        //3.定义dp数组下标状态
        //3.1 未持有股票
        dp[0][0] = 0;
        //3.2 持有股票
        dp[0][1]= - prices[0];
        //4.遍历确认状态转移公式 第二天开始
        for (int i = 1; i <len; i++) {
            //未持有
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //持有
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        //5.返回数据
        return dp[len-1][0];
    }

    //优化解法  (找出这段时间内 哪天价格最高/哪天价格最低)
    public int maxProfit2(int[] prices){
        if(prices.length <2) return 0;
        //初始化
        int maxProfit=0;
        int min=prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]>min){
                maxProfit = Math.max(maxProfit,prices[i]-min);
            }else {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}
