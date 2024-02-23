/*
 * @lc app=leetcode.cn id=89 lang=scala
 *
 * [89] 格雷编码
 */

// @lc code=start
object Solution {
    def grayCode(n: Int): List[Int] = {
        if (n == 0) {
            return List(0)
        }
        val prev = grayCode(n - 1)
        prev ++ prev.reverse.map(_ + (1 << (n - 1)))
    }
}
// @lc code=end

