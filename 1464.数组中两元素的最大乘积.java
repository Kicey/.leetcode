/*
 * @lc app=leetcode.cn id=1464 lang=java
 *
 * [1464] 数组中两元素的最大乘积
 */

// @lc code=start
class Solution {
    int max = Integer.MIN_VALUE + 1;
    int secondMax = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        for(int num: nums){
            if(num > max){
                secondMax = max;
                max = num;
            } else if(num > secondMax){
                secondMax = num;
            }
        }
        return (max - 1) * (secondMax - 1);
    }
}
// @lc code=end

