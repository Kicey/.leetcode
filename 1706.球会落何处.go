/*
 * @lc app=leetcode.cn id=1706 lang=golang
 *
 * [1706] 球会落何处
 */

// @lc code=start
package main

func findBall(grid [][]int) []int {
	m, n := len(grid), len(grid[0])
    pos := make([]int, n, n)
	for i := 0; i < n; i++ {
		pos[i] = i
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			col := pos[j]
			if (pos[j] != -1) {
				if (col == 0 && grid[i][col] == -1) {
					pos[j] = -1
				} else if (col == n - 1 && grid[i][col] == 1) {
					pos[j] = -1
				} else if (grid[i][col] == 1 && grid[i][col + 1] == -1) {
					pos[j] = -1
				} else if (grid[i][col] == -1 && grid[i][col - 1] == 1) {
					pos[j] = -1
				} else {
					pos[j] += grid[i][col]
				}
			}
		}
	}
	return pos
}
// @lc code=end

