/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    int n;
    public int maxProfit(int[] prices) {
        n = prices.length;
        int priceWhenBuy = prices[0];
        int ans = 0;
        for(int i = 1;i < n;++i){
            if(i != n - 1 && prices[i] >= prices[i - 1]){
                continue;
            } else if(i != n - 1 || prices[i] < prices[i - 1]) {
                ans += prices[i - 1] - priceWhenBuy;
                priceWhenBuy = prices[i];
            } else {
                ans += prices[i] - priceWhenBuy;
            }
        }
        return ans;
    }
}
// @lc code=end

