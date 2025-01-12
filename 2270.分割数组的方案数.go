/*
 * @lc app=leetcode.cn id=2270 lang=golang
 *
 * [2270] 分割数组的方案数
 */

// @lc code=start
package main

func waysToSplitArray(nums []int) int {
	prefixSum := make([]int, len(nums))
	prefixSum[0] = nums[0]
	for i := 1; i < len(nums); i++ {
		prefixSum[i] = prefixSum[i-1] + nums[i]
	}
	result := 0
	for i := 0; i < len(nums)-1; i++ {
		leftSum := prefixSum[i]
		rightSum := prefixSum[len(nums)-1] - prefixSum[i]
		if leftSum >= rightSum {
			result++
		}
	}
	return result
}

// @lc code=end
