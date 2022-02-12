import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        // 尽可能多地将负值转换为正值，去消耗k
        for(;k > 0 && i < nums.length && nums[i] < 0;++i, --k){
            nums[i] *= -1;
        }
        // k被耗尽
        if((i < nums.length && nums[i] == 0) || k % 2 == 0){
            return Arrays.stream(nums).parallel().sum();
        }
        Arrays.sort(nums);
        nums[0] *= -1;
        return Arrays.stream(nums).parallel().sum();
    }
}
// @lc code=end

