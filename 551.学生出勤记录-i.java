/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {
    public boolean checkRecord(String s) {
        Matcher matcher = Pattern.compile("L{3,}").matcher(s);
        if(matcher.find()){
            return false;
        }
        matcher = Pattern.compile("A").matcher(s);
        if(matcher.results().count() > 1){
            return false;
        }
        return true;
    }
}
// @lc code=end

