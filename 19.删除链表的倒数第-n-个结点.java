/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        for (int i = 0; i < n - 1; ++i) {
            cur = cur.next;
        }

        if (cur.next == null) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }
        cur = cur.next;
        ListNode targetPre = head;
        while (cur.next != null) {
            targetPre = targetPre.next;
            cur = cur.next;
        }
        deleteAfter(targetPre);
        return head;
    }

    private ListNode deleteAfter(ListNode node) {
        ListNode deletedNode = node.next;
        node.next = node.next.next;
        return deletedNode;
    }
}
// @lc code=end
