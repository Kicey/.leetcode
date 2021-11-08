import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=407 lang=java
 *
 * [407] 接雨水 II
 */

// @lc code=start
class Solution {
    int n,m;
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};
    boolean[][] vis;

    public int trapRainWater(int[][] heightMap) {
        int ret = 0;

        m = heightMap.length;
        n = heightMap[0].length;
        vis = new boolean[m][n];
        for(int i = 0;i < m;++i){
            Arrays.fill(vis[i], false);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((h0, h1) -> h0[2] - h1[2]);
        for(int i = 0;i < m;++i){
            for(int j = 0;j < n;++j){
                if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
                    pq.add(new int[]{i, j, heightMap[i][j]});
                    vis[i][j] = true;
                }
            }
        }

        int[] curOld;
        int y = 0, x = 0;
        while(!pq.isEmpty()){
            curOld = pq.poll();
            for(int i = 0;i < 4;++i){
                y = curOld[0] + dy[i];
                x = curOld[1] + dx[i];
                if(! (y >= 0 && y < m && x >= 0 && x < n && !vis[y][x])) continue;
                vis[y][x] = true;
                ret += curOld[2] > heightMap[y][x]? curOld[2] - heightMap[y][x] : 0;
                pq.add(new int[]{y, x, Math.max(curOld[2], heightMap[y][x])});
            }
        }
        return ret;
    }
}
// @lc code=end

