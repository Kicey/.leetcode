/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    int n = 0;
    public int trap(int[] height) {
        n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for(int i = 1;i < n;++i){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for(int i = n - 2;i >= 0;--i){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int ans = 0;
        for(int i = 0;i < n;++i){
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
// @lc code=end

