/*
 * @lc app=leetcode.cn id=3143 lang=scala
 *
 * [3143] 正方形中的最多点数
 */

// @lc code=start
import scala.collection.{SortedMap, mutable}
import scala.math._

object Solution {
  def maxPointsInsideSquare(points: Array[Array[Int]], s: String): Int = {
    val pointsWithTag = points.zip(s.toCharArray())
    val sideLengthTags = pointsWithTag
      .map(p => (max(abs(p._1(0)), abs(p._1(1))), p._2))
      .groupBy(_._1)
      .view
      .mapValues(p => (p.length, p.map(_._2)))
      .to(SortedMap)
    val currentTagSet = mutable.Set[Char]()
    var maxPoints = 0
    var continueFlag = true;

    for (countWithTag <- sideLengthTags.values if continueFlag) {
      val tagSet = countWithTag._2.toSet
      val intersection = currentTagSet & countWithTag._2.toSet
      if (intersection.nonEmpty || tagSet.size < countWithTag._2.length) {
        continueFlag = false;
      } else {
        currentTagSet.addAll(countWithTag._2)
        maxPoints += countWithTag._1
      }
    }
    maxPoints
  }
}
// @lc code=end
