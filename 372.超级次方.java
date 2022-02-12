/*
 * @lc app=leetcode.cn id=372 lang=java
 *
 * [372] 超级次方
 */

// @lc code=start
class Solution {
    final int MOD = 1337;
    public int superPow(int a, int[] b) {
        int ret = 1;
        int standard = a % MOD;
        for(int i = b.length - 1;i >= 0;--i){
            int times = b[i];
            ret = ret * quickIntPow(standard, times) % MOD;
            standard = quickIntPow(standard, 10);
        }
        return ret;
    }

    int quickIntPow(int x, int y){
        int ret = 1;
        int standard = x % MOD;
        while(y > 0){
            if((y & 1) == 1){
                ret = standard * ret % MOD;
            }
            standard = standard * standard % MOD;
            y >>= 1;
        }
        return ret;
    }
}
// @lc code=end

