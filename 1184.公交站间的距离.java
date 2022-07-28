/*
 * @lc app=leetcode.cn id=1184 lang=java
 *
 * [1184] 公交站间的距离
 */

// @lc code=start
class Solution {
    int[] dis;
    int n;
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        dis = distance;
        n = distance.length;
        return Math.min(oneWaydis(start, destination), oneWaydis(destination, start));
    }
    private int oneWaydis(int start, int end) {
        int sumDis = 0;
        for(int i = start; i != end;++i) {
            sumDis += dis[i];
            if(i == n - 1){
                i = -1;
            }
        }
        return sumDis;
    }
}
// @lc code=end

