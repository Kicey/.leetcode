import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    int n;
    int m;
    public int maximumGap(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        n = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0;i < n;++i){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if(max == min) return 0;
        int d = (max - min) / (n - 1);
        if(d == 0) d = 1;
        int m = (max - min) / d + 1;
        int[][] bucket = new int[m][2];
        for(int i = 0;i < m;++i){
            bucket[i][0] = Integer.MAX_VALUE;
            bucket[i][1] = Integer.MIN_VALUE;
        }
        for(int i = 0;i < nums.length;++i){
            int targetBucket = (nums[i] - min) / d;
            bucket[targetBucket][0] = Math.min(bucket[targetBucket][0], nums[i]);
            bucket[targetBucket][1] = Math.max(bucket[targetBucket][1], nums[i]);
        }
        int pre, cur;
        int maxGap = 0;
        for(pre = 0;bucket[pre][1] == Integer.MIN_VALUE;++pre);
        for(cur = 1;cur < m;++cur){
            if(bucket[cur][0] == Integer.MAX_VALUE){
                continue;
            }
            maxGap = Math.max(maxGap, bucket[cur][0] - bucket[pre][1]);
            pre = cur;
        }
        return maxGap;
    }
}
// @lc code=end

