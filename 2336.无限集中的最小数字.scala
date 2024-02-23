/*
 * @lc app=leetcode.cn id=2336 lang=scala
 *
 * [2336] 无限集中的最小数字
 */

// @lc code=start
import scala.collection.mutable.TreeSet

class SmallestInfiniteSet() {

    val numSet = TreeSet.from(Array.range(1, 1e3.toInt + 1))

    def popSmallest(): Int = {
        val num = numSet.head
        numSet.remove(num)
        num
    }

    def addBack(num: Int) = {
        numSet.add(num)
    }

}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * var obj = new SmallestInfiniteSet()
 * var param_1 = obj.popSmallest()
 * obj.addBack(num)
 */
// @lc code=end

