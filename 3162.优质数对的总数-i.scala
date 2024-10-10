/*
 * @lc app=leetcode.cn id=3162 lang=scala
 *
 * [3162] 优质数对的总数 I
 */

// @lc code=startdd
object Solution:
  def numberOfPairs(nums1: Array[Int], nums2: Array[Int], k: Int): Int =
    val divisorArray = nums2.map(num => num * k)
    nums1.map(
      dividend => {
        divisorArray.map(
          divisor => if dividend % divisor == 0 then 1 else 0
        ).reduce((countA, countB) => countA + countB)
      }
    ).reduce((countA, countB) => countA + countB)
// @lc code=end

