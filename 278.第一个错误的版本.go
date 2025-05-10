/*
 * @lc app=leetcode.cn id=278 lang=golang
 *
 * [278] 第一个错误的版本
 */

// @lc code=start
/**
 * Forward declaration of isBadVersion API.
 * @param   version   your guess about first bad version
 * @return 	 	      true if current version is bad
 *			          false if current version is good
 * func isBadVersion(version int) bool;
 */
package main

// func isBadVersion(version int) bool

func firstBadVersion(n int) int {
	if isBadVersion(1) {
		return 1
	}
	if n == 2 {
		return 2
	}
	l, r := 1, n+1
	for l+1 < r {
		mid := (l + r) / 2
		if isBadVersion(mid) {
			r = mid
		} else {
			l = mid
		}
	}
	return r
}

// @lc code=end
