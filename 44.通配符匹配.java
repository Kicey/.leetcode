/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    String str;
    String pattern;
    int n, m;
    boolean[][] dp;

    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();
        dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // 匹配开头空字符串
        for(int i = 0;i < n;++i){
            dp[0][i + 1] = dp[0][i] && p.charAt(i) == '*';
        }
        for(int i = 0;i < m;++i){
            for(int j = 0;j < n;++j){
                if (p.charAt(j) == '*'){
                    dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
                } else if(p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)){
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

