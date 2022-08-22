import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1455 lang=java
 *
 * [1455] 检查单词是否为句中其他单词的前缀
 */

// @lc code=start
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int curIndex = 1;
        for(String word: words){
            if(! (word.length() < searchWord.length())){
                if(word.substring(0, searchWord.length()).equals(searchWord)){
                    return curIndex;
                }
            }
            curIndex++;
        }
        return -1;
    }
}
// @lc code=end

