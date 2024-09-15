/*
 * @lc app=leetcode.cn id=2848 lang=scala
 *
 * [2848] 与车相交的点
 */

// @lc code=start
object Solution:
    def numberOfPoints(nums: List[List[Int]]): Int =
        val n = nums.length
        val sortedNums = nums.sortWith(
            (a, b) => a(0) < b(0) || a(0) == b(0) && a(1) < b(1)
        )
        sortedNums.foldLeft((0, 0))((accAndCur, point) => {
            val start = point(0)
            val end = point(1)
            val (acc, cur) = accAndCur
            if cur < start then (acc + end - start + 1, end)
            else if cur < end then (acc + end - cur, end)
            else accAndCur
        })._1
// @lc code=end

