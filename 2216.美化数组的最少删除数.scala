/*
 * @lc app=leetcode.cn id=2216 lang=scala
 *
 * [2216] 美化数组的最少删除数
 */

// @lc code=start
object Solution {
    def minDeletion(nums: Array[Int]): Int = {
        var preNum: Int = nums(0)
        var count = 0
        for (i <- 1 until nums.length) {
            if (preNum == -1) {
                preNum = nums(i)
            } else {
                if(nums(i) != preNum) {
                    preNum = -1;
                    count += 2
                }
            }
        }
        nums.length - count
    }
}
// @lc code=end

