/*
 * @lc app=leetcode.cn id=921 lang=java
 *
 * [921] 使括号有效的最少添加
 */

// @lc code=start
class Solution {
    int num = 0;
    int cnt = 0;
    public int minAddToMakeValid(String s) {
        for(int i = 0;i < s.length();++i){
            char c = s.charAt(i);
            if(c != '(' && c != ')'){
                continue;
            }
            if(c == '('){
                ++num;
            } else {
                if(num > 0){
                    --num;
                } else {
                    ++cnt;
                }
            }
        }
        cnt += num;
        return cnt;
    }
}
// @lc code=end

