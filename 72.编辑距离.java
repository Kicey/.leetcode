/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    int n, m;
    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0;i < n + 1;++i){
            dp[i][0] = i;
        }
        for(int i = 0;i < m + 1;++i){
            dp[0][i] = i;
        }
        for(int i = 1; i < n + 1;++i){
            for(int j = 1;j < m + 1;++j){
                int bothAdd = dp[i - 1][j - 1];
                if(word1.charAt(i - 1) != word2.charAt(j - 1)){
                    ++bothAdd;
                }
                dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, bothAdd));
            }
        }
        return dp[n][m];
    }
}
// @lc code=end

