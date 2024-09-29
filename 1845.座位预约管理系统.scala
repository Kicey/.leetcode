/*
 * @lc app=leetcode.cn id=1845 lang=scala
 *
 * [1845] 座位预约管理系统
 */

// @lc code=start
import collection.mutable.PriorityQueue

class SeatManager(_n: Int):

    val pq = PriorityQueue.from(for i <- 1 to _n yield i).reverse

    def reserve(): Int = 
        pq.dequeue()

    def unreserve(seatNumber: Int): Unit = 
        pq.enqueue(seatNumber)

/**
 * Your SeatManager object will be instantiated and called as such:
 * val obj = new SeatManager(n)
 * val param_1 = obj.reserve()
 * obj.unreserve(seatNumber)
 */
// @lc code=end

