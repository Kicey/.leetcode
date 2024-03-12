/*
 * @lc app=leetcode.cn id=2864 lang=scala
 *
 * [2864] 最大二进制奇数
 */

// @lc code=start
object Solution:
  def maximumOddBinaryNumber(s: String): String =
    val n = s
      .chars()
      .filter((a: Int) => a == '1')
      .count()
      .toInt
    val prefix = Array.fill(n - 1)('1')
    val middle = Array.fill(s.length() -n)('0')
    val result = prefix ++ middle ++ Array('1')
    result.mkString("")
// @lc code=end
