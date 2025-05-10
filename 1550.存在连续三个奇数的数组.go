/*
 * @lc app=leetcode.cn id=1550 lang=golang
 *
 * [1550] 存在连续三个奇数的数组
 */

// @lc code=start
func threeConsecutiveOdds(arr []int) bool {
	count := 0
	for _, v := range arr {
		if v % 2 == 1 {
			count++
			if count == 3 {
				return true
			}
		} else {
			count = 0
		}
	}
	return false
}

// @lc code=end

