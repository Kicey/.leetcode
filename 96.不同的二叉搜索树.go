/*
 * @lc app=leetcode.cn id=96 lang=golang
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
package main

func numTrees(n int) int {
	_n := int64(n)
	numerator, denominator := int64(1), int64(1)
	for i := 2 * _n; i > _n+1; i-- {
		if (i % 2 == 0) {
			numerator *= 2
		} else {
			numerator *= i
		}
	}
	for i := (_n + 1) / 2; i > 0; i-- {
		denominator *= i
	}
	return int(numerator / denominator)
}

// @lc code=end
