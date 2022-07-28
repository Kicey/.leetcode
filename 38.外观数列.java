/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        String num = "1";
        for(;n > 1;--n){
            System.out.println(num);
            var count = 0;
            StringBuilder nextNum = new StringBuilder();
            char pre = '.';
            for(char c: num.toCharArray()){
                if(pre != '.' && c != pre){
                    nextNum.append(Integer.toString(count));
                    nextNum.append(pre);
                    count = 1;
                } else {
                    ++count;
                }
                pre = c;
            }
            nextNum.append(Integer.toString(count));
            nextNum.append(num.toCharArray()[num.length() - 1]);
            num = nextNum.toString();
        }
        return num;
    }
}
// @lc code=end

