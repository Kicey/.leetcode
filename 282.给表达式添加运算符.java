import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=282 lang=java
 *
 * [282] 给表达式添加运算符
 */

// @lc code=start
class Solution {
    String num;
    int n;
    int target;
    List<String> ans;

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.n = num.length();
        this.target = target;
        this.ans = new ArrayList<>();
        dfs(new StringBuilder(), 0, 0, 0);
        return ans;
    }


    public void dfs(StringBuilder expr, int toAddBefore, long lastOn, long curValue){
        if(toAddBefore == n){
            if(curValue == target){
                ans.add(expr.toString());
            }
            return;
        }

        int signIndex = expr.length();
        if(toAddBefore != 0) expr.append('$');

        long on = 0;
        for(int last = toAddBefore;last < n && (last == toAddBefore || num.charAt(toAddBefore) != '0');++last){
            on = on * 10 + (num.charAt(last) - '0');
            expr.append(num.charAt(last));
            if(toAddBefore == 0){
                dfs(expr, last + 1, on, on);
                continue;
            }

            expr.setCharAt(signIndex, '+');
            dfs(expr, last + 1, on, curValue + on);

            expr.setCharAt(signIndex, '-');
            dfs(expr, last + 1, -on, curValue - on);

            expr.setCharAt(signIndex, '*');
            dfs(expr, last + 1, lastOn * on,curValue - lastOn + lastOn * on);
        }
        expr.setLength(signIndex);
    }

}
// @lc code=end

