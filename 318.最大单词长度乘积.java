import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] states = new int[n];
        for(int i = 0;i < n;++i){
            states[i] = getState(words[i]);
        }
        int ans = 0;
        for(int i = 0;i < n;++i){
            for(int j = i + 1;j < n;++j){
                if( (states[i] & states[j]) == 0){
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

    private int getState(String words){
        int state = 0;
        List<Character> letterList = words.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        Set<Character> set = new HashSet<Character>(letterList);
        for(char i = 'a';i <= 'z';++i){
            if(set.contains(i)){
                state |= 1 << i;
            }
        }
        return state;
    }
}
// @lc code=end

