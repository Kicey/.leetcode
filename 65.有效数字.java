

/*
 * @lc app=leetcode.cn id=65 lang=java
 *
 * [65] 有效数字
 */

// @lc code=start
class Solution {
    public boolean isNumber(String s) {
        String number = "(([\\+\\-]?\\d+)|([\\+\\-]?((\\d+\\.)|(\\d+\\.\\d+)|(\\.\\d+))))([eE]([\\+\\-]?\\d+))?";
        return java.util.regex.Pattern.matches(number, s);
    }
}
// @lc code=end

