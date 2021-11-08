import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int y = 0, x = matrix[0].length - 1;
        while(x >= 0 && y < matrix.length){
            if(matrix[y][x] == target) return true;
            else if(matrix[y][x] > target) --x;
            else if(matrix[y][x] < target) ++y;
        }
        return false;
    }
}
// @lc code=end

