/*
 * @lc app=leetcode.cn id=335 lang=scala
 *
 * [335] 路径交叉
 */

// @lc code=start
object Solution:
    def isSelfCrossing(distance: Array[Int]): Boolean =
        var result = false
        for i <- distance.indices.drop(3) if !result
        do
            if i >= 3 
                && distance(i) >= distance(i - 2) 
                && distance(i - 1) <= distance(i - 3) 
                then result = true
            if 
                i >= 4 
                && distance(i - 1) == distance(i - 3) 
                && distance(i) + distance(i - 4) >= distance(i - 2) 
                then result = true
            if i >= 5 
                && distance(i) + distance(i - 4) >= distance(i - 2) 
                && distance(i - 2) >= distance(i - 4) 
                && distance(i - 1) <= distance(i - 3) 
                && distance(i - 1) + distance(i - 5) >= distance(i - 3) 
                then result = true
        result
// @lc code=end

