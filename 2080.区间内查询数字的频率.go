/*
 * @lc app=leetcode.cn id=2080 lang=golang
 *
 * [2080] 区间内查询数字的频率
 */

// @lc code=start
package main

import "sort"

type RangeFreqQuery struct {
    valueIndex [][]int
}


func Constructor(arr []int) RangeFreqQuery {
	m := int(1e4 + 1)
    valueIndex := make([][]int, m, m)
	for i := 0; i < m; i++ {
		valueIndex[i] = make([]int, 0, 1)
	}
	for i, num := range arr {
		valueIndex[num] = append(valueIndex[num], i)
	}
	return RangeFreqQuery{valueIndex}
}


func (this *RangeFreqQuery) Query(left int, right int, value int) int {
    li := sort.SearchInts(this.valueIndex[value], left)
	ri := sort.SearchInts(this.valueIndex[value], right)
	if ri < len(this.valueIndex[value]) && this.valueIndex[value][ri] == right {
		ri++
	}
	return ri - li
}


/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * obj := Constructor(arr);
 * param_1 := obj.Query(left,right,value);
 */
// @lc code=end

