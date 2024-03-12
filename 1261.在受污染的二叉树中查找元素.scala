/*
 * @lc app=leetcode.cn id=1261 lang=scala
 *
 * [1261] 在受污染的二叉树中查找元素
 */

// @lc code=start

// Definition for a binary tree node.
// class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
//   var value: Int = _value
//   var left: TreeNode = _left
//   var right: TreeNode = _right
// }

class FindElements(_root: TreeNode):

    _root.value = 0
    correct(_root)

    def find(target: Int): Boolean = 
        return find(_root, target)

    def find(root: TreeNode, target: Int): Boolean =
        if (root == null) then
            return false
        if (root.value == target) then
            return true
        return find(root.left, target) || find(root.right, target)

    def correct(root: TreeNode): Unit =
        if (root.left != null) then
            root.left.value = 2 * root.value + 1
            correct(root.left)
        if (root.right != null) then
            root.right.value = 2 * root.value + 2
            correct(root.right)

/**
 * Your FindElements object will be instantiated and called as such:
 * val obj = new FindElements(root)
 * val param_1 = obj.find(target)
 */
// @lc code=end

