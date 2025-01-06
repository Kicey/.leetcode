/*
 * @lc app=leetcode.cn id=2241 lang=golang
 *
 * [2241] 设计一个 ATM 机器
 */

// @lc code=start
package main

import "slices"

var FaceValues = []int{20, 50, 100, 200, 500}
var FaceValueIndexMap = map[int]int{
	20:  0,
	50:  1,
	100: 2,
	200: 3,
	500: 4,
}

type ATM struct {
	FaceValueCount map[int]int
}

func Constructor() ATM {
	return ATM{FaceValueCount: make(map[int]int)}
}

func (this *ATM) Deposit(banknotesCount []int) {
	for i, count := range banknotesCount {
		this.FaceValueCount[FaceValues[i]] += count
	}
}

func (this *ATM) Withdraw(amount int) []int {
	res := make([]int, len(FaceValues))
	reverseFaceValues := make([]int, len(FaceValues))
	copy(reverseFaceValues, FaceValues)
	slices.Reverse(reverseFaceValues)
	for _, faceValue := range reverseFaceValues {
		count := amount / faceValue
		if count > this.FaceValueCount[faceValue] {
			count = this.FaceValueCount[faceValue]
		}
		amount -= count * faceValue
		res[FaceValueIndexMap[faceValue]] += count
		if amount == 0 {
			break
		}
	}
	if amount == 0 {
		for i, count := range res {
			this.FaceValueCount[FaceValues[i]] -= count
		}
		return res
	}
	return []int{-1}
}

/**
 * Your ATM object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Deposit(banknotesCount);
 * param_2 := obj.Withdraw(amount);
 */
// @lc code=end
