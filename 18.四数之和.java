import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {

    int n;

    public List<List<Integer>> fourSum(int[] nums, long target) {
        n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int l = 0;l < n - 3;++l){
            if(l > 0 && nums[l] == nums[l - 1]) continue;

            for(int m = l + 1;m < n - 2;++m){
                if(m > l + 1 && nums[m] == nums[m - 1]) continue;

                int r = n - 1;
                for(int i = m + 1;i < n - 1;++i){
                    if(i > m + 1 && nums[i] == nums[i - 1]) continue;
                    if(i == r) break;

                    while(i < r - 1 && target - nums[l] - nums[m] - nums[i] - nums[r] < 0) --r;
                    
                    if(target - nums[l] - nums[m] - nums[i] - nums[r] < 0){
                        break;
                    }

                    if(target - nums[l] - nums[m] - nums[i] - nums[r] == 0 ) {
                        ans.add(List.of(nums[l], nums[m], nums[i], nums[r]));
                    }

                }
            }
        }
        return ans;
    }
}
// @lc code=end

