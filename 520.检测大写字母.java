import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^[A-Z]?([A-Z]*|[a-z]*)");
        java.util.regex.Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }
}
// @lc code=end

