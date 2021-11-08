import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// @lc code=start
class Solution {
    
    Set<Integer> set = new HashSet<>();

    public int distributeCandies(int[] candyType) {
        for(int e: candyType){
            set.add(e);
        }
        if(set.size() >= candyType.length/2){
            return candyType.length/2;
        }
        return set.size();
    }
}
// @lc code=end

