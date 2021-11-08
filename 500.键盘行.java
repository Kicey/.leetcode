import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 */

// @lc code=start
class Solution {
    Set<Character> s1 = Set.of("qwertyuiop".chars().mapToObj(c -> (char) c).toArray(Character[]::new));
    Set<Character> s2 = Set.of("asdfghjkl".chars().mapToObj(c -> (char) c).toArray(Character[]::new));;
    Set<Character> s3 = Set.of("zxcvbnm".chars().mapToObj(c -> (char) c).toArray(Character[]::new));;
    List<String> ans = new LinkedList<>();

    public String[] findWords(String[] words) {
        for(String word : words){
            Set<Character> curSet = null;
            if(s1.contains(Character.toLowerCase(word.charAt(0)))){
                curSet = s1;
            }else if(s2.contains(Character.toLowerCase(word.charAt(0)))){
                curSet = s2;
            }else if(s3.contains(Character.toLowerCase(word.charAt(0)))){
                curSet = s3;
            }else{
                continue;
            }
            boolean ifContinue = false;;
            for(int i = 1;i < word.length();++i){
                if(!curSet.contains(Character.toLowerCase(word.charAt(i)))){
                    ifContinue = true;
                    break;
                } 
            }
            if(ifContinue) continue;
            ans.add(word);
        }
        return ans.toArray(new String[0]);
    }
}
// @lc code=end

