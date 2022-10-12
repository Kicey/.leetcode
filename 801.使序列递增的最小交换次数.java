/*
 * @lc app=leetcode.cn id=801 lang=java
 *
 * [801] 使序列递增的最小交换次数
 */

// @lc code=start
class Solution {
    int n;
    int[][] dp;
    public int minSwap(int[] nums1, int[] nums2) {
        n = nums1.length;
        dp = new int[n][2];
        dp[0][0] = 0; dp[0][1] = 1;
        for(int i = 1;i < n;++i){
            boolean cond1 = nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1];
            boolean cond2 = nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1];
            // cond1, cond2 不能同为 false
            // 当前索引位置不能交换，那么交换情况保持同步
            if(cond1 && !cond2){
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
                continue;
            }
            // 当前索引位置必须交换，那么交换情况需要相反
            if(!cond1 && cond2){
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + 1;
                continue;
            }
            // 当前索引可以交换或不交换，那么选择更少的交换情况
            int min = Math.min(dp[i - 1][0], dp[i - 1][1]);
            dp[i][0] = min; // 同步交换情况
            dp[i][1] = min + 1; // 同步
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
// @lc code=end

