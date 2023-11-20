/*
 * @lc app=leetcode.cn id=2342 lang=scala
 *
 * [2342] 数位和相等数对的最大和
 */

// @lc code=start
import scala.collection.mutable.PriorityQueue

object Solution {
  def maximumSum(nums: Array[Int]): Int = {
    digitSum(123)
    // compute every element's digitSum in nums and put the same sum into priorityqueue
    val digitSumMap: Map[Int, PriorityQueue[Int]] = nums
      .map(num => (num, digitSum(num)))
      .groupBy(_._2)
      .mapValues(_.map(_._1).to(PriorityQueue))
      .toMap // Explicit conversion to PriorityQueue

    // compare fist two element in each priority queue
    digitSumMap.map({
      case (ds, pg) => {
        if (pg.size < 2) -1
        else pg.dequeue() + pg.dequeue()
      }
    }).max
  }

  def digitSum(num: Int): Int = num.toString.map(_.asDigit).sum
}
// @lc code=end
