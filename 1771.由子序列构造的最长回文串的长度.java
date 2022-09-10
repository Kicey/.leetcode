/*
 * @lc app=leetcode.cn id=1771 lang=java
 *
 * [1771] 由子序列构造的最长回文串的长度
 */
/*
 * "c"
 * "fcecf"
 */
// @lc code=start
class Solution {
    public int longestPalindrome(String word1, String word2) {
        int ni = word1.length();
        String merged = word1 + word2;
        int n = merged.length();
        int[][] dp = new int[n][n];
        int ans = 0;
        for(int i = n - 1;i >= 0;--i){
            dp[i][i] = 1;
            for(int j = i + 1;j < n;++j){
                int matchedLen = 0;
                if(merged.charAt(i) == merged.charAt(j)){
                    matchedLen = dp[i + 1][j - 1] + 2;
                    if(i < ni && j >= ni) {
                        ans = Math.max(ans, matchedLen);
                    }
                }
                dp[i][j] = Math.max(Math.max(dp[i + 1][j], dp[i][j - 1]), matchedLen);
            }
        }
        return ans;
    }
}
// @lc code=end

