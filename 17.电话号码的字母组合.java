import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    
    Map<Character, List<Character>> map = new HashMap<>();
    {
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> tmp = new ArrayList<>();
            for (char c : map.get(digits.charAt(i))) {
                for (String s : ans) {
                    tmp.add(s + c);
                }
            }
            ans = tmp;
        }
        return ans;
    }
}
// @lc code=end

