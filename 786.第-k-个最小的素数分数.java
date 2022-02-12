/*
 * @lc app=leetcode.cn id=786 lang=java
 *
 * [786] 第 K 个最小的素数分数
 */

// @lc code=start
class Solution {
    
    double eps = 1e-8;
    int[] arr;
    int n;
    int a, b;
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        this.n = arr.length;
        this.arr = arr;
        // 基础二分答案部分
        double l = 0, r = 1, mid;
        while(r - l > eps){
            mid = (l + r) / 2;
            if(check(mid) >= k){
                r = mid;
            }else{
                l = mid;
            }
        }
        return new int[]{a, b}; 
    }

    // 返回小于当前答案的素数分数的个数
    int check(double curAns){
        int ret = 0;
        // 遍历整个数组，作为分母
        // 没有重复i是因为当分母增大，分子不变的情况下，分数值减小，也就是说当分母缩小，上一次分子的都能用作当前的分子
        for(int i = 0, j = 1; j < n; ++j){
            while(arr[i + 1] * 1.0 / arr[j] <= curAns) ++i;         // i试探右移
            if(arr[i] * 1.0 / arr[j] <= curAns) ret += i + 1;       // i是索引，还原到个数
            if(Math.abs(arr[i] * 1.0 / arr[j] - curAns) < eps){     // 
                a = arr[i];
                b = arr[j];
            }
        }
        return ret;
    }    
}
// @lc code=end

