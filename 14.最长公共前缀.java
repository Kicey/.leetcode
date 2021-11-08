/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for(String e: strs) minLen = Math.min(minLen, e.length());
        for(int i = 0;i < minLen;++i){
            char ch = strs[0].charAt(i);
            int j = 1;
            for(;j < strs.length;++j){
                if(strs[j].charAt(i) != ch) return sb.toString();
            }
            if(j == strs.length){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

