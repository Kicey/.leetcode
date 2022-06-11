/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(r - l > 1) {
            int mid = (l + r) / 2;
            int midValue = nums[mid];
            if (target < midValue) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return nums[l] < target ? r : l;
    }
}
// @lc code=end

