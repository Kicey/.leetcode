/*
 * @lc app=leetcode.cn id=458 lang=java
 *
 * [458] 可怜的小猪
 */

// @lc code=start
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int k = minutesToTest / minutesToDie;
        int count = 0;
        buckets -= 1;
        for(;buckets > 0;++count){
            buckets /= k + 1;
        }
        return count;
    }
}
// @lc code=end

