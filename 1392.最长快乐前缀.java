/*
 * @lc app=leetcode.cn id=1392 lang=java
 *
 * [1392] 最长快乐前缀
 */

// @lc code=start
class Solution {
    private int[] next;
    String pat;

    public String longestPrefix(String s) {
        next = new int[s.length() + 1];
        pat = s;
        genNextArr();
        return s.substring(0, next[next.length - 1]);
    }

    private void genNextArr(){
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int k = 0;
        while(i < next.length){
            if(pat.charAt(i - 1) == pat.charAt(k)){
                next[i] = k + 1;
                k += 1;
                ++i;
            }else if(k == 0){
                next[i] = 0;
                ++i;
            }else{
                k = next[k];
            }
        }
    }
}
// @lc code=end

