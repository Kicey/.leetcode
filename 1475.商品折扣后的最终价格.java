import java.util.TreeMap;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=1475 lang=java
 *
 * [1475] 商品折扣后的最终价格
 */

// @lc code=start
class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        for(int i = 0;i < n;++i){
            int price = prices[i];
            for(int j = i + 1;j < n;++j){
                if(prices[j] <= price){
                    price -= prices[j];
                    break;
                }
            }
            ans[i] = price;
        }
        return ans;
    }
}
// @lc code=end

