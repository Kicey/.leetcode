/*
 * @lc app=leetcode.cn id=67 lang=scala
 *
 * [67] 二进制求和
 */

// @lc code=start
object Solution {
    def addBinary(a: String, b: String): String = {
        (BigInt(a, 2) + BigInt(b, 2)).toString(2)
    }
}
// @lc code=end

