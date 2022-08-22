import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1408 lang=java
 *
 * [1408] 数组中的字符串匹配
 */

// @lc code=start
class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> ret = new HashSet<>();
        for(int i = 0;i < words.length;++i){
            for(int j = i + 1;j < words.length;++j){
                if(words[i].length() == words[j].length()){
                    continue;
                }
                String longStr, shortStr;
                if(words[i].length() > words[j].length()){
                    longStr = words[i];
                    shortStr = words[j];
                } else {
                    longStr = words[j];
                    shortStr = words[i];
                }
                if(longStr.indexOf(shortStr) >= 0){
                    ret.add(shortStr);
                }
            }
        }
        return new ArrayList<>(ret);
    }
}
// @lc code=end

