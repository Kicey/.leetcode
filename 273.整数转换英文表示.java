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
        map.put(30, "Thirty");
        map.put(40, "Foty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
    }
    String[] units = new String[]{"Billion", "Million", "Thousand", ""};
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
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
            if(curNum % 100 / 10 == 0){
                if(curNum % 10 != 0){
                    if(stringBuilder.length() != 0){
                        stringBuilder.append(' ');
                        stringBuilder.append(map.get(curNum % 10));
                    }
                }
            } else if (curNum % 100 / 10 == 1){
                if(stringBuilder.length() != 0){
                    stringBuilder.append(' ');
                    stringBuilder.append(map.get(curNum % 100));
                }
            } else {
                 if(stringBuilder.length() != 0){
                    stringBuilder.append(' ');
                    stringBuilder.append(map.get(curNum % 100 / 10 * 10));
                 }
                 if(curNum % 10 != 0){
                    stringBuilder.append(' ');
                    stringBuilder.append(map.get(curNum % 10));
                 }
            }
            ans.add(stringBuilder.toString());
        }
        StringBuilder finalAns = new StringBuilder();
        int curUnit = 4 - ans.size();
        finalAns.append(ans.get(0));
        for(int i = 1;i < ans.size();++i){
            finalAns.append(' ');
            finalAns.append(units[curUnit++]);
        }
        return finalAns.toString();
    }
}
// @lc code=end

