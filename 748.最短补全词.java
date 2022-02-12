import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=748 lang=java
 *
 * [748] 最短补全词
 */

// @lc code=start
class Solution {
    Map<Character, Integer> plateMap = new HashMap<>();
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String ret = null;
        for(char c: licensePlate.toCharArray()){
            c = Character.toLowerCase(c);
            if(!Character.isAlphabetic(c)) continue;
            plateMap.put(c, plateMap.getOrDefault(c, 0) + 1);
        }
        for(String word: words){
            if(! ifComplete(word)) continue;
            if(ret == null || ret.length() > word.length()) ret = word;
        }
        return ret;
    }
    
    private boolean ifComplete(String word){
        word = word.toLowerCase();
        Map<Character, Integer> mapUsedToCheck = new HashMap<>();
        for(char c: word.toCharArray()){
            if(!Character.isAlphabetic(c)) continue;
            mapUsedToCheck.put(c, mapUsedToCheck.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry: plateMap.entrySet()){
            int correspond = mapUsedToCheck.getOrDefault(entry.getKey(), 0);
            if(correspond < entry.getValue()) return false;
        }
        return true;
    }
}
// @lc code=end

