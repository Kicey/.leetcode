/*
 * @lc app=leetcode.cn id=275 lang=java
 *
 * [275] H 指数 II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int i = 0, len = citations.length;
        for(;i < len;++i){
            if(len - i <= citations[i]){
                return len - i;
            }
        }
        return 0;
    }
}
// @lc code=end

