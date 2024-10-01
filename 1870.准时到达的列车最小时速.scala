/*
 * @lc app=leetcode.cn id=1870 lang=scala
 *
 * [1870] 准时到达的列车最小时速
 */

// @lc code=start
object Solution:
  def minSpeedOnTime(dist: Array[Int], hour: Double): Int =
    println("Start!")
    def calculateTimeSpent(velocity: Int): Double =
      dist.dropRight(1).map((d) => (d.toDouble/velocity).ceil).sum + dist.last.toDouble/velocity
    var (l, r, mid) = (1, 1e7.toInt + 2, 0)
    while r - l > 2
    do
      mid = (l + r) / 2
      val cost = calculateTimeSpent(mid)
      if cost >= hour
      then
        l = mid
      else
        r = mid + 1
      println(s"l: $l, r: $r, cost: $cost")

    mid = (l + r) / 2
    val lCost = calculateTimeSpent(l)
    println(s"l: $l, lCost: $lCost")
    val ret = if lCost <= hour then l else mid
    if ret > 1e7.toInt then -1 else ret
// @lc code=end

