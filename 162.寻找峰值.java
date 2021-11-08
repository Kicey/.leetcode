/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        int ret = -1;
        for(int i = 1;i < nums.length - 1;++i){
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
                ret = i;
                break;
            }
        }
        return ret;
    }
}
// @lc code=end

