import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=629 lang=java
 *
 * [629] K个逆序对数组
 */

// @lc code=start
class Solution {
    private final int mod = (int)1e9 + 7;
    int[][] dp;         // dp[i][j] i个数字组成的序列中，最多j个逆序对的序列的个数
    int[][] preSum;     // preSum[i][j] dp[i][0,j]的前缀和
    public int kInversePairs(int n, int k) {
        dp = new int[n + 1][k + 1];
        preSum = new int[n + 1][k + 1];
        dp[1][0] = 1;
        Arrays.fill(preSum[1], 1);
        // 遍历数组范围
        for(int i = 2;i <= n;++i){
            // 遍历逆序对数量
            for(int j = 0;j <= k;++j){
                // 这里这个比较的意义在于使j - (i - 1) - 1，及由除了i这个数字外的数字组成的逆序对需要大于等于0
                // 举个例子，当只有3个逆序对，而当前数组的大小为5时，那么将5放在索引为0处，除5之外的数组就需要产生-1个逆序对，这是不可能的
                dp[i][j] = j < i ? preSum[i - 1][j] : (preSum[i - 1][j] - preSum[i - 1][j - (i - 1) -1] + mod) % mod;
                preSum[i][j] = j == 0 ? dp[i][j] : (preSum[i][j - 1] + dp[i][j]) % mod; 
            }
        }
        return dp[n][k];
    }
}
// @lc code=end

