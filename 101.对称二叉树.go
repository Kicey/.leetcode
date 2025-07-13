/*
 * @lc app=leetcode.cn id=101 lang=golang
 *
 * [101] 对称二叉树
 */

// @lc code=start
package main

import (
	"fmt"

	"github.com/emirpasic/gods/stacks/arraystack"
)

// Definition for a binary tree node.
// type TreeNode struct {
// 	Val   int
// 	Left  *TreeNode
// 	Right *TreeNode
// }

type tuple struct {
	l, r *TreeNode
}

func isSymmetric(root *TreeNode) bool {
	stack := arraystack.New()
	stack.Push(tuple{root.Left, root.Right})

	for !stack.Empty() {
		cur, _ := stack.Pop()
		curLr := cur.(tuple)
		l, r := curLr.l, curLr.r
		if l == nil && r == nil {
			continue
		}
		if (l == nil && r != nil) || (l != nil && r == nil) || l.Val != r.Val {
			fmt.Printf("l: %v, r: %v\n", l, r)
			return false
		}
		if l != nil && r != nil {
			stack.Push(tuple{l.Left, r.Right})
			stack.Push(tuple{l.Right, r.Left})
		}
	}
	return true
}

// @lc code=end
