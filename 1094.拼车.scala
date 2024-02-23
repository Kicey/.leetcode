/*
 * @lc app=leetcode.cn id=1094 lang=scala
 *
 * [1094] 拼车
 */

// @lc code=start
import scala.collection.mutable.PriorityQueue
import scala.collection.IndexedSeqView.Reverse

object Solution {
    def carPooling(trips: Array[Array[Int]], capacity: Int): Boolean = {
        val sortedTrips = trips.sortBy(_(1))
        val priorityQueue = PriorityQueue[(Int, Int)]()(Ordering.by[(Int, Int), Int](_._2).reverse)

        var curSize = 0
        var result = true
        for (curTrip <- sortedTrips) {
            val (num, from , to) = (curTrip(0), curTrip(1), curTrip(2))
            if (curSize + num <= capacity) {
                curSize += num
                priorityQueue.enqueue((num, to))
            } else {
                while (priorityQueue.nonEmpty && priorityQueue.head._2 <= from) {
                    val (num, to) = priorityQueue.dequeue()
                    curSize -= num
                }
                if (curSize + num <= capacity) {
                    curSize += num
                    priorityQueue.enqueue((num, to))
                } else {
                    result = false
                }
            }
        }
        result
    }

    def main(args: Array[String]): Unit = {
        val result = carPooling(Array(Array(3,2,7),Array(3,7,9),Array(8,3,9)), 11)
        print(result)
    }
}
// @lc code=end

