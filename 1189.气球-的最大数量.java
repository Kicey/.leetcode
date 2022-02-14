import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1189 lang=java
 *
 * [1189] “气球” 的最大数量
 */

// @lc code=start
class Solution {
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> have = new HashMap<>();
    {
        need.put('b', 1);
        need.put('a', 1);
        need.put('l', 2);
        need.put('o', 2);
        need.put('n', 1);
    }
    

    public int maxNumberOfBalloons(String text) {
        int ret = Integer.MAX_VALUE;
        for(char c: text.toCharArray()){
            have.put(c, have.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry: need.entrySet()){
            ret = Math.min(ret, have.getOrDefault(entry.getKey(), 0) / entry.getValue());
        }
        return ret;
    }
}
// @lc code=end

