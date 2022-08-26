/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */

// @lc code=start
class Solution {
    int n,m;
    int[][] dp;
    public int numDistinct(String s, String t) {
        m = s.length() + 1;
        n = t.length() + 1;
        dp = new int[m][n];
        for(int i = 0;i < n;++i){
            dp[m - 1][i] = 0;
        }
        for(int i = 0;i < m;++i){
            dp[i][n - 1] = 1;
        }
        for(int i = m - 2;i >= 0;--i){
            for(int j = n - 2;j >= 0;--j){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] += dp[i + 1][j + 1];
                }
                dp[i][j] += dp[i + 1][j];
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

