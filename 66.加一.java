import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        digits[index] += 1;
        while(index > 0 && digits[index] == 10){
            digits[index] = 0;
            --index;
            digits[index] += 1;
        }
        if(digits[0] == 10){
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            ret[1] = 0;
            for(int i = 2;i< ret.length;++i){
                ret[i] = digits[i - 1];
            }
            return ret;
        }
        return digits;
    }
}
// @lc code=end

