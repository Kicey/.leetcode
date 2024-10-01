/*
 * @lc app=leetcode.cn id=983 lang=scala
 *
 * [983] 最低票价
 */

// @lc code=start
object Solution:
  def mincostTickets(days: Array[Int], costs: Array[Int]): Int =
    val dayCount = 365
    val dp = Array.fill(dayCount)(0)
    var dayIndex = 0
    for i <- 0 until 365
    do
      if days(dayIndex) != i + 1
      then
        if i > 0
        then 
          dp(i) = dp(i - 1)
      else
        val payDayCost = if i >= 1 then costs(0) + dp(i - 1) else costs(0)
        val payWeekCost = if i >= 7 then costs(1) + dp(i - 7) else costs(1)
        val payMonthCost = if i >= 30 then costs(2) + dp(i - 30) else costs(2)
        dp(i) = Math.min(payDayCost, Math.min(payWeekCost, payMonthCost))
        if dayIndex < days.size - 1 then dayIndex += 1
    dp(364)
// @lc code=end

