/*
 * @lc app=leetcode.cn id=2304 lang=scala
 *
 * [2304] 网格中的最小路径代价
 */




// @lc code=start
object Solution {
    def minPathCost(grid: Array[Array[Int]], moveCost: Array[Array[Int]]): Int = {
        val dp = Array.ofDim[Int](grid.length, grid(0).length)
        // fill dp with INT_MAX
        for (i <- 0 until dp.length - 1) {
            for (j <- 0 until dp(i).length) {
                dp(i)(j) = Int.MaxValue
            }
        }
        dp(dp.length - 1) = grid(grid.length - 1)

        // traverse from the last row
        for (i <- grid.length - 2 to 0 by -1) {
            for (j <- 0 until grid(i).length) {
                for(k <- 0 until grid(i).length) {
                    dp(i)(j) = Math.min(dp(i)(j), dp(i + 1)(k) + moveCost(grid(i)(j))(k) + grid(i)(j))
                }
            }
        }

        dp(0).reduceLeft(_ min _)
    }

    def main(args: Array[String]): Unit = {
        val dimArray = Array.ofDim[Int](7, 7)
        for( i <- 0 until dimArray.length) {
            for(j <- 0 until dimArray(i).length) {
                println(dimArray(i)(j))
            }
        }
    }
}
// @lc code=end

