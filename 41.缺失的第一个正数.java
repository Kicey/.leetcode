/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {

    int N;

    public int firstMissingPositive(int[] nums) {
        N = nums.length;
        for (int i = 0; i < N; ++i) {
            if (nums[i] <= 0) nums[i] = N + 1;
        }
        for (int i = 0; i < N; ++i) {
            int abs = Math.abs(nums[i]);
            if(abs <= N) nums[abs - 1] = Math.abs(nums[abs - 1]) * -1;
        }
        for (int i = 0; i < N; ++i) {
            if (nums[i] >= 0)
                return i + 1;
        }
        return N + 1;
    }
}
// @lc code=end
