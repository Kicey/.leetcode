import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/*
 * @lc app=leetcode.cn id=817 lang=java
 *
 * [817] 链表组件
 */

// @lc code=start

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    Set<Integer> hashSet = new HashSet<>();
    public int numComponents(ListNode head, int[] nums) {
        Integer[] numsp = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        hashSet.addAll(Arrays.asList(numsp));
        ListNode cur = head;
        boolean started = false;
        int cnt = 0;
        for(;cur != null;cur = cur.next){
            if(hashSet.contains(cur.val)){
                started = true;
                continue;
            }
            if(started){
                ++cnt;
                started = false;
            }
        }
        if(started){
            ++cnt;
        }
        return cnt;
    }
}
// @lc code=end

