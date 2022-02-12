import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=397 lang=java
 *
 * [397] 整数替换
 */

// @lc code=start
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    //解决int溢出，使用(n + 1) / 2, (n - 1) / 2被替换为n / 2向下取整，n / 2向下取整 + 1
    public int integerReplacement(int n) {
        if(map.containsKey(n)) return map.get(n);
        if(n == 1) return 0;
        if(n % 2 == 0){
            map.put(n, integerReplacement(n / 2) + 1);
            return map.get(n);
        }
        map.put(n, Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)) + 2);
        return map.get(n);
    }
}
// @lc code=end

