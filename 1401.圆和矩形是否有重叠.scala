/*
 * @lc app=leetcode.cn id=1401 lang=scala
 *
 * [1401] 圆和矩形是否有重叠
 */

// @lc code=start
object Solution:
    def checkOverlap(radius: Int, xCenter: Int, yCenter: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean =
        def checkIntersect(radius: Int, xCenter: Int, yCenter: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean =
            val x = xCenter max x1 min x2
            val y = yCenter max y1 min y2
            val dx = x - xCenter
            val dy = y - yCenter
            dx * dx + dy * dy <= radius * radius
        def checkIn(xCenter: Int, yCenter: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean =
            xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2
        checkIntersect(radius, xCenter, yCenter, x1, y1, x2, y2) || checkIn(xCenter, yCenter, x1, y1, x2, y2)

// @lc code=end

