/*
 * @lc app=leetcode.cn id=310 lang=scala
 *
 * [310] 最小高度树
 */

// @lc code=start
import scala.collection.mutable.Map
import scala.collection.mutable.ArrayBuffer

object Solution:
  def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] =
    if n == 1 then
      List(0)
    else
      val graph = Map[Int, ArrayBuffer[Int]]()

        // Array.fill(n)(List.empty[Int])
      edges.foreach { case Array(a, b) =>
        graph.getOrElseUpdate(a, ArrayBuffer.empty[Int]) += b
        graph.getOrElseUpdate(b, ArrayBuffer.empty[Int]) += a
      }
      
      var leaves = graph.filter( (k, v) => v.length == 1).map( (k, v) => k).toList
      var newLeaves = List.empty[Int]
      while graph.size > 2 do
        newLeaves = List.empty[Int]
        for leaf <- leaves do
          val parent = graph(leaf).head
          graph.remove(leaf)
          graph(parent).subtractOne(leaf)
          if graph(parent).length == 1 then
            newLeaves = parent :: newLeaves
        leaves = newLeaves
      leaves
// @lc code=end
