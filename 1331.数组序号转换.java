import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=1331 lang=java
 *
 * [1331] 数组序号转换
 */

// @lc code=start
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0){
            return new int[0];
        }
        var copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        Map<Integer, Integer> numOrder = new TreeMap<>();
        var order = 1;
        numOrder.put(copy[0], order++);
        for(int i = 1;i < copy.length;++i){
            if(copy[i] != copy[i - 1]){
                numOrder.put(copy[i], order++);
            }
        }
        var ans = new int[arr.length];
        for(int i = 0;i < arr.length;++i){
            ans[i] = numOrder.get(arr[i]);
        }
        return ans;
    }
}
// @lc code=end

