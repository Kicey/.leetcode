import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第 N 位数字
 */

// @lc code=start
class Solution {
    List<Integer> preRange = new ArrayList<>();
    {
        int pre = 0, cur = 0;
        int pow = 1;
        while(true) {
            cur = cur * 10 + 9;
            int count = (cur - pre) * pow;
            if(count <= 0) break;
            preRange.add(count);
            pre = cur;
            pow += 1;
        }
    }

    public int findNthDigit(int n) {
        for(int count: preRange){
            if(n <= count){
                
            }
        }
        
        return 0;
    }
}
// @lc code=end

