import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1260 lang=java
 *
 * [1260] 二维网格迁移
 */

// @lc code=start
class Solution {
    int[] arr;
    int n, m;
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;
        int cnt = n * m;

        List<List<Integer>> ret = new ArrayList<>(n);
        List<Integer> cur = new ArrayList<>(m);
        int added = 0;
        for(int i = (cnt - k % cnt) ;added < cnt;++i){
            if(i == cnt) {
                i = 0;
            }
            cur.add(grid[i / m][i % m]);
            added++;
            if(cur.size() == m) {
                ret.add(cur);
                cur = new ArrayList<>(m);
            }
        }
        return ret;
    }
}
// @lc code=end

