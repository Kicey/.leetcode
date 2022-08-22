import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1403 lang=java
 *
 * [1403] 非递增顺序的最小子序列
 */

// @lc code=start
class Solution {
    Integer[] prefixSum;
    Integer[] nums;
    public List<Integer> minSubsequence(int[] nums) {
        prefixSum = new Integer[nums.length];
        this.nums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(this.nums, (a, b) -> {
            return - (a - b);
        });
        prefixSum[0] = this.nums[0];
        for(int i = 1;i < nums.length;++i){
            prefixSum[i] = prefixSum[i - 1] + this.nums[i];
        }
        int end = Arrays.binarySearch(prefixSum, prefixSum[prefixSum.length - 1] / 2 + 1);
        if(end < 0) {
            end = -(end + 1);
        }
        return Arrays.asList(this.nums).subList(0, end + 1);
    }
}
// @lc code=end

