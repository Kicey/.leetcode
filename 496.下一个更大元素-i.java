import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        stack.push(nums2[nums2.length - 1]);
        map.put(nums2[nums2.length - 1], -1);

        for(int i = nums2.length - 2; i >= 0; --i){
            while(!stack.empty() && nums2[i] >= stack.peek()) stack.pop();
            if(stack.empty()){
                map.put(nums2[i], -1);
            }else{
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for(int i = 0;i < nums1.length;++i){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
// @lc code=end

