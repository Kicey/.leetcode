/*
 * @lc app=leetcode.cn id=2312 lang=scala
 *
 * [2312] 卖木头块
 */

// @lc code=start
import scala.collection.mutable.Map

object Solution:
    def sellingWood(_m: Int, _n: Int, prices: Array[Array[Int]]): Long =
        val woodPriceMap = prices.map { price => (price(0), price(1)) -> price(2).toLong }.toMap
        var woodTotalPriceMap = Map.empty[(Int, Int), Long]
        def dp(m: Int, n: Int): Long =
            if m == 0 || n == 0 then return 0
            else if woodTotalPriceMap.contains((m, n)) then return woodTotalPriceMap((m, n))
            else
                val maxPriceRowSplit = 
                    if m != 1 
                    then (1 until m/2 + 1).map { 
                        i => dp(m - i, n) + dp(i, n)
                    }.max
                    else 0
                val maxPriceColSplit = 
                    if n != 1
                    then (1 until n/2 + 1).map {
                        j => dp(m, n - j) + dp(m, j)
                    }.max
                    else 0
                val maxPriceBySplit = math.max(maxPriceRowSplit, maxPriceColSplit)
                val maxPrice = 
                    if woodPriceMap.contains((m, n)) 
                    then math.max(maxPriceBySplit, woodPriceMap((m, n)))
                    else maxPriceBySplit
                woodTotalPriceMap += ((m, n) -> maxPrice)
                maxPrice
        val result = dp(_m, _n)
        result
// @lc code=end

