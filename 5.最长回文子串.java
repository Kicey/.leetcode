import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    int n;
    int ans = 1;
    int i = 0,j = 1;
    boolean [][] dp;
    String s;
    public String longestPalindrome(String s) {
        n = s.length();
        this.s = s;
        dp = new boolean[n][n + 1];
        for(int i = 0;i < dp.length;++i) Arrays.fill(dp[i], false);
        dpIf();
        return s.substring(i, j);
    }

    public void dpIf(){
        for(int i = 0;i < n;++i){
            dp[i][i + 1] = true;
        }
        for(int i = 0;i + 1 < n;++i){
            if(dp[i][i + 2] = s.charAt(i) == s.charAt(i + 1)){
                ans = 2;
                this.i = i;
                j = i + 2;
            }
        }
        for(int len = 3;len <= n;++len){
            for(int left = 0;left < n - 1;++left){
                int right = left + len;
                if(right > n) break;
                dp[left][right] = dp[left + 1][right - 1] && s.charAt(left) == s.charAt(right - 1);
                if(len > ans && dp[left][right]){
                    ans = len;
                    i = left;
                    j = right;
                } 
            }
        }
    }
}
// @lc code=end

