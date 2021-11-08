import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=743 lang=java
 *
 * [743] 网络延迟时间
 */

// @lc code=start
class Solution {
    static class Node implements Comparable<Node>{
        int No;
        int d;

        Node(int No, int d){
            this.No = No;
            this.d = d;
        }

        @Override
        public int compareTo(Node node){
            return d - node.d;
        }
    }
    static class Edge{
        int to;
        int cost;
        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    List<List<Edge>> edges = new LinkedList<>();
    boolean[] used;
    int[] d;
    PriorityQueue<Node> nodesInOrder = new PriorityQueue<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        used = new boolean[n];
        d = new int[n];
        
        Arrays.fill(used, false);
        Arrays.fill(d,0x3fffffff);
        for(int i = 0;i < n;++i) edges.add(new LinkedList<>());
        int from, to, cost;
        int[] curTime;
        for(int i = 0;i < times.length;++i){
            curTime = times[i];
            from = curTime[0] - 1;
            to = curTime[1] - 1;
            cost = curTime[2];
            edges.get(from).add(new Edge(to, cost));
        }
        used[k - 1] = true;
        d[k - 1] = 0;
        nodesInOrder.add(new Node(k - 1, 0));

        while(!nodesInOrder.isEmpty()){
            Node curNode = nodesInOrder.poll();
            if(curNode.d > d[curNode.No]) continue;
            for(Edge e : edges.get(curNode.No)){
                if(d[e.to] > d[curNode.No] + e.cost){
                    d[e.to] = d[curNode.No] + e.cost;
                    nodesInOrder.add(new Node(e.to, d[e.to]));
                }
            }
        }

        int ans = 0;
        for(int i = 0;i < n;++i){
            if(d[i] == 0x3fffffff) return -1;
            ans = Math.max(ans, d[i]);
        }
        return ans;
    }


}
// @lc code=end

