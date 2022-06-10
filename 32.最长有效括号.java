import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for(int i = 0;i < s.length();++i){
            if(s.charAt(i) == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if(stack.empty()) {
                    stack.push(i);
                }else{
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
// @lc code=end

