/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int everyNum = numRows + numRows - 2;
        StringBuilder sb = new StringBuilder();
    
        for(int i = 0;i <= everyNum / 2;++i){
            for(int j = i, k = everyNum - i;j < s.length();j += everyNum, k += everyNum){
                sb.append(s.charAt(j));
                if(i != 0 && i != everyNum / 2 && k < s.length())sb.append(s.charAt(k));
            }
        }
        return sb.toString();
    }
}
// @lc code=end

