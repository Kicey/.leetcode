import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    int n;
    Map<Character, Integer> map = new HashMap<>();
    public List<Integer> findAnagrams(String s, String p) {
        n = s.length();
        for(char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int indexL = 0, indexR = 0;
        Map<Character, Integer> cur = new HashMap<>();
        for(;indexR < n;++indexR){
            Character c = s.charAt(indexR);
            if(map.containsKey(c)){
                cur.put(c, cur.getOrDefault(c, 0) + 1);
                if(cur.get(c) > map.get(c)){
                    while(cur.get(c) > map.get(c)){
                        Character c1 = s.charAt(indexL);
                        cur.put(c1, cur.get(c1) - 1);
                        ++indexL;
                    }
                }
                if(cur.equals(map)){
                    res.add(indexL);
                }
            }else{
                cur = new HashMap<>();
                indexL = indexR + 1;
            }
        }
        return res;
    }
}
// @lc code=end

