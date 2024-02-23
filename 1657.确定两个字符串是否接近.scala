/*
 * @lc app=leetcode.cn id=1657 lang=scala
 *
 * [1657] 确定两个字符串是否接近
 */

// @lc code=start
object Solution {
    def closeStrings(word1: String, word2: String): Boolean = {

        if (word1.toArray.toSet != word2.toArray.toSet) {
            return false
        }

        def toCntCntSet(word: String): Set[(Int, Int)] = {
            word.toCharArray().map(
                c => (c -> 1)
            ).groupBy(_._1)
            .mapValues(_.map(_._2).sum)
            .values.map(
                {case (count) => (count, 1)}
            )
            .groupBy(_._1)
            .mapValues(_.map(_._2).sum)
            .toSet
        }

        // map char in word1 to count
        val cntCntMap1 = toCntCntSet(word1)

        val cntCntMap2 = toCntCntSet(word2)

        cntCntMap1 == cntCntMap2
    }
}
// @lc code=end

