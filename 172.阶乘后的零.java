/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        while(n > 0){
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
// @lc code=end

