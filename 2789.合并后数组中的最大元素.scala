/*
 * @lc app=leetcode.cn id=2789 lang=scala
 *
 * [2789] 合并后数组中的最大元素
 */

// @lc code=start
object Solution:
  def maxArrayValue(nums: Array[Int]): Long =
    nums.foldRight(0L)((a, b) => {
      if b >= a then a + b
      else a
    })
// @lc code=end
