/*
 * @lc app=leetcode.cn id=2656 lang=scala
 *
 * [2656] K 个元素的最大和
 */

// @lc code=start
object Solution {
    def maximizeSum(nums: Array[Int], k: Int): Int = {
        val max = nums.max
        max * k + (k * k - k) / 2
    }
}
// @lc code=end

