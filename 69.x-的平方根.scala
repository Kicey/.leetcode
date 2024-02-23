/*
 * @lc app=leetcode.cn id=69 lang=scala
 *
 * [69] x 的平方根 
 */

// @lc code=start
object Solution {
    def mySqrt(x: Int): Int = {
        var left = 0
        var right = x
        var ans = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (mid.toLong * mid <= x) {
                ans = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        ans
    }
}
// @lc code=end

