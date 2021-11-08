/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        String s = Integer.toString(x);
        for(int i = 0;i < s.length() / 2;++i){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}
// @lc code=end

