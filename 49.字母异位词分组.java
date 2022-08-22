import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    Map<int[], List<String>> map = new TreeMap<>((int[] a, int[] b) -> {
        for(int i = 0;i < 26;++i){
            if(a[i] == b[i]) continue;
            return a[i] - b[i];
        }
        return 0;
    });
    public List<List<String>> groupAnagrams(String[] strs) {
        for(String str: strs){
            int[] cntArray = getCntArray(str);
            List<String> specialStrs = map.getOrDefault(cntArray, new ArrayList<>());
            specialStrs.add(str);
            map.put(cntArray, specialStrs);
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> specialStrs: map.values()){
            ans.add(specialStrs);
        }
        return ans;
    }

    private int[] getCntArray(String str){
        int[] cntArray = new int[26];
        for(char c: str.toCharArray()){
            ++cntArray[c - 'a'];
        }
        return cntArray;
    }
}
// @lc code=end

