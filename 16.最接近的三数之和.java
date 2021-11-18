import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    int n = 0;

    public int threeSumClosest(int[] nums, int target) {
        int ret = 0x3fffffff;
        n = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i < n - 2;++i){
            int j = i + 1, k = n - 1;
            while(j < k){
                if(Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(ret - target)){
                    ret = nums[i] + nums[j] + nums[k];
                }
                if(nums[i] + nums[j] + nums[k] >= target) --k;
                else ++j;
            } 
        }
        return ret;
    }

}
// @lc code=end
