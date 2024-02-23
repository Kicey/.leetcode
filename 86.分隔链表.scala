/*
 * @lc app=leetcode.cn id=86 lang=scala
 *
 * [86] 分隔链表
 */

// @lc code=start
// Definition for singly-linked list.
// class ListNode(_x: Int = 0, _next: ListNode = null) {
//     var next: ListNode = _next
//     var x: Int = _x
// }

object Solution {
    def partition(head: ListNode, x: Int): ListNode = {
        val less = iterator(head).filter(_ < x).toList
        val greater = iterator(head).filter(_ >= x).toList
        (less ++ greater).reverse.foldLeft (null: ListNode) {
            case (null, x) => new ListNode(x)
            case (head, x) => new ListNode(x, head)
        }
    }

    def iterator(head: ListNode): Iterator[Int] = {
        new Iterator[Int] {
            var curNode = head
            def hasNext: Boolean = curNode != null
            def next(): Int = {
                val ret = curNode.x
                curNode = curNode.next
                ret
            }
        }
    }
}
// @lc code=end

