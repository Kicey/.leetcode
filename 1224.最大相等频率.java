/*
 * @lc app=leetcode.cn id=1224 lang=java
 *
 * [1224] 最大相等频率
 */

// @lc code=start
class Solution {
    int MAX_NUM = (int) 1e5 + 1;
    public int maxEqualFreq(int[] nums) {
        int[] cnt = new int[MAX_NUM];
        int[] cntCnt = new int[MAX_NUM];
        int maxCnt = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i = 0;i < nums.length;++i){
            --cntCnt[cnt[nums[i]]];
            ++cnt[nums[i]];
            ++cntCnt[cnt[nums[i]]];
            maxCnt = Math.max(maxCnt, cnt[nums[i]]);
            if(maxCnt == 1) maxIndex = i;
            if(maxCnt * cntCnt[maxCnt] == i) maxIndex = i;
            if((maxCnt - 1) * cntCnt[maxCnt - 1] + maxCnt - 1== i) maxIndex = i;
        }
        return maxIndex + 1;
    }
}
// @lc code=end
