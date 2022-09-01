import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 */

// @lc code=start
class Solution {
    String s;
    int n;
    int[][] palindromeLen;
    int[] minTimes;
    public int minCut(String s) {
        this.s = s;
        n = s.length();
        palindromeLen = new int[n + 1][n + 1];
        minTimes = new int[n];
        Arrays.fill(minTimes, Integer.MAX_VALUE / 4);
        minTimes[0] = 0;
        for(int i = 1;i < n;++i){
            for(int j = 1;j <= i;++j){
                if(isPalindrome(j, i) > 0){
                    minTimes[i] = Math.min(minTimes[i], minTimes[j - 1] + 1);
                }
            }
            if(isPalindrome(0, i) > 0){
                minTimes[i] = 0;
            }
        }
        return minTimes[n - 1];
    }

    private int isPalindrome(int i, int j){
        if(s.charAt(i) != s.charAt(j)){
            return palindromeLen[i][j] = -1;
        }
        if(i == j){
            return palindromeLen[i][j] = 1;
        }
        if(i > j){
            return 0;
        }
        if(palindromeLen[i][j] != 0) return palindromeLen[i][j];
        if(isPalindrome(i + 1, j - 1) < 0) return -1;
        return palindromeLen[i][j] = isPalindrome(i + 1, j - 1) + 2;
    }
}
// @lc code=end

