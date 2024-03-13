/*
 * @lc app=leetcode.cn id=332 lang=scala
 *
 * [332] 重新安排行程
 */

// @lc code=start
import scala.collection.mutable.ListBuffer

object Solution:
  def findItinerary(tickets: List[List[String]]): List[String] =
    val graph = tickets
      .groupBy((edges) => edges(0))
      .map((k, v) => (k, v.map((edges) => edges(1))))
      .map((k, v) => (k, ListBuffer.from(v.sorted)))

    val stack = ListBuffer[String]()

    def dfs(vertex: String): Unit =
      while graph.contains(vertex) &&
        graph(vertex).nonEmpty
      do dfs(graph(vertex).remove(0))
      stack.append(vertex)

    dfs("JFK")
    stack.reverse.toList

// @lc code=end
