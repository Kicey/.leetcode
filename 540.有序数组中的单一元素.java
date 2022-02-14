/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
class Solution {
    /**
     * 1. get mid
     * 2. check if the one on the of mid equals mid
     * * yes: answer locate the right arrange
     * * no: answer locate the right arrange
     * 
     * until:
     * 
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int left = 0; // always even
        int right = nums.length; // always odd
        int mid; // always on the right center
        while (right - left > 1) {
            mid = (left + right) / 2;
            // System.out.println(mid);
            if (mid % 2 == 1) {
                if (nums[mid - 1] == nums[mid])
                    left = mid + 1;
                else
                    right = mid;
            } else {
                if (nums[mid + 1] == nums[mid]) left = mid + 2;
                else right = mid + 1;
            }
        }
        return nums[left];
    }
}
// @lc code=end
