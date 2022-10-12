import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    Comparator<int[]> cmp = (int[] a, int[] b) -> {
        if(a[0] != b[0]){
            return a[0] - b[0];
        }
        return - (a[1] - b[1]);
    };

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(intervals));
        list.add(newInterval);
        list.sort(cmp);
        int index = Collections.binarySearch(list, newInterval, cmp);
        int start = 0;
        if(index > 0){
            start = index;
            if(list.get(index - 1)[1] >= list.get(index)[0]){
                start = index - 1;
            }
        }
        int l = list.get(start)[0], r = list.get(start)[1];
        int end = start + 1;
        for(;end < list.size() && r >= list.get(end)[0];++end){
            r = Math.max(list.get(end)[1], r);
        }
        int ansSize = list.size() - (end - start) + 1;
        int[][] ans = new int[ansSize][];
        for(int i = 0, ansIndex = 0;i < list.size();++i, ++ansIndex){
            if(i == start){
                ans[ansIndex] = new int[]{l, r};
                i = end - 1;
                continue;
            }
            ans[ansIndex] = list.get(i);
        }
        return ans;
    }
}
// @lc code=end

