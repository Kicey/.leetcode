/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    int n;
    public int jump(int[] nums) {
        n = nums.length;
        int curEnd = 0;
        int maxEnd = 0;
        int stepCnt = 0;
        for(int i = 0;i < n - 1;++i){
            maxEnd = Math.max(maxEnd, i + nums[i]);
            if(i == curEnd){
                curEnd = maxEnd;
                ++stepCnt;
            }
        }
        return stepCnt;
    }
}
// @lc code=end

