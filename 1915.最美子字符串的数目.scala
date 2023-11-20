/*
 * @lc app=leetcode.cn id=1915 lang=scala
 *
 * [1915] 最美子字符串的数目
 */

// @lc code=start
import scala.collection.mutable.Map

object Solution {
    def wonderfulSubstrings(word: String): Long = {
        var res = 0L
        val map = Map[Int, Int](0 -> 1)
        var prefixSum = 0;
        for (c <- word) {
            val curPrefixSum = prefixSum ^ (1 << (c - 'a'))
            res += map.getOrElse(curPrefixSum, 0)
            val allowedPrefixSum = (0 to 9).map(i => curPrefixSum ^ (1 << i)).toList
            for (allowed <- allowedPrefixSum) {
                res += map.getOrElse(allowed, 0)
            }
            // printf("curPrefixSum: %d, res: %d\n", curPrefixSum, res)
            map += (curPrefixSum -> (map.getOrElse(curPrefixSum, 0) + 1))
            prefixSum = curPrefixSum
        }
        res
    }
}
// @lc code=end

