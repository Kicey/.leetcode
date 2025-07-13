/*
 * @lc app=leetcode.cn id=912 lang=golang
 *
 * [912] 排序数组
 */

// @lc code=start
package main

import "math/rand/v2"

type stack struct {
	start, end int
}

func sortArray(nums []int) []int {
	n := len(nums)
	stacks := make([]stack, n)
	stacks[0] = stack{0, n}
	si := 0
	for si >= 0 {
		curStack := stacks[si]
		si--
		if curStack.end-curStack.start == 1 {
			continue
		}
		random := rand.IntN(curStack.end-curStack.start) + curStack.start
		nums[random], nums[curStack.end-1] = nums[curStack.end-1], nums[random]
		mv := nums[curStack.end-1]
		le, ri := curStack.start, curStack.end-1
		for le < ri {
			for le < ri && nums[le] <= mv {
				le++
			}
			// we have the first nums[le] > mv
			// or
			// le == ri
			for le < ri && nums[ri] > mv {
				ri--
			}
			// we have the first nums[ri] <= mv
			// or
			// le == ri
			if le != ri {
				nums[le], nums[ri] = nums[ri], nums[le]
			}
		}
		// we have make le == ri
		// if mv is the max within the range
		if mv == nums[curStack.end-1] {
			mri := curStack.end - 1
			mid := (curStack.end + curStack.start) / 2
			for mri > mid && nums[mri-1] == nums[mri] {
				mri--
			}
			si++
			stacks[si] = stack{curStack.start, mri}
		} else {
			if ri-curStack.start > 1 {
				si++
				stacks[si] = stack{curStack.start, le}
			}
			if curStack.end-ri > 1 {
				si++
				stacks[si] = stack{le, curStack.end}
			}
		}
	}
	return nums
}

// @lc code=end
