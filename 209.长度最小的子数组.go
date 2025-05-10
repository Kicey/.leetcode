/*
 * @lc app=leetcode.cn id=209 lang=golang
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
package main

import "math"

func minSubArrayLen(target int, nums []int) int {
	l, r := 0, 1
	sum := nums[0]
	if sum >= target {
		return 1
	}
	res := math.MaxInt
	for l != r {
		if sum < target && r < len(nums) {
			sum += nums[r]
			r++
		} else {
			if sum >= target {
				res = min(res, r-l)
			}
			sum -= nums[l]
			l++
		}
	}
	if res == math.MaxInt {
		return 0
	} else {
		return res
	}
}

// @lc code=end
