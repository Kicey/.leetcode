/*
 * @lc app=leetcode.cn id=688 lang=java
 *
 * [688] 骑士在棋盘上的概率
 */

// @lc code=start
class Solution {

    int n, k;

    double p = 1;

    int[][] next = new int[][]{
        {-2, 1},
        {-1, 2},
        {1, 2},
        {2, 1},
        {2, -1},
        {1, -2},
        {-1, -2},
        {-2, -1}
    };
    
    double[][][] dp;

    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[k+1][n][n];
        for(int i = 0;i < n;++i){
            for(int j = 0;j < n;++j){
                dp[0][i][j] = 1;
            }
        }

        for(int remainingStep = 1; remainingStep <= k;++remainingStep) {
            for(int i = 0;i < n;++i){
                for(int j = 0;j < n;++j){
                    int nrow, ncol;
                    for(int direct = 0; direct < 8;++direct){
                        nrow = i + next[direct][0];
                        ncol = j + next[direct][1];
                        if(nrow < 0 || nrow >= n || ncol < 0 || ncol >= n) continue;
                        dp[remainingStep][nrow][ncol] += dp[remainingStep - 1][i][j] / 8;
                    }
                }
            }
        }
        return dp[k][row][column];
    }
}
// @lc code=end

