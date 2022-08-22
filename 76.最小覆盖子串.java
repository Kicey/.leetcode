import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    Map<Character, Integer> map = new HashMap<>();
    String relatedString;
    List<Integer> relatedIndex = new ArrayList<>();
    Map<Character, Integer> required = new HashMap<>();
    Set<Character> completed = new HashSet<>();
    int minLen = Integer.MAX_VALUE;
    int[] ans = new int[2];
    public String minWindow(String s, String t) {
        for(char c: t.toCharArray()){
            required.put(c, required.getOrDefault(c, 0) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < s.length();++i){
            char c = s.charAt(i);
            if(!required.containsKey(c)){
                continue;
            }
            stringBuilder.append(c);
            relatedIndex.add(i);
        }
        relatedString = stringBuilder.toString();
        if(relatedString.isEmpty()){
            return "";
        }
        int start = 0, end = 1;
        increseCnt(relatedString.charAt(0));
        if(required.get(relatedString.charAt(0)) == 1){
            completed.add(relatedString.charAt(0));
        }
        if(completed.size() == required.size()){
            ans[0] = relatedIndex.get(start);
            ans[1] = ans[0] + 1;
        }
        for(;end != relatedString.length();++end){
            char c = relatedString.charAt(end);
            increseCnt(c);
            if(map.get(c).compareTo(required.get(c)) < 0) continue;
            if(map.get(c).equals(required.get(c))){
                completed.add(c);
            } else if(map.get(c).compareTo(required.get(c)) > 0){
                char mayMove = relatedString.charAt(start);
                while(map.get(mayMove) > required.get(mayMove)){
                    decreseCnt(mayMove);
                    mayMove = relatedString.charAt(++start);
                }
            }
            if(completed.size() == required.size()){
                int originIndex[] = new int[2];
                originIndex[0] = relatedIndex.get(start);
                originIndex[1] = relatedIndex.get(end) + 1;
                if(originIndex[1] - originIndex[0] < minLen){
                    minLen = originIndex[1] - originIndex[0];
                    ans[0] = originIndex[0];
                    ans[1] = originIndex[1];
                }
            }
        }
        return s.substring(ans[0], ans[1]);
    }

    private Integer increseCnt(char c){
        return map.put(c, map.getOrDefault(c, 0) + 1);
    }

    private Integer decreseCnt(char c){
        return map.put(c, map.getOrDefault(c, 0) - 1);
    }
}
// @lc code=end

