import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    char[][] board;
    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] block = new boolean[9][10];
    List<int[]> toBeFilled = new ArrayList<>(81);

    int Max_Index = 0;
    public void solveSudoku(char[][] board) {
        this.board = board;
        for(int i = 0;i < 9;++i){
            for(int j = 0;j < 10;++j){
                row[i][j] = col[i][j] = block[i][j] = false;
            }
        }
        for(int i = 0;i < 9;++i) {
            for(int j = 0;j < 9;++j){
                if(board[i][j] != '.'){
                    var num = Character.getNumericValue(board[i][j]);
                    row[i][num] = col[j][num] = block[i / 3 * 3 + j / 3][num] = true;
                } else {
                    toBeFilled.add(new int[]{i, j});
                }
            }
        }
        dfs(0);
    }

    private boolean dfs(int index) {
        Max_Index = Math.max(index, Max_Index);
        if(index == toBeFilled.size()){
            return true;
        }
        var pos = toBeFilled.get(index);
        var r = pos[0];
        var c = pos[1];
        var b = r / 3 * 3 + c / 3;
        for(int i = 1;i <= 9;++i){
            if(!row[r][i] && !col[c][i] && !block[b][i]){
                row[r][i] = col[c][i] = block[b][i] = true;
                if(dfs(index + 1)){
                    board[r][c] = Character.forDigit(i, 10);
                    return true;
                }
                row[r][i] = col[c][i] = block[b][i] = false;
            }
        }
        return false;
    }
}
// @lc code=end

