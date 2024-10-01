/*
 * @lc app=leetcode.cn id=94 lang=scala
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start

// Definition for a binary tree node.
// class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
//   var value: Int = _value
//   var left: TreeNode = _left
//   var right: TreeNode = _right
// }

object Solution:
  def inorderTraversal(root: TreeNode): List[Int] =
    val resultList = collection.mutable.ListBuffer[Int]()
    def reverse(node: TreeNode): Unit =
      if node == null
      then
        return
      reverse(node.left)
      resultList += node.value
      reverse(node.right)
    reverse(root)
    resultList.toList
// @lc code=end

