/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
//
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode swapedList = head.next;
        {
            swapedList = head.next;
            head.next = head.next.next;
            swapedList.next = head;
        }
        ListNode preNode = swapedList.next;
        while((preNode = swapPair(preNode)) != null);
        return swapedList;
    }

    private ListNode swapPair(ListNode pre) {
        if(pre == null || pre.next == null || pre.next.next == null) {
            return null;
        }
        ListNode first  = pre.next;
        pre.next = pre.next.next;
        first.next = pre.next.next;
        pre.next.next = first;
        return pre.next.next;
    }
}
// @lc code=end

