/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
class Solution {

    int[] origin;
    int[] nums;
    public Solution(int[] nums) {
        origin = nums.clone();
        this.nums = nums;
    }
    
    public int[] reset() {
        nums = origin.clone();
        return nums;
    }
    
    public int[] shuffle() {
        int i = nums.length;
        for(;i > 0;--i){
            int selected = (int) (Math.random() * i);
            int temp = nums[i - 1];
            nums[i - 1] = nums[selected];
            nums[selected] = temp;
        }
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

