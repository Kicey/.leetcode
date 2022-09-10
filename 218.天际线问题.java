/*
 * @lc app=leetcode.cn id=218 lang=java
 *
 * [218] 天际线问题
 */

// @lc code=start
import java.util.*;
class Solution {
    static class Edge{
        int num;
        int x;
        int height;
        boolean isLeft;
        Edge(int num, int x, int height, Boolean isLeft){
            this.x = x;
            this.num = num;
            this.height = height;
            this.isLeft = isLeft;
        }
    }
    int n;
    List<Edge> edges = new ArrayList<>();
    TreeSet<Edge> edgeSet = new TreeSet<>((a, b)->{
        if(a.height != b.height){
            return -(a.height - b.height);
        }
        return a.num - b.num;
    });
    public List<List<Integer>> getSkyline(int[][] buildings) {
        n = buildings.length * 2;
        for(int i = 0;i < n / 2;++i){
            edges.add(new Edge(i, buildings[i][0], buildings[i][2], true));
            edges.add(new Edge(i, buildings[i][1], buildings[i][2], false));
        }
        edges.sort((a, b) -> {
            if(a.x == b.x){
                if(a.isLeft && !b.isLeft){
                    return -1;
                }
                if(!a.isLeft && b.isLeft){
                    return 1;
                }
                return a.num - b.num;
            }
            return a.x - b.x;
        });
        List<List<Integer>> ans = new ArrayList<>();
        int preHeight = 0;
        for(int i = 0;i < n;++i){
            Edge curEdge = edges.get(i);
            if(!curEdge.isLeft){
                edgeSet.remove(new Edge(curEdge.num, 0, curEdge.height, true));
                if(edgeSet.isEmpty()){
                    ans.add(List.of(new Integer[]{curEdge.x, 0}));
                    continue;
                }
                if(i != n - 1 && curEdge.x == edges.get(i + 1).x){
                    continue;
                }
                Edge highest = edgeSet.first();
                if(highest.height != preHeight){
                    ans.add(List.of(new Integer[]{curEdge.x, highest.height}));
                    preHeight = highest.height;
                }
            } else {
                edgeSet.add(curEdge);
                if(curEdge.x == edges.get(i + 1).x){
                    continue;
                }
                Edge highest = edgeSet.first();
                if(highest.height != preHeight){
                    ans.add(List.of(new Integer[]{curEdge.x, highest.height}));
                    preHeight = highest.height;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

