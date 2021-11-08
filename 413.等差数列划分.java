/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0;
        int ret = 0;
        int number = 2;
        int dif = nums[1] - nums[0];
        for(int i = 2;i < nums.length;++i){
            if(nums[i] - nums[i- 1] == dif) ++ number;
            else{
                if(number >= 3){
                    ret += (number - 1) * (number - 2) / 2;
                }
                number = 2;
                dif = nums[i] - nums[i - 1];
            } 
        }
        if(number >= 3){
            ret += (number - 1) * (number - 2) / 2;
        }
        return ret;
    }
}
// @lc code=end

