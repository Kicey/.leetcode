import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 */

// @lc code=start
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int i = 1, curLen = words[0].length();
        int start = 0;
        List<String> ans = new ArrayList<>();
        for(;i < n;++i){
            if(curLen + 1 + words[i].length() <= maxWidth){
                curLen += 1 + words[i].length();
            } else {
                int wordLen = 0;
                for(int j = start;j < i;++j){
                    wordLen += words[j].length();
                }
                int remain = maxWidth - wordLen;
                int quotient, remainder;
                if(i - start == 1){
                    quotient = maxWidth - wordLen;
                    remainder = 0;
                } else {
                    quotient = remain / (i - start - 1);
                    remainder = remain % (i - start - 1);
                }
                
                StringBuilder stringBuilder = new StringBuilder();
                char[] blanks = new char[quotient];
                Arrays.fill(blanks, ' ');
                for(int j = start;j < i;++j){
                    stringBuilder.append(words[j]);
                    if(j == i - 1 && j != start) continue;
                    stringBuilder.append(blanks);
                    if(remainder > 0){
                        stringBuilder.append(' ');
                        --remainder;
                    }
                }
                ans.add(stringBuilder.toString());
                start = i;
                curLen = words[i].length();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(words[start]);
        for(int j = start + 1;j < i;++j){
            stringBuilder.append(' ');
            stringBuilder.append(words[j]);
        }
        while(stringBuilder.length() < maxWidth){
            stringBuilder.append(' ');
        }
        ans.add(stringBuilder.toString());
        return ans;
    }
}
// @lc code=end

