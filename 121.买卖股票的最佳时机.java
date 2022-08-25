/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    int n;
    int[] preMin;
    public int maxProfit(int[] prices) {
        n = prices.length;
        preMin = new int[n];
        preMin[0] = prices[0];
        for(int i = 1;i < n;++i){
            preMin[i] = Math.min(preMin[i - 1], prices[i]);
        }
        int ans = 0;
        for(int i = 1;i < n;++i){
            ans = Math.max(ans, prices[i] - preMin[i]);
        }
        return ans;
    }
}
// @lc code=end

