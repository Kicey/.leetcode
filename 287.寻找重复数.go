/*
 * @lc app=leetcode.cn id=287 lang=golang
 *
 * [287] 寻找重复数
 */

// @lc code=start
package main

func findDuplicate(nums []int) int {
	var next = 1
	for next < len(nums) {
		if next == nums[next] {
			next++
			continue
		}
		if nums[next] == nums[nums[next]] {
			return nums[next]
		}
		nums[next], nums[nums[next]] = nums[nums[next]], nums[next]
	}
	return nums[0]
}

// @lc code=end
