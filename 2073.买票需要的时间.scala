/*
 * @lc app=leetcode.cn id=2073 lang=scala
 *
 * [2073] 买票需要的时间
 */

// @lc code=start
import collection.mutable.PriorityQueue

object Solution:
  def timeRequiredToBuy(tickets: Array[Int], k: Int): Int =
    val kValue = tickets(k)
    tickets.zipWithIndex.foldLeft(0){
      (preRes, elem) => {
        if elem._1 >= kValue
        then
          if elem._2 <= k
          then preRes + kValue
          else preRes + kValue - 1
        else
          preRes + elem._1
      }
    }
// @lc code=end
