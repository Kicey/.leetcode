/*
 * @lc app=leetcode.cn id=11 lang=java
 * 
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ans = (j - i) * Math.min(height[i], height[j]);
        while(i < j - 1){
            if(height[i] < height[j]){
                ++i;
            }else{
                --j;
            }
            ans = Math.max(ans, (j - i) * Math.min(height[i], height[j]));
        }
        return ans;
    }
}
// @lc code=end

