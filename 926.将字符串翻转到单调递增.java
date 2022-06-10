/*
 * @lc app=leetcode.cn id=926 lang=java
 *
 * [926] 将字符串翻转到单调递增
 */

// @lc code=start
class Solution {
    public int minFlipsMonoIncr(String s) {
        int[] num = new int[s.length()];
        if(s.charAt(0) == '0') num[0] = 1;
        else num[0] = 0;
        for (int i = 1;i < s.length();++i) {
            if (s.charAt(i) == '0') num[i] = num[i - 1] + 1;
            else num[i] = num[i - 1];
        }
        int allZero = num[s.length() - 1];
        int res = Math.min(s.length() - allZero, allZero);
        for (int i = 1;i < s.length();++i) {
            res = Math.min(res, (i - num[i - 1]) + allZero - num[i - 1]);
        }
        return res;
    }
}
// @lc code=end

