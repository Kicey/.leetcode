/*
 * @lc app=leetcode.cn id=329 lang=scala
 *
 * [329] 矩阵中的最长递增路径
 */

// @lc code=start
object Solution:

  // Bellman–Ford
  def longestIncreasingPath(matrix: Array[Array[Int]]): Int =
    val n = matrix.length
    val m = matrix(0).length
    val d = Array((-1, 0), (0, 1), (1, 0), (0, -1))
    val actualEdges =
      for
        i <- 0 until n
        j <- 0 until m
        k <- d
        if i + k(0) >= 0 && i + k(0) < n
        if j + k(1) >= 0 && j + k(1) < m
        if matrix(i + k(0))(j + k(1)) > matrix(i)(j)
      yield (
        (i, j),
        ((i + k(0)), (j + k(1))),
        -1
      )

    val sourceEdges =
      for
        i <- 0 until n
        j <- 0 until m
      yield ((n, m), (i, j), 0)

    val edges = actualEdges ++ sourceEdges

    object BellmanFord:
      val source = (-1, -1)
      val dis = Array.fill(n + 1, m + 1)(Int.MaxValue)
      def shortestPath(): Int =
        dis(n)(m) = 0
        var updated = true
        for _ <- 0 until n * m do
          if updated
          then
            updated = false
            for edge <- edges do
              val (from, to, weight) = edge
              if dis(from._1)(from._2) != Int.MaxValue
                && dis(to._1)(to._2) > dis(from._1)(from._2) + weight
              then
                dis(to._1)(to._2) = dis(from._1)(from._2) + weight
                updated = true
        dis.map(_.min).min

    -(BellmanFord.shortestPath() - 1)
// @lc code=end
