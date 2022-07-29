import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    String longString, shortString;
    int m, n;
    public String multiply(String num1, String num2) {
        if(num1.length() >= num2.length()){
            longString = num1;
            shortString = num2;
        } else {
            longString = num2;
            shortString = num1;
        }
        m = longString.length();
        n = shortString.length();
        List<StringBuilder> addends = new ArrayList<>();
        int offset = 0;
        for(int i = n - 1;i >= 0;--i){
            int multiplierB = Character.digit(shortString.charAt(i), 10);
            if(multiplierB == 0) {
                ++offset;
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            int carry = 0;
            for(int j = m - 1;j >= 0;--j){
                int multiplierA = Character.digit(longString.charAt(j), 10);
                int localProduct = multiplierA * multiplierB + carry;
                carry = localProduct / 10;
                stringBuilder.append(Integer.toString(localProduct % 10));
            }
            if(carry != 0){
                stringBuilder.append(carry);
            }
            stringBuilder.reverse();
            for(int j = 0;j < offset;++j){
                stringBuilder.append('0');
            }
            addends.add(stringBuilder);
            ++offset;
        }
        if(addends.isEmpty()){
            return "0";
        }
        StringBuilder ans = new StringBuilder(addends.get(0));
        for(int i = 1;i < addends.size();++i){
            StringBuilder localLong, localShort;
            if(ans.length() >= addends.get(i).length()){
                localLong = ans;
                localShort = addends.get(i);
            } else {
                localLong = addends.get(i);
                localShort = ans;
            }
            int carry = 0;
            int j0 = localShort.length() - 1, j1 = localLong.length() - 1;
            for(;j1 >= 0;--j0, --j1){
                int addendA = Character.digit(localLong.charAt(j1), 10);
                int addendB = 0;
                if(j0 >= 0) {
                    addendB = Character.digit(localShort.charAt(j0), 10);
                }
                int sum = addendA + addendB + carry;
                carry = sum / 10;
                localLong.setCharAt(j1, Integer.toString(sum % 10).charAt(0));
            }
            if(carry != 0){
                localLong.insert(0, Integer.toString(carry));
            }
            ans = localLong;
        }
        return ans.toString();
    }
}
// @lc code=end

