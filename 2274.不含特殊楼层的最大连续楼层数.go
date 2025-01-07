/*
 * @lc app=leetcode.cn id=2274 lang=golang
 *
 * [2274] 不含特殊楼层的最大连续楼层数
 */

// @lc code=start
package main

import (
	"fmt"
	"sort"
)

func maxConsecutive(bottom int, top int, special []int) int {
	floor := []int{bottom}
	floor = append(floor, special...)
	floor = append(floor, top)
	max := 0
	sort.Ints(floor)
	fmt.Println(floor)
	for i := 0; i < len(floor)-1; i++ {
		dif := floor[i+1] - floor[i] - 1
		if i == 0 && floor[i] != floor[i + 1] {
			dif++
		} else if i == len(floor)-2 && floor[i] != floor[i + 1] {
			dif++
		}
		if dif > max {
			max = dif
		}
	}
	return max
}

// @lc code=end
