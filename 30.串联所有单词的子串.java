import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> wordNum = new HashMap<>(5000);
        for (String word : words) {
            wordNum.put(word, wordNum.getOrDefault(word, 0) + 1);
        }
        int wordLen = words[0].length();
        int num = words.length;
        for (int i = 0; i < wordLen; ++i) {
            int l = i, r = i, count = 0;
            Map<String, Integer> map = new HashMap<>(5000);
            while (r + wordLen <= s.length()) {
                String word = s.substring(r, r + wordLen);
                r += wordLen;
                map.put(word, map.getOrDefault(word, 0) + 1);
                count++;
                while (map.get(word) > wordNum.getOrDefault(word, 0)) {
                    String leftWord = s.substring(l, l + wordLen);
                    l += wordLen;
                    map.put(leftWord, map.get(leftWord) - 1);
                    --count;
                }
                if (count == num) {
                    res.add(l);
                }
            }
        }
        return res;
    }
}
// @lc code=end
