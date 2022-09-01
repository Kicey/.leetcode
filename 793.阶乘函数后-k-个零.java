/*
 * @lc app=leetcode.cn id=793 lang=java
 *
 * [793] 阶乘函数后 K 个零
 */

// @lc code=start
class Solution {
    public int preimageSizeFZF(int k) {
        long lk = lowerBoundSearch(k);
        if(lk == -1){
            return 0;
        }
        long rk = lowerBoundSearch(k + 1);
        if(rk == -1){
            int cnt = 1;
            while(trailingZeroes(++lk) == k) ++cnt;
            return cnt;
        }
        return (int)(rk - lk);
    }

    private long lowerBoundSearch(int k){
        long l = 0, r = Long.MAX_VALUE;
        while(r - l > 1){
            long mid = (l + r) / 2;
            long zeroCnt = trailingZeroes(mid);
            if(zeroCnt <= k){
                l = mid;
            } else {
                r = mid;
            }
        }
        if(trailingZeroes(l) != k) return -1;
        while(l >= 1 && trailingZeroes(l - 1) == k) --l;
        return l;
    }

    private long trailingZeroes(long n) {
        long ans = 0;
        while(n > 0){
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
// @lc code=end

