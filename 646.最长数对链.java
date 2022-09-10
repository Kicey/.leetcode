import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            return a[1] - b[1];
        });
        int cnt = 1;
        int preIndex = 0;
        for(int i = 1;i < pairs.length;++i){
            if(pairs[i][0] > pairs[preIndex][1]){
                preIndex = i;
                ++cnt;
            }
        }
        return cnt;
    }
}
// @lc code=end

