/*
 * @lc app=leetcode.cn id=214 lang=java
 *
 * [214] 最短回文串
 */

// @lc code=start
class Solution {
    private String pat;
    private int [] next;    //next[j]:如果与pat[j]字符匹配失败，接下来应该去匹配的字符的索引，-1代表彻底无法匹配，txt的指针向后移动重新开始

    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        StringBuilder sb = new StringBuilder(s);
        sb.append('#');
        sb.append(rev);
        pat = sb.toString();
        next = new int[pat.length() + 1];
        genNextArr();
        int psfix = next[next.length - 1];
        return rev.substring(0,rev.length() - psfix) + s;
    }

    private void genNextArr(){
        next[0] = -1;
        next[1] = 0;
        int i = 2;  //next[]的索引，即尝试的公共后缀字符串末尾字符索引+1
        int k = 0;  //上一个next[]的值，即尝试的公共前缀字符串末尾字符索引，也是出去当前字符(pat[i - 1])最长公共前后缀的长度
        while(i < next.length){
            if(pat.charAt(i - 1) == pat.charAt(k)){
                next[i] = k + 1;
                k += 1;
                ++i;
            }
            //既当前字符不能匹配，先前的字符串同样没有公共前后缀
            else if(k == 0){
                next[i] = 0;
                ++i;
            }else{
                k = next[k];
            }
        }
    }
}
// @lc code=end

