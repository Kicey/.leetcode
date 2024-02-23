/*
 * @lc app=leetcode.cn id=907 lang=scala
 *
 * [907] 子数组的最小值之和
 */

// @lc code=start
object Solution {
  def sumSubarrayMins(arr: Array[Int]): Int = {
    // arr.zipWithIndex.map {
    //     case (v, i) => {
    //         v * (i + 1) * (arr.length - i)
    //     }
    // }.sum
    arr.zipWithIndex
      .map((v, i) => {
        v * (i + 1) * (arr.length - i)
      })
      .sum
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(3, 1, 2, 4)
    println(sumSubarrayMins(arr))
  }
}
// @lc code=end
