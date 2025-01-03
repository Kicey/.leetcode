/*
 * @lc app=leetcode.cn id=95 lang=golang
 *
 * [95] 不同的二叉搜索树 II
 */

// @lc code=start
package main

// Definition for a binary tree node.
// type TreeNode struct {
// 	Val   int
// 	Left  *TreeNode
// 	Right *TreeNode
// }

func generateTrees(n int) []*TreeNode {
	return generateTreesInRange(1, n+1)
}

func generateTreesInRange(start int, end int) []*TreeNode {
	if start == end {
		return []*TreeNode{nil}
	}
	if start+1 == end {
		return []*TreeNode{{Val: start}}
	}
	allTrees := []*TreeNode{}
	for i := start; i < end; i++ {
		leftTrees := generateTreesInRange(start, i)
		rightTrees := generateTreesInRange(i+1, end)
		for _, left := range leftTrees {
			for _, right := range rightTrees {
				currentTree := &TreeNode{Val: i}
				currentTree.Left = left
				currentTree.Right = right
				allTrees = append(allTrees, currentTree)
			}
		}
	}
	return allTrees
}

// @lc code=end
