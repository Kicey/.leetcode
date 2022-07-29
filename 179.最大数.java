import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        Integer[] nums_ = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(nums_, (a, b) -> {
            int atimes, btimes;
            atimes = btimes = 10;
            while(a >= atimes) {
                atimes *= 10;
            }
            while(b >= btimes) {
                btimes *= 10;
            }
            return -((a * btimes + b) - (b * atimes + a));
        });
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < nums_.length;++i){
            if(nums_[i] != 0 || stringBuilder.length() != 0){stringBuilder.append(nums_[i]);}
        }
        if(stringBuilder.length() == 0){
            return "0";
        }
        return stringBuilder.toString();
    }
}
// @lc code=end

