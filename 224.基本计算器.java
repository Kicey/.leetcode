import java.util.Stack;

/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 */

// @lc code=start
class Solution {
    Stack<String> opStack = new Stack<>();
    Stack<String> numStack = new Stack<>();
    public int calculate(String s) {
        String[] exp = s.split("(?=\\d)|(?<=\\d)");
        for(String unit: exp){
            boolean isNum = false;
            int num = 0;
            try {
                num = Integer.parseInt(unit);
                isNum = true;
            } catch (NumberFormatException e){
                isNum = false;
            }
            if(isNum){
                if(opStack.isEmpty()){
                    continue;
                }
                compute();
            } else {
                if(unit.equals(")")){
                    while(!numStack.peek().equals("(")){
                        compute();
                    }
                    numStack.pop();
                    compute();
                } else {
                    opStack.push(unit);
                }
            }
        }
        return Integer.valueOf(numStack.pop());
    }

    public void compute(){
        String op = opStack.pop();
        if(op.equals("+")){
            int num1 = Integer.valueOf(numStack.pop());
            int num0 = Integer.valueOf(numStack.pop());
            int newNum = num0 + num1;
            numStack.push(Integer.toString(newNum));
        } else {
            if(numStack.size() == 1 || numStack.get(numStack.size() - 2).equals("(")){
                int num0 = Integer.valueOf(numStack.pop());
                numStack.push(Integer.toString(num0));
            } else {
                int num1 = Integer.valueOf(numStack.pop());
                int num0 = Integer.valueOf(numStack.pop());
                int newNum = num0 - num1;
                numStack.push(Integer.toString(newNum));
            }
        }
    }
}
// @lc code=end

