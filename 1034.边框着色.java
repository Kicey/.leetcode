import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1034 lang=java
 *
 * [1034] 边框着色
 */

// @lc code=start
class Solution {
    int[][] grid;
    int[] dcol = new int[]{-1, 0, 0, 1};
    int[] drow = new int[]{0, -1, 1, 0};
    boolean[][] vis;
    int m, n;
    int color;
    int conColor;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.grid = grid;
        this.color = color;
        conColor = grid[row][col];
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        for(int i = 0;i < m;++i) Arrays.fill(vis[i], false);
        findBorderGrids(row, col);
        return grid;
    }

    private void findBorderGrids(int row, int col){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{row, col});
        vis[row][col] = true;
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int[] nxt;
            boolean ifBoard = false;
            for(int i = 0;i < 4;++i){
                int row_ = cur[0] + drow[i];
                int col_ = cur[1] + dcol[i];
                nxt = new int[]{row_, col_};
                if(row_ >= 0 && row_ < m && col_ >= 0 && col_ < n){
                    if(vis[row_][col_]) continue;
                    if(grid[row_][col_] == conColor){
                        que.add(nxt);
                        vis[row_][col_] = true;
                    }else{
                        ifBoard = true;
                    }
                }else{
                    ifBoard = true;
                }
            }
            if(ifBoard){
                grid[cur[0]][cur[1]] = color;
            }
        }
    }
}
// @lc code=end

