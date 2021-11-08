import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        java.util.regex.Pattern pat = java.util.regex.Pattern.compile("(\\s*)(\\+?)(-?\\d+)");
        java.util.regex.Matcher mat = pat.matcher(s);
        if(mat.lookingAt() && (mat.group(2).isEmpty() || mat.group(3).charAt(0) != '-')){
            try{
                return Integer.parseInt(mat.group(3));
            }catch (NumberFormatException nfe){
                if(mat.group(3).charAt(0) == '-'){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }
        }
        return 0;
    }
}
// @lc code=end

