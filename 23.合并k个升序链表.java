/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start

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

    int n;

    public ListNode mergeKLists(ListNode[] lists) {
        n = lists.length;
        ListNode[] heads = new ListNode[n];

        for (int i = 0; i < n; ++i) {
            heads[i] = lists[i];
        }

        ListNode mergedList = new ListNode();
        {
            ListNode first = minNodeNext(heads);
            if(first == null) return null;
            mergedList.val = first.val;
        }
        ListNode mergedListTail = mergedList;
        ListNode minNode;
        while( (minNode = minNodeNext(heads)) != null){
            mergedListTail.next = new ListNode(minNode.val);
            mergedListTail = mergedListTail.next;
        }
        return mergedList;
    }

    private ListNode minNodeNext(ListNode[] nodes) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0;i < nodes.length;++i) {
            ListNode node = nodes[i];
            if(node == null) continue;
            if (node.val <= min) {
                min = node.val;
                index = i;
            }
        }
        if(index == -1) return null;
        ListNode ret = nodes[index];
        nodes[index] = ret.next;
        return ret;
    }
}
// @lc code=end
