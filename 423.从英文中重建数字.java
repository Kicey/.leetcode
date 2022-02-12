import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=423 lang=java
 *
 * [423] 从英文中重建数字
 */

// @lc code=start
class Solution {

    String[] nums = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    int[] numOrder = new int[]{0, 6, 8, 7, 5, 2, 4, 3, 1, 9};
    char[] numSpecial = new char[]{'z', 'x', 'g', 's', 'v', 'w', 'f', 't', 'o', 'n'};
    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> list = new LinkedList<>();
        for(int i = 0;i < numOrder.length; ++i){
            int num = numOrder[i];
            char c = numSpecial[i];
            int count = map.getOrDefault(c, 0);
            for(char c_ : nums[num].toCharArray()){
                count = Math.min(count, map.getOrDefault(c_, 0));
            }
            for(char c_ : nums[num].toCharArray()){
                map.put(c_, map.getOrDefault(c_, 0) - count);
            }
            while(count-- > 0) list.add(num);
        }
        Collections.sort(list);
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer e : list){
            stringBuilder.append(e.toString());
        }
        return stringBuilder.toString();
    }
}
// @lc code=end

