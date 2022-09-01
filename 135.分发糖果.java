/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    int n;
    public int candy(int[] ratings) {
        n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;
        for(int i = 1;i < n;++i){
            if(ratings[i] > ratings[i -1]){
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int sum = 0;
        int right = 1;
        for(int i = n - 2;i >= 0;--i){
            if(ratings[i] > ratings[i + 1]){
                ++right;
            } else {
                right = 1;
            }
            sum += Math.max(left[i], right);
        }
        sum += left[n - 1];
        return sum;
    }
}
// @lc code=end

