import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 求众数 II
 */

// @lc code=start
class Solution {
    int k = Integer.MAX_VALUE;
    Map<Integer,Integer> map = new HashMap<>();
    public List<Integer> majorityElement(int[] nums) {
        k = nums.length / 3;
        for(int num : nums){
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num)+1);
        }
        List<Integer> ret = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > k){
                ret.add(entry.getKey());
            }
        }
        return ret;
    }
}
// @lc code=end

