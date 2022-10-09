import java.util.Stack;

/*
 * @lc app=leetcode.cn id=856 lang=java
 *
 * [856] 括号的分数
 */

// @lc code=start
class Solution {
    Stack<Integer> stack = new Stack<>();
    public int scoreOfParentheses(String s) {
        stack.add(0);
        for(char c: s.toCharArray()){
            if(c == '('){
                stack.add(0);
            } else {
                int cur = stack.pop();
                int added = 1;
                if(cur != 0){
                    added = 2 * cur;
                }
                stack.add(stack.pop() + added);
            }
        }
        return stack.pop();
    }
}
// @lc code=end

