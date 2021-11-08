/*
 * @lc app=leetcode.cn id=453 lang=java
 *
 * [453] 最小操作次数使数组元素相等
 */

// @lc code=start
class Solution {
    public int minMoves(int[] nums) {
        long sum = 0;
        long min = Long.MAX_VALUE;
        for(int i = 0;i < nums.length;++i){
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        return (int)(sum - min * nums.length);
    }
}
// @lc code=end

