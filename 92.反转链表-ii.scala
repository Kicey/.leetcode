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

object Solution:
    def reverseBetween(head: ListNode, left: Int, right: Int): ListNode =
        var res = head
        var beforeLeft, behindRight:ListNode = null
        var leftNode, rightNode: ListNode = null
        var previous, current: ListNode = null
        current = head
        
        for i <- 1 to right do
            var origin = current
            current = current.next
            if i == left - 1 then beforeLeft = origin
            if i == left then leftNode = origin
            if i > left then origin.next = previous
            previous = origin
            
        rightNode = previous
        if beforeLeft == null then res = rightNode
        else beforeLeft.next = rightNode
        behindRight = current
        leftNode.next = behindRight
        res
// @lc code=end

