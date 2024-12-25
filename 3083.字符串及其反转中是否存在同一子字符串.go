package main

/*
 * @lc app=leetcode.cn id=3083 lang=golang
 *
 * [3083] 字符串及其反转中是否存在同一子字符串
 */

// @lc code=start

func isSubstringPresent(s string) bool {
	charPairSet := map[string]struct{}{}
	for i := 0; i < len(s)-1; i++ {
		charPairSet[s[i:i+2]] = struct{}{}
	}
	// get s reverse copy
	reversed := ""
	for i := len(s) - 1; i >= 0; i-- {
		reversed += string(s[i])
	}
	for i := 0; i < len(s)-1; i++ {
		if _, exist := charPairSet[reversed[i:i+2]]; exist {
			return true
		}
	}
	return false
}

// @lc code=end
