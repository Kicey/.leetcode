/*
 * @lc app=leetcode.cn id=640 lang=java
 *
 * [640] 求解方程
 */

// @lc code=start
class Solution {
    public String solveEquation(String equation) {
        String[] splitedEquation = equation.split("=");
        String left = splitedEquation[0];
        String right = splitedEquation[1];
        int[] leftSimplified = simplify(left);
        int[] rightSimplified = simplify(right);
        int coeffiencient = leftSimplified[0] - rightSimplified[0];
        int constant = rightSimplified[1] - leftSimplified[1];
        if(coeffiencient == 0){
            if(constant == 0){
                return "Infinite solutions";
            }else{
                return "No solution";
            }
        }
        return String.format("x=%d", constant / coeffiencient);
    }

    private int[] simplify(String formula) {
        String[] items = formula.split("(?=[\\+\\-])");
        int coeffiencient = 0;
        int constant = 0;
        for(String item: items){
            int sign = 1;
            String absValue = item;
            if(item.charAt(0) == '-'){
                sign = -1;
                absValue = item.substring(1);
            } else if(item.charAt(0) == '+'){
                absValue = item.substring(1);
            }
            if(absValue.endsWith("x")){
                absValue = absValue.substring(0, absValue.length() - 1);
                if(absValue.equals("")){
                    absValue = "1";
                }
                coeffiencient += sign * Integer.valueOf(absValue);
            } else{
                constant += sign * Integer.valueOf(absValue);
            }
        }
        return new int[]{coeffiencient, constant};
    }
}
// @lc code=end

