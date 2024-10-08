/*
 * @lc app=leetcode.cn id=1436 lang=scala
 *
 * [1436] 旅行终点站
 */

// @lc code=start
import collection.mutable.Map

object Solution:
  def destCity(paths: List[List[String]]): String =
    val degreeCount = Map[String, Int]()
    paths.foreach(path => {
      degreeCount.updateWith(path(0))(origin => Some(origin.orElse(Some(0)).get - 1))
      degreeCount.updateWith(path(1))(origin => Some(origin.orElse(Some(0)).get + 1))
    })
    degreeCount.filter((key, value) => value > 0).keySet.head
// @lc code=end
