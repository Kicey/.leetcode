/*
 * @lc app=leetcode.cn id=3097 lang=golang
 *
 * [3097] 或值至少为 K 的最短子数组 II
 */

// @lc code=start
package main

import "math"

func minimumSubarrayLength(nums []int, k int) int {
	bitCount := make([]int, 31)
	minLen := math.MaxInt
	for l, r := 0, 1; r <= len(nums); r++ {
		for i := 0; i < 31; i++ {
			bitCount[i] += int(nums[r-1]>>i) & 1
		}
		for l < r && value(bitCount) >= k {
			if r - l < minLen {
				minLen = r - l
			}
			for i := 0; i < 31; i++ {
				bitCount[i] -= int(nums[l]>>i) & 1
			}
			l++
		}
	}
	if minLen == math.MaxInt {
		return -1
	}
	return minLen
}

func value(bitCount []int) int {
	var res int
	for i := len(bitCount) - 1; i >= 0; i-- {
		res = res * 2
		if bitCount[i] > 0 {
			res++
		}
	}
	return res
}

// @lc code=end
