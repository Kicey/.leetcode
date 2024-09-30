/*
 * @lc app=leetcode.cn id=2535 lang=scala
 *
 * [2535] 数组元素和与数字和的绝对差
 */

// @lc code=start
object Solution:
  def differenceOfSum(nums: Array[Int]): Int =
    val sum = nums.sum
    val digitSum = nums.foldLeft(0)((res, elem) => {
      var elemDigitSum = 0
      var curElem = elem
      while (curElem > 0)
      do
        elemDigitSum += curElem % 10
        curElem /= 10
      res + elemDigitSum
    })
    Math.abs(sum - digitSum)
// @lc code=end
