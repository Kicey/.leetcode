/*
 * @lc app=leetcode.cn id=552 lang=scala
 *
 * [552] 学生出勤记录 II
 */
import scala.compiletime.ops.double

// @lc code=start
object Solution:
    val MOD = (1e9 + 7).toLong
    def checkRecord(n: Int): Int =
        if n == 1 then return 3
        val dp = Array.ofDim[Long](n + 1, 4)
        for j <- 0 until 4 do
            dp(0)(j) = 0
            dp(1)(j) = if j % 2 == 0 then 0 else 1
            dp(2)(j) = 1
        for i <- 3 to n do
            dp(i)(0) = dp(i - 1)(2)
            dp(i)(1) = (dp(i -1)(0) + dp(i - 1)(2)) % MOD
            dp(i)(2) = (dp(i - 1)(1) + dp(i - 1)(3)) % MOD
            dp(i)(3) = (dp(i - 1)(1) + dp(i - 1)(3)) % MOD
        val dpUnitSum = dp.map(_.reduce((x, y) => (x + y) % MOD))
        dpUnitSum(0) = 1
        var sum = dpUnitSum(n)
        for i <- 1 to n do
            sum = (sum + (dpUnitSum(i - 1) * dpUnitSum(n - i)) % MOD) % MOD
        sum.toInt
// @lc code=end

