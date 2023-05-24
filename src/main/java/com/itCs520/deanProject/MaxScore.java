package com.itCs520.deanProject;/*
 *ClassName:MaxScore
 *Description:
 *@Author:deanzhou
 *@Date:2023/5/6 18:18
 */

public class MaxScore {

    public static void main(String[] args) {
        int[] arr=new int[]{5,200,2,3,4};
        int sum=0;
        for (int i :arr) {
            sum+=i;
        }
        int p1 = maxSocre(arr,0, arr.length-1);
        int p2 = sum-p1;
        System.out.println(p1> sum-p2);
    }
    static int maxSocre(int[] arr,int l,int r){
        if (l == r){ //只剩下一个数字
            return arr[l];
        }
        int sLeft = 0;
        int sRight =0;
        if (r-l ==1){ // 只剩下 2个数字
            sLeft = arr[l];
            sRight = arr[r];
        }
        if (r-l>=2){ //对手要留较小值给对方
            sLeft = arr[l] +Math.min(maxSocre(arr,l+2,r),maxSocre(arr,l+1,r-1));
            sRight = arr[r] +Math.min(maxSocre(arr,l+1,r-1),maxSocre(arr,l,r-2));
        }
        return Math.max(sLeft,sRight);
    }

    static int maxSocre1(int[] arr,int l,int r){
        if (l==r){
            return arr[l];
        }
        int sleft= arr[l]-maxSocre1(arr,l+1,r);
        int sRight=arr[r] -maxSocre1(arr,l,r-1);
        return Math.max(sleft,sRight);
    }

    //动态规划解法
    static boolean dp(int[] arr){
        int length = arr.length;
        int[][] dp= new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = arr[i];
        }
        for (int i=length-2;i>=0;i--){
            for (int j = i+1; j >length ; j++) {
                dp[i][j] = Math.max(arr[i]- dp[i+1][j],arr[j]-dp[i][j-1]);
            }
        }
        return dp[0][length-1]>=0;
    }

    static boolean dp2(int[] arr){
        int length = arr.length;
        int[] dp= new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = arr[i];
        }
        for (int i=length-2;i>=0;i--){
            for (int j = i+1; j >length ; j++) {
                dp[j] = Math.max(arr[i]- dp[j],arr[j]-dp[j-1]);
            }
        }
        return dp[length-1]>=0;
    }
}
