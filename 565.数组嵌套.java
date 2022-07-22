/*
 * @lc app=leetcode.cn id=565 lang=java
 *
 * [565] 数组嵌套
 */

// @lc code=start
class Solution {
    int nums[];
    int n;
    public int arrayNesting(int[] nums) {
        this.nums = nums;
        n = nums.length;
        int ret = 0;
        for(int i = 0;i < n;++i){
            int cur = i;
            int cnt = 0;
            while(nums[cur] != -1) {
                ++cnt;
                int cur_ = cur;
                cur = nums[cur];
                nums[cur_] = -1;
            }
            ret = Math.max(ret, cnt);
        }
        return ret;
    }
}
// @lc code=end

