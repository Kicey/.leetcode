/*
 * @lc app=leetcode.cn id=2410 lang=golang
 *
 * [2410] 运动员和训练师的最大匹配数
 */

// @lc code=start
package main

import "sort"

func matchPlayersAndTrainers(players []int, trainers []int) int {
	sort.Ints(players)
	sort.Ints(trainers)
	n, m := len(players), len(trainers)
	i := 0
	for j := 0; i < n && j < m; {
		pv, tv := players[i], trainers[j]
		if pv <= tv {
			i++
			j++
		} else {
			j++
		}
	}
	return i
}

// @lc code=end
