
/*
 * @lc app=leetcode.cn id=528 lang=java
 *
 * [528] 按权重随机选择
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
class Solution {
    Random random = new Random();
    ArrayList<Integer> prefix = new ArrayList<Integer>();

    public Solution(int[] w) {
        if(w.length > 0) prefix.add(w[0]);
        for(int i = 1;i < w.length;++i){
            prefix.add(prefix.get(i - 1) + w[i]);
        }
    }
    
    public int pickIndex() {
        Integer target = random.nextInt(prefix.get(prefix.size() - 1));
        Integer ret = Collections.binarySearch(prefix, target);
        if(ret >= 0) return ret + 1;
        else return - (ret + 1);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

