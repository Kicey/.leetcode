/*
 * @lc app=leetcode.cn id=2476 lang=scala
 *
 * [2476] 二叉搜索树最近节点查询
 */

// @lc code=start
import scala.collection.mutable.Queue
import scala.collection.mutable.ListBuffer
import scala.collection.Searching._
import scala.collection.immutable.VectorBuilder

// Definition for a binary tree node.
class TreeNode(
    _value: Int = 0,
    _left: TreeNode = null,
    _right: TreeNode = null
) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def closestNodes(root: TreeNode, queries: List[Int]): List[List[Int]] = {
    val vList = toList(root).sorted
    // print(vList)
    queries.map(
      q => {
      val idx = vList.search(q)
      idx match {
        case Found(foundIndex) => 
          List(vList(foundIndex), vList(foundIndex))
        case InsertionPoint(insertionPoint) => 
          List(
            if (insertionPoint == 0) -1 else vList(insertionPoint - 1), 
            if (insertionPoint == vList.size) -1 else vList(insertionPoint)
          )
      }
    })
  }

  def toList(root: TreeNode):Vector[Int] = {
    val res = new VectorBuilder[Int]
    val queue = new Queue[TreeNode]()
    queue.enqueue(root)
    while(queue.nonEmpty){
      val curNode = queue.dequeue()
      res += curNode.value
      if(curNode.left != null) queue.enqueue(curNode.left)
      if(curNode.right != null) queue.enqueue(curNode.right)
    }
    return res.result()
  }

}
// @lc code=end
