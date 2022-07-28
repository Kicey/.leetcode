import java.util.ArrayList;
import java.util.List;;
/*
 * @lc app=leetcode.cn id=592 lang=java
 *
 * [592] 分数加减运算
 */

// @lc code=start
class Solution {
    List<int[]> nums = new ArrayList<>();
    int numerator;
    int demoninator;

    public String fractionAddition(String expression) {
        if (expression.charAt(0) != '-') {
            expression = '+' + expression;
        }
        String[] numStrings = expression.split("(?=[\\+\\-])");
        for (var str : numStrings) {
            System.out.println(str);
        }
        for (var numString : numStrings) {
            int curNum[] = new int[3];
            if (numString.charAt(0) == '+') {
                curNum[0] = 1;
            } else if (numString.charAt(0) == '-') {
                curNum[0] = -1;
            }
            var unsigned = numString.substring(1);
            var numeratorAndDenominator = unsigned.split("/");
            curNum[1] = Integer.valueOf(numeratorAndDenominator[0]);
            curNum[2] = Integer.valueOf(numeratorAndDenominator[1]);
            nums.add(curNum);
        }
        numerator = nums.get(0)[0] * nums.get(0)[1];
        demoninator = nums.get(0)[2];
        for (int i = 1; i < nums.size(); ++i) {
            var curNum = nums.get(i);
            int lcm = lcm(demoninator, curNum[2]);
            numerator = numerator * (lcm / demoninator) + curNum[0] * curNum[1] * (lcm / curNum[2]);
            demoninator = lcm;
            if (numerator == 0) {
                demoninator = 1;
            } else {
                var gcd = gcd(Math.abs(numerator), demoninator);
                numerator = numerator / gcd;
                demoninator = demoninator / gcd;
            }
        }
        return numerator + "/" + demoninator;
    }

    private int gcd(int x, int y) {
        while (x % y != 0) {
            var tmp = y;
            y = x % y;
            x = tmp;
        }
        return y;
    }

    private int lcm(int x, int y) {
        int gcd = gcd(x, y);
        return x * y / gcd;
    }
}
// @lc code=end
