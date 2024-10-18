/*
 * @lc app=leetcode.cn id=3192 lang=scala
 *
 * [3192] 使二进制数组全部等于 1 的最少操作次数 II
 */

// @lc code=start
object Solution:
  def minOperations(nums: Array[Int]): Int =
    var flipTimes = 0
    for num <- nums
    if (num + flipTimes) % 2 == 0
    do
      flipTimes += 1
    flipTimes
// @lc code=end

