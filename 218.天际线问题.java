/*
 * @lc app=leetcode.cn id=218 lang=java
 *
 * [218] 天际线问题
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        return null;
    }

    Comparator<List<Integer>> cmp = new Comparator<List<Integer>>(){
        public int compare(List<Integer> o1, List<Integer> o2){
            if(o1.get(0) < o2.get(0)) return -1;
            if(o1.get(0) > o2.get(0)) return 1;
            return 0;
        }
    };
}
// @lc code=end

