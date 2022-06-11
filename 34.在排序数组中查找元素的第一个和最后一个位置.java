import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = binarySearchLowerBound(nums, target);
        if (l < 0 || l >= nums.length || nums[l] != target) l = -1;
        int r = binarySearchUpperBound(nums, target);
        if (r < 0 || r >= nums.length || nums[r] != target) r = -1;
        return new int[]{l, r};
    }
    private int binarySearchLowerBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(r - l > 1) {
            int mid = (l + r) / 2;
            int midValue = nums[mid];
            if (target == midValue && nums[mid - 1] < target) {
                if (mid - 1 == l) {
                    l = mid;
                    continue;
                }
                r = mid + 1;
            } else if (midValue < target){
                l = mid;
            } else {
                r = mid;
            } 
        }
        return l;
    }

    private int binarySearchUpperBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(r - l > 1) {
            int mid = (l + r) / 2;
            int midValue = nums[mid];
            if (target >= midValue) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r - 1;
    }
}
// @lc code=end

