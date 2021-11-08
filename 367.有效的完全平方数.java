/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int x0 = num;
        int x1 = 0;
        while(true){
            x1 = (x0 + num / x0) / 2;
            if(x0 - x1 < 1e-6) break;
            x0 = x1;
        }
        int x = (int) x1;
        return x * x == num;
    }
}
// @lc code=end

