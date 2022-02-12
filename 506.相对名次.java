import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 */

// @lc code=start
class Solution {
    String[] str = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        List<int[]> list = new ArrayList<>();
        for(int i = 0;i < n;++i){
            list.add(new int[]{i, score[i]});
        }
        list.sort((a, b)->{
            return - (a[1] - b[1]);
        });
        String[] ret = new String[n];
        int[] cur;
        int i = 0;
        for(;i < 3 && i < n;++i){
            cur = list.get(i);
            ret[cur[0]] = str[i];
        }
        for(;i < n;++i){
            cur = list.get(i);
            ret[cur[0]] = Integer.toString(i + 1);
        }
        return ret;
    }
}
// @lc code=end

