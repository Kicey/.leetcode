/*
 * @lc app=leetcode.cn id=1323 lang=golang
 *
 * [1323] 6 和 9 组成的最大数字
 */

// @lc code=start
package main

import "math"

func maximum69Number(num int) int {
	tIdx := 0
	tDigit := 9
	for idx, base := 0, 1; num > base; idx, base = idx+1, base*10 {
		if (num/base)%10 == 6 {
			tIdx = idx
			tDigit = 6
		}
	}
	tBase := int(math.Pow(10, float64(tIdx)))
	return num - tDigit*tBase + 9*tBase
}

// @lc code=end
