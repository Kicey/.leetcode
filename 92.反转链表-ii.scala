/*
 * @lc app=leetcode.cn id=92 lang=scala
 *
 * [92] 反转链表 II
 */

// @lc code=start

// Definition for singly-linked list.
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
    def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
        val iter = new Iterator[ListNode]() {
            val (sentinalHead, sentinalTail) = (new ListNode(), new ListNode())
            sentinalHead.next = head
            var cur = head
            def hasNext: Boolean = cur != null
            def next(): ListNode = {
                val ret = cur
                cur = cur.next
                ret
            }
        }
        val nodeArr = iter.toArray ++ Array[ListNode](sentinalTail)
        
        node

    }
}
// @lc code=end

