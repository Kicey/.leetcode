/*
 * @lc app=leetcode.cn id=222 lang=golang
 *
 * [222] 完全二叉树的节点个数
 */

// @lc code=start

// Definition for a binary tree node.
package main

// type TreeNode struct {
//     Val int
//     Left *TreeNode
//     Right *TreeNode
// }

func countNodes(root *TreeNode) int {
	if root == nil {
		return 0
	}
	lCount := countNodes(root.Left)
	rCount := countNodes(root.Right)
	return lCount + rCount + 1
}

// @lc code=end
