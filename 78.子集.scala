/*
 * @lc app=leetcode.cn id=78 lang=scala
 *
 * [78] 子集
 */

// @lc code=start
object Solution {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    (
      for (i <- 0 until 1 << nums.length) yield {
        for (j <- 0 until nums.length if (i & (1 << j)) != 0) yield nums(j)
      }.toList
    ).toList
  }
}
// @lc code=end
