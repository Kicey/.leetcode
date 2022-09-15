import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1608 lang=java
 *
 * [1608] 特殊数组的特征值
 */

// @lc code=start
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        int n = nums.length;
        for(int i = n - 1;i > 0;--i){
            ++cnt;
            if(cnt <= nums[i] && cnt > nums[i - 1]){
                return cnt;
            }
        }
        ++cnt;
        if(cnt <= nums[0]){
            return cnt;
        }
        return -1;
    }
}
// @lc code=end

