import scala.compiletime.ops.double
/*
 * @lc app=leetcode.cn id=2684 lang=scala
 *
 * [2684] 矩阵中移动的最大次数
 */

// @lc code=start
import math.max

object Solution:
    def maxMoves(grid: Array[Array[Int]]): Int =
        val matrix = Array.fill(grid.length, grid(0).length)(0)
        for 
            i <- 0 until grid.length
        do 
            matrix(i)(0) = 1
        
        val direct = Array((-1, 1), (0, 1), (1, 1))

        for 
            j <- 0 until grid(0).length - 1
            i <- 0 until grid.length
            k <- 0 until 3
            ni = i + direct(k)(0)
            nj = j + direct(k)(1)
            if ni >= 0 && ni < grid.length
            if nj >= 0 && nj < grid(i).length
            if grid(ni)(nj) > grid(i)(j)
            if matrix(i)(j) > 0
        do
            matrix(ni)(nj) =  max(matrix(ni)(nj), matrix(i)(j) + 1)
            
        val res = matrix.map(_.max).max
        print(matrix.map(_.mkString(" ")).mkString("\n"))
        if res == 1 then 0 else res
// @lc code=end

