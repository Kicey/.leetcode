import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 */

// @lc code=start
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int findLHS(int[] nums) {
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(map.containsKey(key + 1)){
                if(value + map.get(key + 1) > ans){
                    ans = value + map.get(key + 1);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

