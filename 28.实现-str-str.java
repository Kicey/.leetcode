/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        Kmp kmp = new Kmp(haystack, needle);
        return kmp.search();
    }

    static private class Kmp{
        String txt;
        String pat;
        int[][] dfa;
        Kmp(String txt, String pat){
            this.txt = txt;
            this.pat = pat;
            /**
             * dfa[i][j]：在状态j(j个字符匹配成功)，尝试用txt中的i字符匹配时，将转到的状态(还有能够几个匹配)
             * 因为有j个匹配成功后，txt的下一个字符就要与pat中索引为j的字符匹配，dfa[i][j]也是txt下个字符应该匹配的模式字符的索引
             */
            dfa = new int[26][pat.length()];

            /**
             * 最初匹配的字符数为0
             * 如果txt中当前的字符是pat中的第一个字符，那么txt中的下一个字符需要与pat的索引为1的字符匹配
             * 除此之外，txt的下一个字符都应该尝试与pat中索引为0的字符匹配
             */
            dfa[pat.charAt(0) - 'a'][0] = 1;
            //如果当前状态匹配失败将进入的状态，0表示最初匹配失败将转到匹配成功0个字符的状态
            int x = 0;

            //遍历状态
            for(int j = 1;j < pat.length(); ++j){
                //当前字符匹配失败的话，txt下一个字符应该与回退的状态指示的那个模式字符匹配
                for(int ch = 0; ch < 26;++ch){
                    dfa[ch][j] = dfa[ch][x];
                }
                //匹配成功
                dfa[pat.charAt(j) - 'a'][j] = j + 1;
                //当下一个字符匹配失败时的失败状态，是txt[i]当前最多能匹配的状态（当前字符需要匹配成功）
                x = dfa[pat.charAt(j) - 'a'][x];
            }
        }

        int search(){
            int i = 0, j = 0;
            for(;i < txt.length() && j < pat.length();++i){
                j = dfa[txt.charAt(i) - 'a'][j];
            }
            if(j == pat.length()) return i - j;
            return -1;
        }
    }
}
// @lc code=end

