/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    int[] difference;
    int[] prefix;
    int n;
    public int[] corpFlightBookings(int[][] bookings, int n) {
        difference = new int[n + 1];
        prefix = new int[n];
        for(int[] booking: bookings){
            difference[booking[0] - 1] += booking[2];
            difference[booking[1]] -= booking[2];
        }
        prefix[0] = difference[0];
        for(int i = 1;i < n;++i){
            prefix[i] = difference[i] + prefix[i - 1];
        }
        return prefix;
    }
}
// @lc code=end

