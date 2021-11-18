import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=375 lang=java
 *
 * [375] 猜数字大小 II
 */

// @lc code=start
class Solution {

    // 关键在于每次猜的数字
    // 数组将会以这个数字为界，分为两个数组，我们需要让这两个数组猜中数字的期望成本尽量相同，注意计算期望的时候应考虑我们使用的策略的情况
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        
        for(int i = n - 1;i > 0;--i){
            for(int j = i + 1;j <= n;++j){
                int minCost = Integer.MAX_VALUE;
                for(int k = i;k < j;++k){
                    int cost = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    minCost = Math.min(minCost, cost);
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][n];
    }
}
// @lc code=end

