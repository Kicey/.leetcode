import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1380 lang=java
 *
 * [1380] 矩阵中的幸运数
 */

// @lc code=start
class Solution {
    int[] rowMin, colMax;
    public List<Integer> luckyNumbers (int[][] matrix) {
        rowMin = new int[matrix.length];
        colMax = new int[matrix[0].length];

        Arrays.fill(rowMin, Integer.MAX_VALUE);
        Arrays.fill(colMax, Integer.MIN_VALUE);

        for(int i = 0;i < matrix.length;++i){
            for(int j = 0;j < matrix[0].length;++j){
                int e = matrix[i][j];
                if(e < rowMin[i]) rowMin[i] = e;
                if(e > colMax[j]) colMax[j] = e;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int e0: rowMin){
            for(int e1: colMax){
                if(e0 == e1) res.add(e0);
            }
        }
        return res;
    }
}
// @lc code=end

