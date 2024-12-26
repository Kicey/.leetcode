package main

/*
 * @lc app=leetcode.cn id=3159 lang=golang
 *
 * [3159] 查询数组中元素的出现位置
 */

// @lc code=start
func occurrencesOfElement(nums []int, queries []int, x int) []int {
	var xIndex []int
	for i, v := range nums {
		if v == x {
			xIndex = append(xIndex, i)
		}
	}
	var res []int
	for _, v := range queries {
		if v > len(xIndex) {
			res = append(res, -1)
		} else {
			res = append(res, xIndex[v-1])
		}
	}
	return res
}

// @lc code=end
