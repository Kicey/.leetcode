import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    int n;
    int[] dp;
    public int maxSubArray(int[] nums) {
        n = nums.length;
        if(n == 0) return 0;
        dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1;i < n;++i){
            if(dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
// @lc code=end

