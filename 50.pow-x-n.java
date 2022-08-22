/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        boolean negative = false;
        boolean extraOperation = false;
        if(n < 0) {
            negative = true;
            if(n == Integer.MIN_VALUE){
                extraOperation = true;
                n += 1;
            }
            n = -n;
        }
        double base = x;
        double ret = 1;
        while(n > 0){
            if((n & 1) == 1 && !extraOperation){
                ret *= base;
            }
            base *= base;
            n >>= 1;
        }
        if(extraOperation){
            ret = base * base;
        }
        if(negative){
            return 1 / ret;
        }
        return ret;
    }
}
// @lc code=end

