import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2039 lang=java
 *
 * [2039] 网络空闲的时刻
 */

// @lc code=start
class Solution {

    int[] distanceFromRoot;
    List<List<Integer>> graph = new ArrayList<>();
    int n;

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        n = patience.length;
        for(int i = 0;i < n;++i){
            graph.add(new ArrayList<>());
        }
        distanceFromRoot = new int[n];
        Arrays.fill(distanceFromRoot, Integer.MAX_VALUE);
        distanceFromRoot[0] = 0;
        for (int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        resolveDistanceFromRoot();
        for(int i = 0;i < n;++i){
            distanceFromRoot[i] *= 2;
        }
        int ans = 0;
        for(int i = 1;i < n;++i){
            ans = Math.max(ans, distanceFromRoot[i] + ((distanceFromRoot[i] - 1) / patience[i]) * patience[i] + 1);
        }
        return ans;
    }

    public void resolveDistanceFromRoot(){
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(queue.size()!=0){
            int cur = queue.poll();
            for (int i: graph.get(cur)) {
                if (!visited[i]) {
                    distanceFromRoot[i] = distanceFromRoot[cur] + 1;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
// @lc code=end

