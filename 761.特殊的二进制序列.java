import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=761 lang=java
 *
 * [761] 特殊的二进制序列
 */

// @lc code=start
class Solution {
    public String makeLargestSpecial(String s) {
        int n = s.length();
        String subStr = s.substring(1, n - 1);
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.valueOf(subStr.charAt(0)));
        for(int i = 1;i < n;++i){
            
        }
    }
}
// @lc code=end

