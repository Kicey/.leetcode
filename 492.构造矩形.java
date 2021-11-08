/*
 * @lc app=leetcode.cn id=492 lang=java
 *
 * [492] 构造矩形
 */

// @lc code=start
class Solution {
    public int[] constructRectangle(int area) {
        int l;
        l = (int) Math.sqrt(area);
        while(area % l != 0) --l;
        l = Math.max(l, area / l);
        return new int[]{l, area/l};
    }
}
// @lc code=end

