import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1598 lang=java
 *
 * [1598] 文件夹操作日志搜集器
 */

// @lc code=start
class Solution {
    Stack<String> stack = new Stack<>();
    public int minOperations(String[] logs) {
        for(String log: logs){
            if(log.equals("./")){
                continue;
            }
            if(log.equals("../")){
                if(stack.isEmpty()){
                    continue;
                }
                stack.pop();
                continue;
            }
            stack.push(log);
        }
        return stack.size();
    }
}
// @lc code=end

