package com.itCs520.deanProject.LeetCode;/*
 *ClassName:ArrangeCoin
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/21 13:13
 */

public class ArrangeCoin {
    public static void main(String[] args) {
        System.out.println(arrangeCoin(10));
        System.out.println(arrangeCoin2(10));
        System.out.println(arrangeCoin3(10));
    }

    private static int arrangeCoin3(int i) {
        if (i == 0)
            return 0;

        return (int)sqrt(i, i);
    }
    private static double sqrt(double x,int n){
        double res = (x+(2*n-x)/x)/2;
        if (res ==x){
            return x;
        }else {
            return sqrt(res,n);
        }
    }

    private static int arrangeCoin2(int n) {
        int low=0, high=n;
        while (low <=high){
            int mid =(high - low)/2+low;
            //当前到mid这一行 所有的硬币个数
            int cost = ((mid+1)*mid)/2;
            if (cost ==n){
                return mid;
            }else if (cost > n){
                high = mid -1;
            }else {
                low = mid +1 ;
            }
        }
        return high;
    }

    private static int arrangeCoin(int n) {
        for (int j = 1; j <=n ; j++) {
                n=n-j;
                if (n<=j){
                    return j;
                }
        }
        return 0;
    }
}
