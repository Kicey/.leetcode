/*
 * @lc app=leetcode.cn id=2264 lang=golang
 *
 * [2264] 字符串中最大的 3 位相同数字
 */

// @lc code=start
package main

import (
	"fmt"
	"strconv"
)

func largestGoodInteger(num string) string {
	result := -1
	for i := 0; i < len(num)-2; i++ {
		if num[i] == num[i+1] && num[i+1] == num[i+2] {
			str := num[i : i+3]
			number, err := strconv.Atoi(str)
			if err == nil && number > result {
				result = number
			}
		}
	}
	if result == -1 {
		return ""
	}
	return fmt.Sprintf("%03d", result)
}

// @lc code=end
