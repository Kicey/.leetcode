import java.math.BigInteger;

/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        BigInteger all = BigInteger.valueOf(m + n - 2);
        BigInteger min = BigInteger.valueOf(Math.min(m, n) - 1);
        return multiplyBound(all, all.subtract(min)).divide(multiplyBound(min, BigInteger.ZERO)).intValue();
    }

    private BigInteger multiplyBound(BigInteger a, BigInteger b){
        BigInteger product = BigInteger.valueOf(1);
        while(!a.equals(b)){
            product = product.multiply(a);
            a = a.subtract(BigInteger.ONE);
        }
        return product;
    }
}
// @lc code=end

