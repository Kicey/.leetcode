/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == Integer.MIN_VALUE) {
                return 1;
            }
            int _divisor = divisor < 0 ? -divisor : divisor;
            int shiftX = 0;
            while (_divisor > 0) {
                if (_divisor == 1) {
                    return dividend >> shiftX;
                }
                if ((_divisor & 1) == 1) {
                    break;
                }
                _divisor >>= 1;
                shiftX++;
            }
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }
        if (divisor == Integer.MIN_VALUE) {
            if(dividend == Integer.MIN_VALUE){
                return 1;
            }
            return 0;
        }
        boolean sign = false;
        int absValue = 0;
        if (((dividend ^ divisor) & 0x80000000) == 0x80000000) {
            sign = true;
        }
        if (dividend < 0) {
            if (dividend == Integer.MIN_VALUE) {
                dividend += 1;
            }
            dividend = -dividend;
        }
        if (divisor < 0) {
            if (divisor == Integer.MIN_VALUE) {
                divisor += 1;
            }
            divisor = -divisor;
        }
        int curDivisor = divisor;
        int x = 1;
        int curDividend = dividend;
        while(curDividend >= curDivisor && curDivisor < 0x40000000) {
            curDividend -= curDivisor;
            absValue += x;
            curDivisor += curDivisor;
            x += x;
        }
        while(curDivisor >= divisor) {
            if (curDividend >= curDivisor) {
                curDividend -= curDivisor;
                absValue += x;
            }
            curDivisor >>= 1;
            x >>= 1;
        }
        if (sign) {
            return -absValue;
        }
        return absValue;
    }
}
// @lc code=end

