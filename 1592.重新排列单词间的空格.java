import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1592 lang=java
 *
 * [1592] 重新排列单词间的空格
 */

// @lc code=start
class Solution {
    public String reorderSpaces(String text) {
        int cnt = 0;
        for(char c: text.toCharArray()){
            if(c == ' '){
                ++cnt;
            }
        }
        if(cnt == 0){
            return text;
        }
        String[] words = text.split("\\s+");
        int n = words.length;
        if(words[0].equals("")){
            for(int i = 0;i < n - 1;++i){
                words[i] = words[i + 1];
            }
            n = n - 1;
        }
        if(n == 1){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(words[0]);
            for(int j = 0;j < cnt;++j){
                stringBuilder.append(' ');
            }
            return stringBuilder.toString();
        }
        int average = cnt / (n -1);
        int remain = cnt - average * (n - 1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(words[0]);
        char[] temp = new char[average];
        Arrays.fill(temp, ' ');
        String blank = new String(temp);
        for(int i = 1;i < n;++i){
            stringBuilder.append(blank);
            stringBuilder.append(words[i]);
        }
        for(int i = 0;i < remain;++i){
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }
}
// @lc code=end

