/*
 * @lc app=leetcode.cn id=100 lang=golang
 *
 * [100] 相同的树
 */

// @lc code=start
package main

// Definition for a binary tree node.
type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

func isSameTree(p *TreeNode, q *TreeNode) bool {
	if (p == nil && q == nil) {
		return true
	}
	if (p == nil || q == nil) {
		return false
	}
    if (p.Val != q.Val) {
		return false
	} else {
		if (!isSameTree(p.Left, q.Left)) {
			return false
		} else {
			return isSameTree(p.Right, q.Right)
		}
	}
}
// @lc code=end

