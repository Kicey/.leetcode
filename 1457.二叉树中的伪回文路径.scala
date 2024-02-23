/*
 * @lc app=leetcode.cn id=1457 lang=scala
 *
 * [1457] 二叉树中的伪回文路径
 */




// @lc code=start
import scala.collection.mutable.Set

// Definition for a binary tree node.
// class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
//     var value: Int = _value
//     var left: TreeNode = _left
//     var right: TreeNode = _right
// }

object Solution {

    def pseudoPalindromicPaths (root: TreeNode): Int = {
        implicit val set = Set[Int]()
        recurse(root)
    }

    def recurse(treeNode: TreeNode)(implicit set: Set[Int]): Int = {
        if (treeNode == null) {
            return 0
        }
        val addFlag = !set.contains(treeNode.value)

        if (addFlag) set.add(treeNode.value) else set.remove(treeNode.value)

        var count = 0
        if (treeNode.left == null && treeNode.right == null) {
            if (set.size <= 1) {
                count = 1
            }
        } else {
            count = recurse(treeNode.left) + recurse(treeNode.right)
        }
        
        if (addFlag) set.remove(treeNode.value) else set.add(treeNode.value)

        count
    }


    def main(args: Array[String]): Unit = {
    }
}
// @lc code=end

