import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=846 lang=java
 *
 * [846] 一手顺子
 */

// @lc code=start
class Solution {
    int n;
    int left;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        for(int e: hand){
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        while(map.size() > 0){
            int first = map.firstKey();
            for(int i = 0;i < groupSize;++i){
                int cur = first + i;
                if(!map.containsKey(cur)) return false;
                if(map.get(cur) == 1) map.remove(cur);
                else map.put(cur, map.get(cur) - 1);
            }
        }
        return true;
    }
}
// @lc code=end

