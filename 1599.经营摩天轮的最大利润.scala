/*
 * @lc app=leetcode.cn id=1599 lang=scala
 *
 * [1599] 经营摩天轮的最大利润
 */

// @lc code=start
object Solution {
  def minOperationsMaxProfit(
      customers: Array[Int],
      boardingCost: Int,
      runningCost: Int
  ): Int = {
    var remainVisitorNum = 0
    var maxProfit = 0
    var maxProfitRound = -1
    var preciousProfit = 0
    for (i <- 0 until customers.length) {
      remainVisitorNum += customers(i)
      val boardingNum = if (remainVisitorNum >= 4) 4 else remainVisitorNum
      remainVisitorNum -= boardingNum
      val profit = boardingNum * boardingCost - runningCost + preciousProfit
      if (profit > maxProfit) {
        maxProfit = profit
        maxProfitRound = i + 1
      }
      preciousProfit = profit
    }
    if (remainVisitorNum > 0) {
      val round = customers.length + remainVisitorNum / 4 + (
        if (remainVisitorNum % 4 > 0 && remainVisitorNum % 4 * boardingCost - runningCost > 0)
          1
        else 0
      )
      if (profit > maxProfit) {
        maxProfit = profit
        maxProfitRound = round
      }
    }
    maxProfitRound
  }
}
// @lc code=end
