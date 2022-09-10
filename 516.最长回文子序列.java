import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 */

// @lc code=start
class Solution {
    int n;
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        n = s.length();
        dp = new int[n + 1][n + 1];
        Arrays.fill(dp[0], 0);
        for(int i = 0;i < n + 1;++i){
            dp[i][0] = 0;
        }
        for(int i = 1;i < n + 1;++i){
            for(int j = 1;j < n + 1;++j){
                int matchLen = 0;
                if(s.charAt(i - 1) == reversed.charAt(j - 1)){
                    matchLen = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), matchLen);
            }
        }
        return dp[n][n];
    }
}
// @lc code=end

