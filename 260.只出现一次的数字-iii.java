import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;++i){
            if(set.contains(nums[i])) set.remove(nums[i]);
            else set.add(nums[i]);
        }
        return set.stream().mapToInt(Integer::valueOf).toArray();
    }
}
// @lc code=end

