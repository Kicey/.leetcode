/*
 * @lc app=leetcode.cn id=495 lang=java
 *
 * [495] 提莫攻击
 */

// @lc code=start
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ret = 0;
        int start = timeSeries[0], end = start + duration;
        for(int i = 1;i < timeSeries.length;++i){
            int moment = timeSeries[i];
            if(moment <= end){
                end = moment + duration;
            }else{
                ret += end - start;
                start = moment;
                end = start + duration;
            }
        }
        ret += end - start;
        return ret;
    }
}
// @lc code=end

