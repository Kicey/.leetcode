import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1417 lang=java
 *
 * [1417] 重新格式化字符串
 */

// @lc code=start
class Solution {
    List<Character> nums = new ArrayList<>();
    List<Character> alphas = new ArrayList<>();
    public String reformat(String s) {
        for(var c: s.toCharArray()){
            if(Character.isDigit(c)){
                nums.add(c);
            }else{
                alphas.add(c);
            }
        }
        List<Character> more, less;
        if(nums.size() > alphas.size()){
            more = nums;
            less = alphas;
        } else{
            more = alphas;
            less = nums;
        }
        if(more.size() - less.size() > 1){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < more.size();++i){
            stringBuilder.append(more.get(i));
            if(i == less.size()) break;
            stringBuilder.append(less.get(i));
        }
        return stringBuilder.toString();
    }
}
// @lc code=end
