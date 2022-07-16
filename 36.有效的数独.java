/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] block = new boolean[9][10];
    public boolean isValidSudoku(char[][] board) {
        boolean[][] groups = new boolean[3][];
        for(int i = 0;i < 9;++i){
            for(int j = 0;j < 9;++j){
                char c = board[i][j];
                if(c == '.') continue;
                int num = Character.getNumericValue(c);
                groups[0] = row[i];
                groups[1] = col[j];
                groups[2] = block[(i / 3) * 3 + j / 3];
                for(int k = 0;k < 3;++k) {
                    if(groups[k][num]) {
                        return false;
                    }
                    groups[k][num] = true;
                }
            }
        }
        return true;
    }
}
// @lc code=end

