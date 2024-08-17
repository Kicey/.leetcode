/*
 * @lc app=leetcode.cn id=706 lang=scala
 *
 * [706] 设计哈希映射
 */

// @lc code=start
import scala.collection.mutable.ListBuffer

class MyHashMap():
    val hashslotCount = 1e4.toInt
    val hashSlots = Array.fill(hashslotCount)(ListBuffer[(Int, Int)]())

    def put(key: Int, value: Int): Unit =
        val hash = key % hashslotCount
        val slot = hashSlots(hash)
        val index = slot.indexWhere(_._1 == key)
        if index == -1 then slot.append((key, value)) else slot(index) = (key, value)

    def get(key: Int): Int = 
        val hash = key % hashslotCount
        val slot = hashSlots(hash)
        val index = slot.indexWhere(_._1 == key)
        if index == -1 then -1 else slot(index)._2

    def remove(key: Int): Unit =
        val hash = key % hashslotCount
        val slot = hashSlots(hash)
        val index = slot.indexWhere(_._1 == key)
        if index != -1 then slot.remove(index)


/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
// @lc code=end

