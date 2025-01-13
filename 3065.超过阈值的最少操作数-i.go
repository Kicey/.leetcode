/*
 * @lc app=leetcode.cn id=3065 lang=golang
 *
 * [3065] 超过阈值的最少操作数 I
 */

// @lc code=start
package main

func minOperations(nums []int, k int) int {
	result := 0
    for _, num := range nums {
		if num < k {
			result++
		}
	}
	return result
}
// @lc code=end

