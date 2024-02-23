/*
 * @lc app=leetcode.cn id=64 lang=scala
 *
 * [64] 最小路径和
 */

// @lc code=start
import scala.collection.mutable.Queue

object Solution {
    def minPathSum(grid: Array[Array[Int]]): Int = {
        val cost = Array.ofDim[Int](grid.length, grid(0).length)
        for (i <- 0 until grid.length) for (j <- 0 until grid(i).length) (cost(i)(j) = Int.MaxValue)
        cost(0)(0) = grid(0)(0)

        val visit = Array.ofDim[Boolean](grid.length, grid(0).length)
        Array.fill(grid.length, grid(0).length)(false)

        val queue = Queue[(Int, Int)]((0, 0))
        val nextPos = Array[(Int, Int) => (Int, Int)](
            (i, j) => (i + 1, j),
            (i, j) => (i, j + 1)
        )
        while (queue.nonEmpty) {
            val (i, j) = queue.dequeue()
            for (next <- nextPos) {
                val (ni, nj) = next(i, j)
                if (ni < grid.length && nj < grid(0).length) {
                    if (cost(ni)(nj) > cost(i)(j) + grid(ni)(nj)) {
                        cost(ni)(nj) = cost(i)(j) + grid(ni)(nj)
                    }
                    if (!visit(ni)(nj)) {
                        queue.enqueue((ni,nj))
                        visit(ni)(nj) = true
                    }
                }
            }
        }

        cost.last.last
    }
}
// @lc code=end

