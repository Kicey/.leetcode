/*
 * @lc app=leetcode.cn id=1551 lang=java
 *
 * [1551] 使数组中所有元素相等的最小操作数
 */

// @lc code=start
class Solution {
    public int minOperations(int n) {
        // 初始化两个变量，一个表示当前的数字，一个表示当前的操作数
        int res = 0;
        while (n > 1) {
            res += n / 2;
            n /= 2;
        }
        return res;
    }
}
// @lc code=end

