/*
 * @lc app=leetcode.cn id=2908 lang=scala
 *
 * [2908] 元素和最小的山形三元组 I
 */

// @lc code=start
object Solution:
    def minimumSum(nums: Array[Int]): Int =
        val n = nums.length
        val (preMin, suffixMin) = (Array.fill(n)(Int.MaxValue), Array.fill(n)(Int.MaxValue))
        preMin(0) = nums(0)
        for i <- 1 until n
        do preMin(i) = preMin(i - 1) min nums(i)
        suffixMin(n - 1) = nums(n - 1)
        for i <- n - 2 to 0 by -1
        do suffixMin(i) = suffixMin(i + 1) min nums(i)
        var ans = Int.MaxValue
        for i <- 1 until n - 1
        do
            val left = preMin(i - 1)
            val right = suffixMin(i + 1)
            if nums(i) > left && nums(i) > right
            then ans = ans min (left + nums(i) + right)
        if ans != Int.MaxValue then ans else -1
// @lc code=end

