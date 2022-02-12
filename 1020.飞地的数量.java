import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 */

// @lc code=start
class Solution {

    static final int[] dx = new int[] { -1, 0, 0, 1 };
    static final int[] dy = new int[] { 0, -1, 1, 0 };

    int m, n;
    int[][] grid;
    boolean[][] vis;
    Queue<int[]> queue;
    int all;
    int accessible;

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        vis = new boolean[m][n];
        for (boolean[] row : vis) {
            Arrays.fill(row, false);
        }
        queue = new LinkedList<>();
        accessible = 0;
        countTotal();
        initQueue();
        bfsWithQueue();
        return all - accessible;
    }

    private void countTotal() {
        all = 0;
        for (int[] row : grid) {
            for (int e : row) {
                all += e;
            }
        }
    }

    private void initQueue() {
        int[] y = new int[] { -1, m };
        int[] x = new int[] { -1, n };
        for (int row : y) {
            for (int j = 0; j < n; ++j) {
                queue.add(new int[] { row, j });
            }
        }
        for (int col : x) {
            for (int i = 0; i < m; ++i) {
                queue.add(new int[] { i, col });
            }
        }
    }

    private void bfsWithQueue() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (ny >= 0 && ny < m && nx >= 0 && nx < n && !vis[ny][nx] && grid[ny][nx] == 1) {
                    ++accessible;
                    vis[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }

}
// @lc code=end
