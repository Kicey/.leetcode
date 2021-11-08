import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    int ans = Integer.MAX_VALUE;
    int target;
    int[] nums;

    public int threeSumClosest(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int tar = target - (nums[i] + nums[j]);
                int index = Arrays.binarySearch(nums, tar);
                if (index >= 0) {
                    index = Arrays.binarySearch(nums, tar + 1);
                    if(index >= 0) updateNear(nums[i] + nums[j] + nums[index]);
                    else useNearIndex(nums[i] + nums[j], index);

                    index = Arrays.binarySearch(nums, tar - 1);
                    if(index >= 0) updateNear(nums[i] + nums[j] + nums[index]);
                    else useNearIndex(nums[i] + nums[j], index);

                } else {
                    useNearIndex(nums[i] + nums[j], index);
                }
            }
        }
        return ans;
    }

    private void useNearIndex(int base, int index) {
        int biggerIndex = -(index + 1);
        int smallerIndex = biggerIndex - 1;

        if (biggerIndex > 0 && biggerIndex < nums.length) {
            updateNear(base + nums[biggerIndex]);
        }
        if (smallerIndex > 0 && smallerIndex < nums.length) {
            updateNear(base + nums[smallerIndex]);
        }
    }

    private void updateNear(int val) {
        if (Math.abs(ans - target) < Math.abs(val - target)) {
            if (val != target)
                ans = val;
        }
    }
}
// @lc code=end
