import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=857 lang=java
 *
 * [857] 雇佣 K 名工人的最低成本
 */

// @lc code=start
class Solution {
    static class Node {
        int quality;
        int wage;
        double rate;
        Node(int quality, int wage){
            this.quality = quality;
            this.wage = wage;
            rate = ((double) wage) / quality;
        }
    }
    int n;
    Node[] arr;
    // 结果取决于 工资 / 质量 的最大值与总质量的乘积
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        n = quality.length;
        arr = new Node[n];
        for(int i = 0;i < n;++i){
            arr[i] = new Node(quality[i], wage[i]);
        }
        Arrays.sort(arr, (a, b) -> {
            if(a.rate - b.rate < 0){
                return -1;
            }
            if(a.rate - b.rate > 0){
                return 1;
            }
            return 0;
        });
        int i = 0;
        int qualitySum = 0;
        double ans = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a, b) -> {
            return -(a.quality - b.quality);
        });
        for(;i < k;++i){
            priorityQueue.add(arr[i]);
            qualitySum += arr[i].quality;
        }
        ans = arr[k - 1].rate * qualitySum;
        for(;i < n;++i){
            qualitySum -= priorityQueue.peek().quality;
            qualitySum += arr[i].quality;

            ans = Math.min(ans, qualitySum * arr[i].rate);

            if(arr[i].quality <= priorityQueue.peek().quality){
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            } else {
                qualitySum -= arr[i].quality;
                qualitySum += priorityQueue.peek().quality;
            }
        }
        return ans;
    }
}
// @lc code=end

