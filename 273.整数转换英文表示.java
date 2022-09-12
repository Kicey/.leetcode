import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=273 lang=java
 *
 * [273] 整数转换英文表示
 */

// @lc code=start
class Solution {
    Stack<Integer> stack = new Stack<>();
    Map<Integer, String> map = new HashMap<>();
    {
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, );
        map.put(40, );
        map.put(50, );
        map.put(60, );
        map.put(70, );
        map.put(80, );
        map.put(90, );
    }
    public String numberToWords(int num) {
        if(num == 0){
            return "zero";
        }
        while(num > 0){
            stack.add(num % 1000);
            num /= 1000;
        }
        List<String> ans = new ArrayList<>();
        while(!stack.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            int curNum = stack.pop();
            if(curNum / 100 != 0){
                stringBuilder.append(map.get(curNum / 100)).append(' ').append("Hundred");
            }
            if(curNum % 100 / 10 != 0){
                if(stringBuilder.length() != 0){
                    stringBuilder.append(' ');
                }
                stringBuilder.append(curNum % 100 / 10 * 10);
            }
            if(curNum % 10 != 0){
                if(stringBuilder.length() != 0){
                    stringBuilder.append(' ');
                }
                stringBuilder.append(curNum % 10);
            }
            ans.add(stringBuilder.toString());
        }
        for(int i = 0;i < ans;++i){

        }
    }
}
// @lc code=end

