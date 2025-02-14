/*
 * @lc app=leetcode.cn id=1552 lang=golang
 *
 * [1552] 两球之间的磁力
 */

// @lc code=start
package main

import "sort"

func maxDistance(position []int, m int) int {
	sort.Ints(position)
	// range [l, r)
	l, r := 1, int(1e9)
	for ;r - l > 1; {
		mid := (l + r) / 2
		satisfied := check(position, mid, m)
		if (satisfied) {
			l = mid
		} else {
			r = mid
		}
	}
	return l
}

func check(position []int, minDis int, m int) bool {
	n := len(position)
	count := 1
	prev := position[0]
	for i := 1; i < n; i++ {
		cur := position[i]
		if (cur - prev >= minDis) {
			prev = cur
			count++
		}
		if (count == m) {
			return true
		}
	}
	return false
}
// @lc code=end

