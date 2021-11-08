/*
 * @lc app=leetcode.cn id=476 lang=java
 *
 * [476] 数字的补数
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        int copy = num;
        int base = 0;
        while(num > 0){
            num >>= 1;
            base <<= 1;
            base += 1;
        }
        return (~copy) & base;
    }

}
// @lc code=end

