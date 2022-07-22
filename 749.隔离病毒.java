import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
/*
 * @lc app=leetcode.cn id=749 lang=java
 *
 * [749] 隔离病毒
 */
import java.util.Queue;
import java.util.Set;

// @lc code=start
class Solution {
    int[][] isInfected;
    int n, m;
    final int[] nx = new int[]{-1, 0, 0, 1};
    final int[] ny = new int[]{0, -1, 1, 0};
    int ans;

    public int containVirus(int[][] isInfected) {
        this.isInfected = isInfected;
        n = isInfected.length;
        m = isInfected[0].length;
        while(true) {
            int edgeNum = scanAll();
            if(edgeNum == 0) {
                break;
            }
            ans += edgeNum;
        }
        return ans;
    }

    private int scanAll() {
        List<Set<Integer>> blocks = new ArrayList<>();;
        List<Set<Integer>> toBeInfectedInBlocks = new ArrayList<>();
        boolean[][] vis = new boolean[n][m];
        int maxToBeInfected = 0;
        int edgeNum = 0;
        for(int i = 0;i < n;++i) {
            for(int j = 0;j < m;++j) {
                if(isInfected[i][j] == 1 && !vis[i][j]) {
                    Set<Integer> block = new HashSet<>();
                    Set<Integer> toBeInfected = new HashSet<>();
                    int blockEdgeNum = getBlockEdgeNum(block, toBeInfected, i, j, vis);
                    if(toBeInfected.size() > maxToBeInfected) {
                        maxToBeInfected = toBeInfected.size();
                        edgeNum = blockEdgeNum;
                    }
                    blocks.add(block);
                    toBeInfectedInBlocks.add(toBeInfected);
                }
            }
        }
        for(int i = 0;i < toBeInfectedInBlocks.size(); ++i) {
            if(toBeInfectedInBlocks.get(i).size() == maxToBeInfected) {
                for(int point: blocks.get(i)) {
                    int x = point / m, y = point % m;
                    isInfected[x][y] = -1;
                }
            } else {
                for(int point: toBeInfectedInBlocks.get(i)) {
                    int x = point / m, y = point % m;
                    isInfected[x][y] = 1;
                }
            }
        }
        return edgeNum;
    }

    private int getBlockEdgeNum(Set<Integer> block, Set<Integer> toBeInfected, int x , int y, boolean[][] vis) {
        int edgeNum = 0;
        vis[x][y] = true;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        block.add(x * m + y);
        while(!que.isEmpty()) {
            int[] curPoint = que.poll();
            for(int i = 0 ;i < 4;++i) {
                int[] next = new int[] {curPoint[0] + nx[i], curPoint[1] + ny[i]};
                if(next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m || vis[next[0]][next[1]]) {
                    continue;
                }
                if(isInfected[next[0]][next[1]] == 1) {
                    vis[next[0]][next[1]] = true;
                    que.add(next);
                    block.add(next[0] * m + next[1]);
                } else if(isInfected[next[0]][next[1]] == 0) {
                    ++edgeNum;
                    toBeInfected.add(next[0] * m + next[1]);
                }
            }
        }
        return edgeNum;
    }
}
// @lc code=end

