import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=808 lang=java
 *
 * [808] 分汤
 */

// @lc code=start
class Solution {

    private Integer pointShiftX[] = new Integer[]{4, 3, 2, 1};
    private Integer pointShiftY[] = new Integer[]{0, 1, 2, 3};

    // 动态规划，dp[i][j]: 已经分配 i A 汤，和 j B 汤的概率，最终结果是 dp[n][x] (x != 0) 和 dp[n][n] / 2 概率之和
    // n = (n + 24) / 25
    // dp[i][j] = (dp[i - 4][j] + dp[i - 3][j - 1] + dp[i - 2][j - 2] + dp[i - 1][j - 3]) * 0.25;
    // dp[0][x] A 汤未分配，dp[x][0] B 汤未分配
    public double soupServings(int n) {
        if (n > 10000){
            return 1d;
        }
        // 以 25 离散化，如果 n 不足 25 当作 25
        int complement = n % 25 == 0 ? 0: 1;
        n = n / 25 + complement;
        // System.out.printf("n: %d\n", n);

        // dp[i][j]: 剩余 i A 汤，j B 汤时的结果
        // dp[i][j] = (dp[i + 4][j] + dp[i +3][j + 1] + dp[i + 2][j + 2] + dp[i + 1][j + 3]) / 4;
        double[][] dp = new double[n + 1][n + 1];
        for(int i = 0;i <= n;++i){
            for(int j = 0;j <= n;++j){
                dp[i][j] = 0d;
            }
        }
        dp[n][n] = 1d;
        // for(int i = 0;i <= n;++i){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        for(int i = n;i > 0;--i){
            for(int j = n;j > 0;--j){
                for(int k = 0;k < 4;++k){
                    int nx = i - pointShiftX[k];
                    int ny = j - pointShiftY[k];
                    nx = nx < 0? 0: nx;
                    ny = ny < 0? 0: ny;
                    dp[nx][ny] += dp[i][j] / 4;
                }
            }
        }
        // System.out.println("processed");
        // for(int i = 0;i <= n;++i){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        Double ret = IntStream.range(1, n + 1).mapToDouble(i -> dp[0][i]).reduce(0d, Double::sum);
        ret += dp[0][0] / 2;
        return ret;
    }

}
// @lc code=end

