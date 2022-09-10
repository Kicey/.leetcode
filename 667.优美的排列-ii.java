/*
 * @lc app=leetcode.cn id=667 lang=java
 *
 * [667] 优美的排列 II
 */

// @lc code=start
class Solution {
    public int[] constructArray(int n, int k) {
        int l = 1, r = n;
        int[] ans = new int[n];
        int next = r;
        if(k % 2 == 1){
            next = l;
        }
        int cnt = 1;
        int index = 0;
        while(cnt != k){
            ans[index++] = next;
            ++cnt;
            if(next == r){
                next = l;
                --r;
            } else {
                next = r;
                ++l;
            }
           
        }
        for(;index < n;++index){
            ans[index] = l++;
        }
        return ans;
    }
}
// @lc code=end

