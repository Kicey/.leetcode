/*
 * @lc app=leetcode.cn id=2549 lang=scala
 *
 * [2549] 统计桌面上的不同数字
 */

// @lc code=start
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable

object Solution:
    def distinctIntegers(n: Int): Int =
        val onDesk = ArrayBuffer(n)
        val onDeskSet = mutable.Set[Int]()
        var next = 0
        while next == 0 || onDesk.length > next do
            val newNums = onDesk.slice(next, onDesk.length)
            val _next = onDesk.length
            for
                newNum <- newNums
                i <- 1 to n
                if newNum % i == 1
                if !onDeskSet.contains(i)
            do
                onDeskSet.add(i)
                onDesk.append(i)
            next = _next
        onDesk.size
// @lc code=end

