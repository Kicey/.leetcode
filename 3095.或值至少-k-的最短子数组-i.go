/*
 * @lc app=leetcode.cn id=3095 lang=golang
 *
 * [3095] 或值至少 K 的最短子数组 I
 */

// @lc code=start
package main

import "math"

func minimumSubarrayLength(nums []int, k int) int {
	bitCount := make([]byte, 7)
	minLen := math.MaxInt
	for l, r := 0, 1; r <= len(nums); r++ {
		for i := 0; i < 7; i++ {
			bitCount[i] += byte(nums[r-1]>>i) & 1
		}
		for l < r && value(bitCount) >= k {
			minLen = min(minLen, r-l)
			for i := 0; i < 7; i++ {
				bitCount[i] -= byte(nums[l]>>i) & 1
			}
			l++
		}
	}
	if minLen == math.MaxInt {
		return -1
	}
	return minLen
}

func value(bitCount []byte) int {
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
