/*
 * @lc app=leetcode.cn id=1422 lang=java
 *
 * [1422] 分割字符串的最大得分
 */

// @lc code=start
class Solution {
    int n;
    public int maxScore(String s) {
        n = s.length();
        int cnt1, cnt0, num0, num1;
        cnt0 = cnt1 = num0 = 0;
        for(char c: s.toCharArray()){
            if(c == '0'){
                ++num0;
            }
        }
        num1 = n - num0;
        int maxScore = Integer.MIN_VALUE;
        for(int i = 0;i < n - 1; ++i){
            char c = s.charAt(i);
            if(c == '0'){
                ++cnt0;
            }else{
                ++cnt1;
            }
            int score = cnt0 + (num1 - cnt1);
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
}
// @lc code=end

