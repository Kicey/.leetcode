import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1218 lang=java
 *
 * [1218] 最长定差子序列
 */

// @lc code=start
class Solution {
    int n = 0;
    public int longestSubsequence(int[] arr, int difference) {
        /*
        int[] dp = new int[arr.length]; //dp[i]表示arr[i]的最长子序列长度
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            //从i开始，找到第一个比arr[i]大的数
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == difference) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
        */
        n = arr.length;
        int ret = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 1);
        for(int i = 1;i < n;++i){
            map.put(arr[i], map.getOrDefault(arr[i] - difference, 0) + 1);
            ret = Math.max(ret, map.get(arr[i]));
        }
        return ret;
    }
}
// @lc code=end

