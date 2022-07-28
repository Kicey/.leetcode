/*
 * @lc app=leetcode.cn id=593 lang=java
 *
 * [593] 有效的正方形
 */

// @lc code=start
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[][]{p1, p2, p3, p4};
        for(int i = 0;i < 4;++i){
            for(int j = i + 1;j < 4;++j){
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]){
                    return false;
                }
            }
        }
        int[] top = new int[2];
        int[] left = new int[2];
        int[] right = new int[2];
        int[] bottom = new int[2];
        int topX = Integer.MIN_VALUE, leftY = Integer.MAX_VALUE, rightY = Integer.MIN_VALUE, bottomX = Integer.MAX_VALUE;
        for(int i = 0;i < 4;++i){
            if(points[i][0] > topX || (points[i][0] == topX && points[i][1] < top[1])){
                top = points[i];
                topX = points[i][0];
            }
            if(points[i][0] < bottomX || (points[i][0] == bottomX && points[i][1] > bottom[1])){
                bottom = points[i];
                bottomX = points[i][0];
            }
            if(points[i][1] < leftY || (points[i][1] == leftY && points[i][0] < left[0])){
                left = points[i];
                leftY = points[i][1];
            }
            if(points[i][1] > rightY || (points[i][1] == rightY && points[i][0] > right[0])){
                right = points[i];
                rightY = points[i][1];
            }
        }
        if(top[0] - right[0] != left[0] - bottom[0] || top[1] - right[1] != left[1] - bottom[1]){
            return false;
        }
        int square1 = (top[0] - right[0]) * (top[0] - right[0]) + (top[1] - right[1]) * (top[1] - right[1]);
        int square2 = (top[0] - bottom[0]) * (top[0] - bottom[0]) + (top[1] - bottom[1]) * (top[1] - bottom[1]);
        if(square1 * 2 != square2){
            return false;
        }
        return true;
    }
}
// @lc code=end

