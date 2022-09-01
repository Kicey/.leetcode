import java.util.Stack;

/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] 验证栈序列
 */

// @lc code=start
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushedIndex = 0;
        for(int i = 0;i < popped.length;++i){
            while(stack.isEmpty() || stack.peek() != popped[i]){
                if(pushedIndex == pushed.length){
                    return false;
                }
                stack.add(pushed[pushedIndex++]);
            }
            if(stack.isEmpty()){
                return false;
            }
            stack.pop();
        }

        return true;
    }
}
// @lc code=end

