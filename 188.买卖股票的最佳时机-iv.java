/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    int[] states = new int[200];
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || k == 0) return 0;
        for(int i = 0;i < 2 * k;i += 2){
            states[i] = - prices[0];
        }
        for(int i = 1;i < prices.length;++i){
            states[0] = Math.max(states[0], - prices[i]);
            for(int j = 1;j < 2 * k;++j){
                if(j % 2 == 0){
                    states[j] = Math.max(states[j], states[j - 1] - prices[i]);
                } else {
                    states[j] = Math.max(states[j], states[j - 1] + prices[i]);
                }
            }
        }
        int ans = 0;
        for(int i = 1;i < 2 * k;i += 2){
            ans = Math.max(ans, states[i]);
        }
        return ans;
    }
}
// @lc code=end

