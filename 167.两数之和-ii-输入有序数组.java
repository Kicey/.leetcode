/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        while(numbers[l] + numbers[r] != target){
            if(numbers[l] + numbers[r] < target){
                ++l;
            } else {
                --r;
            }
        }
        return new int[]{l + 1, r + 1};
    }
}
// @lc code=end

