/*
 * @lc app=leetcode.cn id=79 lang=scala
 *
 * [79] 单词搜索
 */

// @lc code=start
object Solution {
    def exist(board: Array[Array[Char]], word: String): Boolean = {
        val (m, n) = (board.length, board(0).length)
        val visited = Array.fill(m, n)(false)
        val wordSet = word.toCharArray().toSet
        val startChar = word(0)
        val startPoints = for {
            i <- 0 until m
            j <- 0 until n
            if board(i)(j) == startChar
        } yield (i, j)

        def dfs(i: Int, j: Int, word: String): Boolean = {
            if (word.isEmpty) return true
            if (i < 0 || i >= m || j < 0 || j >= n || visited(i)(j) || board(i)(j) != word(0)) return false
            visited(i)(j) = true
            val res = dfs(i + 1, j, word.substring(1)) || dfs(i - 1, j, word.substring(1)) || dfs(i, j + 1, word.substring(1)) || dfs(i, j - 1, word.substring(1))
            visited(i)(j) = false
            res
        }

        startPoints.exists { case (i, j) => dfs(i, j, word) }
    }
}
// @lc code=end

