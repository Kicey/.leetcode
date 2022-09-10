/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字 1 的个数
 */

// @lc code=start
class Solution {
    public int countDigitOne(int n) {
        int cnt = 0;
        int radix = 1;
        while(n >= radix){
            int leftNum = n / (radix * 10) + 1;
            if((n / radix) % 10 == 1){
                int rightRemain = n % radix + 1;
                cnt += (leftNum - 1) * radix + rightRemain;
            } else if((n / radix % 10 == 0)) {
                cnt += (leftNum - 1) * radix;
            } else {
                cnt += leftNum * radix;
            }
            radix *= 10;
        }
        return cnt;
    }
}
// @lc code=end