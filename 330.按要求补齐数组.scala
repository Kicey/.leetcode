/*
 * @lc app=leetcode.cn id=330 lang=scala
 *
 * [330] 按要求补齐数组
 */

// @lc code=start
object Solution:
    def minPatches(nums: Array[Int], n: Int): Int =
        var patches = 0
        var x = 1L
        var index = 0
        while x <= n do
            if index < nums.length && nums(index) <= x then
                x += nums(index)
                index += 1
            else
                x *= 2
                patches += 1
            print(x)
        patches
// @lc code=end

