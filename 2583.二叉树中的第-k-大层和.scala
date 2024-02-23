/*
 * @lc app=leetcode.cn id=2583 lang=scala
 *
 * [2583] 二叉树中的第 K 大层和
 */

// @lc code=start
import scala.collection.mutable.Queue
import scala.collection.mutable.ListBuffer
import scala.math

// Definition for a binary tree node.
// private class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
//   var value: Int = _value
//   var left: TreeNode = _left
//   var right: TreeNode = _right
// }

object Solution {
    def kthLargestLevelSum(root: TreeNode, k: Int): Long = {
        val queue = new Queue[TreeNode]
        val sumList = new ListBuffer[Long]
        queue.enqueue(root);
        var layer = 0
        var layerSize = 1
        queue.nonEmpty
        
        while (queue.nonEmpty) {
            layer += 1
            var newLayerSize = 0
            var layerSum = 0L
            for (i <- 0 until layerSize) {
                val node = queue.dequeue()
                layerSum += node.value
                if (node.left != null) {
                  queue.enqueue(node.left)
                  newLayerSize += 1
                }
                if (node.right != null) {
                  queue.enqueue(node.right)
                  newLayerSize += 1
                }
            }
            layerSize = newLayerSize
            sumList.append(layerSum)
        }
        if(sumList.size < k){
          return -1
        }
        val sortedList = sumList.sortWith((a, b) => !(a <= b))
        print(sortedList)
        sortedList.apply(k - 1)
    }
}
// @lc code=end

