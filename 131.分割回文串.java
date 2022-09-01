import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    String s;
    int[][] palindromeLen;
    int n;
    List<List<String>> ans = new ArrayList<>();
    List<String> strs = new ArrayList<>();
    public List<List<String>> partition(String s) {
        this.s = s;
        n = s.length();
        palindromeLen = new int[n][n];
        dfs(0);
        return ans;
    }

    private void dfs(int start){
        if(start == n){
            ans.add(new ArrayList<>(strs));
        }
        for(int i = start;i < n;++i){
            if(isPalindrome(start, i) > 0){
                strs.add(s.substring(start, i + 1));
                dfs(i + 1);
                strs.remove(strs.size() - 1);
            }
        }
    }

    private int isPalindrome(int i, int j){
        if(i == j){
            return palindromeLen[i][j] = 1;
        }
        if(i > j){
            return 0;
        }
        if(s.charAt(i) != s.charAt(j)){
            return palindromeLen[i][j] = -1;
        } else {
            int len = isPalindrome(i + 1, j - 1);
            if(len < 0) return -1; 
            return isPalindrome(i + 1, j - 1) + 2;
        }
    }
}
// @lc code=end

