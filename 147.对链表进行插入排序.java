/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode toInsert = head.next;
        head.next = null;
        while(toInsert != null){
            ListNode next = toInsert.next;
            if(toInsert.val <= head.val){
                toInsert.next = head;
                head = toInsert;
                toInsert = next;
                continue;
            }
            ListNode preInsertNode = head;
            while(preInsertNode.next != null && toInsert.val > preInsertNode.next.val){
                preInsertNode = preInsertNode.next;
            }
            toInsert.next = preInsertNode.next;
            preInsertNode.next = toInsert;
            toInsert = next;
        }
        return head;
    }
}
// @lc code=end

