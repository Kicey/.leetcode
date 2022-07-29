import java.util.*;
/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    int n;
    public List<Integer> findDisappearedNumbers(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        int expectedNum = 1;
        List<Integer> ret = new ArrayList<>();
        for(int i = 0;i < n;++i){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if(expectedNum != nums[i]){
                ret.add(expectedNum);
                --i;
            }
            ++expectedNum;
        }
        for(;expectedNum <= n;++expectedNum){
            ret.add(expectedNum);
        }
        return ret;
    }
}
// @lc code=end

