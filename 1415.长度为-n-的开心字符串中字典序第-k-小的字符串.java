/*
 * @lc app=leetcode.cn id=1415 lang=java
 *
 * [1415] 长度为 n 的开心字符串中字典序第 k 小的字符串
 */

// @lc code=start
class Solution {
    char[] alphabet = new char[]{'a', 'b', 'c'};
    int cnt = 0;
    StringBuilder curStr = new StringBuilder();
    String ans = null;
    int n, k;
    public String getHappyString(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(0);
        if(ans == null){
            ans = "";
        }
        return ans;
    }

    private void dfs(int index){
        if(ans != null){
            return;
        }
        if(index == n){
            ++cnt;
            if(cnt == k){
                ans = curStr.toString();
            }
            return;
        }
        for(int i = 0;i < 3;++i){
            if(curStr.length() != 0 && curStr.charAt(index - 1) == alphabet[i] ){
                continue;
            }
            curStr.append(alphabet[i]);
            dfs(index + 1);
            curStr.delete(index, index + 1);
        }
    }
}
// @lc code=end

