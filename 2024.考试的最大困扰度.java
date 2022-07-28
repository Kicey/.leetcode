/*
 * @lc app=leetcode.cn id=2024 lang=java
 *
 * [2024] 考试的最大困扰度
 */

// @lc code=start
class Solution {

    String str;
    int n, k;

    public int maxConsecutiveAnswers(String answerKey, int k) {
        str = answerKey;
        this.n = answerKey.length();
        this.k = k;
        return Math.max(getWindowLength('T'), getWindowLength('F'));
    }

    private int getWindowLength(char c){
        int maxLenth = 0;
        int cnt = 0;
        for(int l = 0, r = 0; r < n;++r){
            if(str.charAt(r) == c) ++cnt;
            while(cnt > k){
                if(str.charAt(l) == c) --cnt;
                ++l;
            }
            maxLenth = Math.max(maxLenth, r - l + 1);
        }
        return maxLenth;
    }
}
// @lc code=end

