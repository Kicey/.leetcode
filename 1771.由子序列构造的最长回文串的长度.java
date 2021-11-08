/*
 * @lc app=leetcode.cn id=1771 lang=java
 *
 * [1771] 由子序列构造的最长回文串的长度
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String word1, String word2) {
        int ret = 0;
        word2 = new StringBuffer(word2).reverse().toString();
        int [][] map = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0;i < word1.length() + 1;++i){
            map[i][0] = 0;
        }
        for(int i = 1;i < word2.length() + 1;++i){
            map[0][i] = 0;
        }
        for(int i = 0;i < word1.length();++i){
            for(int j = 0;j < word2.length();++j){
                if(word1.charAt(i) == word2.charAt(j)){
                    map[i + 1][j + 1] = map[i][j] + 1;
                }else{
                    map[i + 1][j + 1] = Math.max(map[i][j + 1], map[i + 1][j]);
                }
                if(i == word1.length() - 1 && j != 0){
                    if(map[i + 1][j + 1] * 2 > ret) ret = 2 * map[i + 1][j + 1];
                }else{
                    if(ret != 0 && map[i + 1][j + 1] * 2 >= ret) ret = 2 * map[i + 1][j + 1] + 1;
                }
            }
        }
        return ret;
    }
}
// @lc code=end

