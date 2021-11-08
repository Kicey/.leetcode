import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=282 lang=java
 *
 * [282] 给表达式添加运算符
 */

// @lc code=start
class Solution {
    int n;
    String num;
    int target;
    List<String> ans;

    public List<String> addOperators(String num, int target) {
        this.n = num.length();
        this.num = num;
        this.target = target;
        this.ans = new ArrayList<String>();
        StringBuffer expr = new StringBuffer();
        backtrack(expr, 0, 0, 0);   //以空表达式，索引0，结果0，上一次计算增加0，开始
        return ans;
    }

    /**
     * @param expr 当前生成的表达式
     * @param i 在索引为i的数字前插入符号
     * @param res 当前表达式的计算结果
     * @param mul 上一次计算加的数
     */
    public void backtrack(StringBuffer expr, int i, long res, long mul) {
        if (i == n) {
            if (res == target) {
                ans.add(expr.toString());
            }
            return;
        }
        int signIndex = expr.length();  // 先记下符号的索引，用于之后的填充
        if (i > 0) {
            expr.append(0); // 占位，下面填充符号
        }
        long val = 0;
        // 决定插入的符号的第二个操作数（遍历，从索引为i的数字开始增加），注意数字可以是单个 0 但不能有前导零
        for (int j = i; j < n && (j == i || num.charAt(i) != '0'); ++j) {
            val = val * 10 + num.charAt(j) - '0';   // 第二个操作数的值
            expr.append(num.charAt(j));             // 将第二个操作数加入到表达式
            if (i == 0) { // 表达式开头不能添加符号，那么第二个操作数的值将作为当前表达式的结果，并且当前表达式为这个操作数
                backtrack(expr, j + 1, val, val);
            } else { // 枚举符号
                //加减直接递归即可
                expr.setCharAt(signIndex, '+');
                backtrack(expr, j + 1, res + val, val);

                expr.setCharAt(signIndex, '-');
                backtrack(expr, j + 1, res - val, -val);

                //如果遇上乘号，则会改变计算的顺序，不能直接使用之前的结果
                //回滚上一次的计算res - mul
                //将上一次的操作数与本次的操作数相乘mul * val
                //二者相加即为当前表达式的值
                expr.setCharAt(signIndex, '*');
                backtrack(expr, j + 1, res - mul + mul * val, mul * val);
            }
        }
        //回滚表达式
        expr.setLength(signIndex);
    }
}
// @lc code=end

