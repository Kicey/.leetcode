/*
 * @lc app=leetcode.cn id=1582 lang=java
 *
 * [1582] 二进制矩阵中的特殊位置
 */

// @lc code=start
class Solution {
    int[][] rowPrefix;
    int[][] colPrefix;
    int n, m;
    public int numSpecial(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        rowPrefix = new int[n][m];
        colPrefix = new int[m][n];
        for(int i = 0;i < n;++i){
            rowPrefix[i][0] = mat[i][0];
            for(int j = 1;j < m;++j){
                rowPrefix[i][j] = rowPrefix[i][j - 1] + mat[i][j];
            }
        }
        for(int j = 0;j < m;++j){
            colPrefix[0][j] = mat[0][j];
            for(int i = 1;i < n;++i){
                colPrefix[i][j] = colPrefix[i - 1][j] + mat[i][j];
            }
        }
        int ans = 0;
        for(int i = 0;i < n;++i){
            for(int j = 0;j < m;++j){
                if(mat[i][j] == 1){
                    if((j == 0 || rowPrefix[i][j - 1] == 0) && rowPrefix[i][m - 1] == 1){
                        if((i == 0 || colPrefix[i - 1][j] == 0) && colPrefix[n - 1][j] == 1){
                            ++ans;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

