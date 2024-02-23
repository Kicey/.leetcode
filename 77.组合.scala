/*
 * @lc app=leetcode.cn id=77 lang=scala
 *
 * [77] 组合
 */




// @lc code=start
import scala.collection.mutable.ListBuffer

object Solution {
    def combine(n: Int, k: Int): List[List[Int]] = {
        val res = ListBuffer[Array[Int]]()
        val seq = Array.range(1, k + 1)
        
        println(seq.mkString(" "))

        while(seq(k - 1) <= n) {
            val copied = Array.ofDim[Int](k)
            seq.copyToArray(copied, 0, k)
            res.addOne(copied)
            var idx = 0
            while(idx < k - 1 && seq(idx) + 1 == seq(idx + 1)) {
                seq(idx) = idx + 1
                idx += 1
            }
            seq(idx) += 1
        }
        res.map(_.toList).toList
    }
}
// @lc code=end

