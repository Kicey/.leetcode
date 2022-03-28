/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
// 
// Definition for singly-linked list.
// class ListNode {
//     int val;
//     ListNode next;
// 
//     ListNode() {
//     }
// 
//     ListNode(int val) {
//         this.val = val;
//     }
// 
//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode headA = list1;
        ListNode headB = list2;

        ListNode mergedListTrailPre = null;
        ListNode mergedList = null;
        while (headA != null || headB != null) {
            ListNode toBeAdded = null;
            if (headA == null || headB == null) {
                if (headA == null) {
                    toBeAdded = headB;
                    headB = headB.next;
                } else if (headB == null) {
                    toBeAdded = headA;
                    headA = headA.next;
                }
            } else {
                if (headA.val < headB.val) {
                    toBeAdded = headA;`
                    headA = headA.next;
                } else {
                    toBeAdded = headB;
                    headB = headB.next;
                }
            }

            if (mergedList == null) {
                mergedList = new ListNode(toBeAdded.val);
                mergedListTrailPre = mergedList;
                continue;
            }

            mergedListTrailPre.next = new ListNode(toBeAdded.val);
            mergedListTrailPre = mergedListTrailPre.next;
        }
        return mergedList;
    }
}
// @lc code=end
