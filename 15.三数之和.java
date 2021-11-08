import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Map;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> preAns = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;++i){
            for(int j = i + 1;j < nums.length;++j){
                int target = - nums[i] - nums[j];
                int index = Arrays.binarySearch(nums, target);
                if(index < 0) continue;

                int nextIndex = Arrays.binarySearch(nums, target + 1);
                if(nextIndex < 0) nextIndex = -(nextIndex + 1);
                while(nextIndex > 0 && nextIndex < nums.length && nums[nextIndex - 1] == nums[nextIndex]) --nextIndex;
                if(nums[nextIndex - 1] == nums[index]) index = nextIndex - 1;

                if(index > j){
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[index]);
                    preAns.add(list);
                }
            }
        }
        return new ArrayList<>(preAns);
    }
}
// @lc code=end

