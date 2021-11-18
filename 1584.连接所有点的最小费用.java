import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1584 lang=java
 *
 * [1584] 连接所有点的最小费用
 */

// @lc code=start
class Solution {
    static class Edge implements Comparable<Edge>{
        int from, to, cost;
        Edge(int from, int to, int cast){
            this.from = from;
            this.to = to;
            this.cost = cast;
        }

        @Override
        public int compareTo(Edge e){
            return cost - e.cost;
        }
    }
    Set<Integer> set = new HashSet<>();
    Edge[][] edges;
    PriorityQueue<Edge> edgesInOrder = new PriorityQueue<>();
    int n;
    int ans = 0;
    public int minCostConnectPoints(int[][] points) {
        n = points.length;

        edges = new Edge[n][n];
        for(int i = 0;i < n;++i){
            for(int j = i + 1;j < n;++j){
                int dx = Math.abs(points[i][0] - points[j][0]);
                int dy = Math.abs(points[i][1] - points[j][1]);
                edges[j][i] = new Edge(j, i, dx + dy);
                edges[i][j] = new Edge(i, j, dx + dy);
            }
        }

        set.add(0);
        for(int i = 1;i < n;++i){
            edgesInOrder.add(edges[0][i]);
        }

        while(set.size() < n){
            Edge edge = edgesInOrder.poll();
            if(!set.contains(edge.to)){
                ans += edge.cost;
                set.add(edge.to);
                for(int i = 0;i < n;++i){
                    if(i == edge.to) continue;
                    edgesInOrder.add(edges[edge.to][i]);
                }
            }
        }

        return ans;
    }
}
// @lc code=end

