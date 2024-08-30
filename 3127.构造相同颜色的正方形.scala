/*
 * @lc app=leetcode.cn id=3127 lang=scala
 *
 * [3127] 构造相同颜色的正方形
 */

// @lc code=start
object Solution:
    def canMakeSquare(grid: Array[Array[Char]]): Boolean =
        def maxColorGrid(x: Int, y: Int): Int =
            val color = grid(x)(y)
            val differentSeq = 
                for i <- x until x + 2; j <- y until y + 2 
                if grid(i)(j) != color 
                yield false
            math.max(differentSeq.size, 4 - differentSeq.size)
        var ret = false
        for i <- 0 until 2; j <- 0 until 2
        if !ret
        if maxColorGrid(i, j) >= 3
        do ret = true
        ret
// @lc code=end

