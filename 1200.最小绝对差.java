import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1200 lang=java
 *
 * [1200] 最小绝对差
 */

// @lc code=start
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1;i < arr.length;++i) {
            minDiff = Math.min(minDiff,arr[i] - arr[i - 1]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1;i < arr.length;++i){
            if(arr[i] - arr[i - 1] == minDiff) {
                res.add(Arrays.asList(arr[i - 1],arr[i]));
            }
        }
        return res;
    }
}
// @lc code=end

