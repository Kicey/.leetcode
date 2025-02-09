/*
 * @lc app=leetcode.cn id=80 lang=golang
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
package main

import "fmt"

func removeDuplicates(nums []int) int {
	const NIL = -1e4 - 1
	n := len(nums)
	num, times := 0, 0
	for i := 0; i < n; i++ {
		v := nums[i]
		if v != num {
			num, times = v, 1
		} else {
			times++
		}
		if times > 2 {
			nums[i] = NIL
			fmt.Println("Remove num at", i)
		}
	}
	l, r := 0, 0
	for ; r < n; l++ {
		for ; l < n && nums[l] != NIL; l++ {
		}
		r = l + 1
		for ; r < n && nums[r] == NIL; r++ {
		}
		if r < n {
			nums[l] = nums[r]
			nums[r] = NIL
		}
	}
	l--
	fmt.Println(l)
	return l
}

// @lc code=end
