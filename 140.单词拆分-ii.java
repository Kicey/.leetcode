import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solution {
    int n;
    String s;
    Set<String> set = new HashSet<>();
    List<Integer> oneAns = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        n = s.length();
        this.s = s;
        for(String str: wordDict){
            set.add(str);
        }
        oneAns.add(0);
        seperate(0);
        return ans;
    }

    private void seperate(int start){
        if(start == n){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s.substring(oneAns.get(0), oneAns.get(1)));
            for(int i = 2;i < oneAns.size();++i){
                stringBuilder.append(' ');
                stringBuilder.append(s.substring(oneAns.get(i - 1), oneAns.get(i)));
            }
            ans.add(stringBuilder.toString());
        }
        for(int next = start + 1;next <= n;++next){
            if(set.contains(s.substring(start, next))){
                oneAns.add(next);
                seperate(next);
                oneAns.remove(oneAns.size() - 1);
            }
        }
    }
}
// @lc code=end

