import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    int n;
    public int[][] merge(int[][] intervals) {
        n = intervals.length;
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1;i < n;++i){
            int[] interval = intervals[i];
            if(interval[0] <= end){
                end = Math.max(end, interval[1]);
            } else {
                ans.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        ans.add(new int[]{start, end});
        int[][] formatedAns = new int[ans.size()][2];
        ans.toArray(formatedAns);
        return formatedAns;
    }
}
// @lc code=end

