/*
 * @lc app=leetcode.cn id=2824 lang=scala
 *
 * [2824] 统计和小于目标的下标对数目
 */

// @lc code=start
object Solution {
  def countPairs(nums: List[Int], target: Int): Int = {
    (for (
      (e, i) <- nums.zipWithIndex; (e2, j) <- nums.zipWithIndex
      if i < j && e + e2 < target
    ) yield 1).sum
  }
}
// @lc code=end
