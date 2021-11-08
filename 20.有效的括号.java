import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {

    Stack<Character> stack = new Stack<>();

    Map<Character, Character> map = new HashMap<>();
    {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public boolean isValid(String s) {
        for(int i = 0;i < s.length();++i){
            if(!map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
                continue;
            }
            if( stack.empty() || !( stack.pop() == map.get(s.charAt(i))) ){
                return false;
            }
        }
        if(stack.empty()) return true;
        return false;
    }
}
// @lc code=end

