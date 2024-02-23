/*
 * @lc app=leetcode.cn id=70 lang=scala
 *
 * [70] 爬楼梯
 */

// @lc code=start
object Solution {
    def climbStairs(n: Int): Int = {
        var (a, b, c) = (1, 1, 1)
        for (i <- 1 until n) {
            c = a + b
            a = b
            b = c
        }
        c
    }
}
// @lc code=end

