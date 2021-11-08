import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    List<String> ans;
    int left = 0;
    int right = 0;
    StringBuilder curBuilder = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        ans = new LinkedList<>();
        left = right = n;
        dfs();
        return ans;
    }

    private void dfs(){
        if(left == 0 && right == 0){
            ans.add(curBuilder.toString());
            return;
        }

        if(left > 0){
            curBuilder.append('(');
            --left;
            dfs();
            ++left;
            curBuilder.deleteCharAt(curBuilder.length() - 1);
        }

        if(right > left){
            curBuilder.append(')');
            --right;
            dfs();
            ++right;
            curBuilder.deleteCharAt(curBuilder.length() - 1);
        }
    }
}
// @lc code=end

