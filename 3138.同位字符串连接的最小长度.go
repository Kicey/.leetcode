package main

import "fmt"

/*
 * @lc app=leetcode.cn id=3138 lang=golang
 *
 * [3138] 同位字符串连接的最小长度
 */
// @lc code=start
func gcd(a, b int) int {
	for b != 0 {
		a, b = b, a%b
	}
	return a
}

func sameTimes(count []int, leastGroupCount []int) bool {
	var lastTimes = 0
	for i, c := range count {
		if leastGroupCount[i] != 0 {
			if c == 0 {
				return false
			} else if c % leastGroupCount[i] == 0 {
				if lastTimes == 0 {
					lastTimes = c / leastGroupCount[i]
				} else if c / leastGroupCount[i] != lastTimes {
					return false
				}
			} else {
				return false
			}
		}
	}
	return true
}

func anagramLengthCheck(str string, charLeastCont []int, length int) bool {
	var currentCount = [26]int{}
	for i, c := range str {
		currentCount[c-'a'] += 1
		if (i+1) % length == 0 {
			if !sameTimes(currentCount[:], charLeastCont[:]) {
				return false
			}
		}
	}
	return true
}

func minAnagramLength(s string) int {
	var charCount = [26]int{}
	for _, c := range s {
		charIndex := c - 'a'
		charCount[charIndex] += 1
	}

	var commonGcd = gcd(charCount[0], charCount[1])
	for _, count := range charCount[2:] {
		commonGcd = gcd(count, commonGcd)
	}
	fmt.Print(commonGcd)

	var leastGroupCount = 0
	var charLeastCount = [26]int{}
	for i, count := range charCount {
		charLeastCount[i] = count / commonGcd
		leastGroupCount += charLeastCount[i]
	}

	resultLen := leastGroupCount
	for resultLen <= len(s) {
		if anagramLengthCheck(s, charLeastCount[:], resultLen) {
			return resultLen
		}
		resultLen += leastGroupCount
	}
	return resultLen
}

// @lc code=end
