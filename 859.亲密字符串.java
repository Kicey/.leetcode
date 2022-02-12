import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;

        List<Integer> list = new LinkedList<>(); 
        for(int i = 0;i < s.length();++i){
            if(s.charAt(i) != goal.charAt(i)){
                list.add(i);
                if(list.size() > 2) return false;
            }
        }
        if(list.size() == 0){
            Set<Character> set = new HashSet<>();
            for(char c : s.toCharArray()){
                set.add(c);
            }
            if(set.size() < s.length()) return true;
            return false;
        }
        if(list.size() == 1){
            int cFromS = s.charAt(list.get(0));
            int cFromGoal = s.charAt(list.get(0));
            for(int i = 0;i < goal.length(); ++i){
                if(cFromS == goal.charAt(i) && s.charAt(i) == cFromGoal) return true;
            }
            return false;
        }
        if(list.size() == 2 && s.charAt(list.get(0)) == goal.charAt(list.get(1)) && s.charAt(list.get(1)) == goal.charAt(list.get(0))) return true;
        return false;
    }
}
// @lc code=end

