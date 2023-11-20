/*
 * @lc app=leetcode.cn id=63 lang=scala
 *
 * [63] 不同路径 II
 */

// @lc code=start
import scala.collection.mutable.Queue

object Solution {
    def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
        if(obstacleGrid(0)(0) == 1) return 0

        val nextFunctionArry = Array[(Int, Int) => (Int, Int)](
            (x, y) => (x + 1, y),
            (x, y) => (x, y + 1)
        )

        val accessed = Array.ofDim[Boolean](obstacleGrid.length, obstacleGrid(0).length)
        val matrix = Array.ofDim[Int](obstacleGrid.length, obstacleGrid(0).length)
        val que = Queue[(Int, Int)]((0, 0)); 
        matrix(0)(0) = 1
        accessed(0)(0) = true
        while (!que.isEmpty) {
            val (x, y) = que.dequeue
            val wayCnt = matrix(x)(y)
            for (nextFunction <- nextFunctionArry) {
                val (nextX, nextY) = nextFunction(x, y)
                if (nextX < obstacleGrid.length && nextY < obstacleGrid(0).length && obstacleGrid(nextX)(nextY) == 0) {
                    matrix(nextX)(nextY) += wayCnt
                    if (!accessed(nextX)(nextY)) {
                        accessed(nextX)(nextY) = true
                        que.enqueue((nextX, nextY))
                    }
                }
            }
        }
        matrix foreach { row => println(row.mkString(" ")) }
        // result
        matrix.last.last
    }

    def main(args:Array[String]):Unit = {  
        val obstacleGrid = Array(
            Array(1)
        )
        val res = uniquePathsWithObstacles(obstacleGrid)
        println(res)
    }  
}
// @lc code=end

