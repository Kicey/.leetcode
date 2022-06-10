/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int smallNumberIndex = -1;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                smallNumberIndex = i;
                break;
            }
        }
        int biggerNumberIndex = -1;
        for (int i = nums.length - 1; i > smallNumberIndex && smallNumberIndex >= 0; --i) {
            if (nums[i] > nums[smallNumberIndex]) {
                biggerNumberIndex = i;
                break;
            }
        }
        int temp = 0;
        if (smallNumberIndex != -1) {
            temp = nums[smallNumberIndex];
            nums[smallNumberIndex] = nums[biggerNumberIndex];
            nums[biggerNumberIndex] = temp;
        }
        for (int i = smallNumberIndex + 1, j = nums.length - 1; i < j; ++i, --j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
// @lc code=end
