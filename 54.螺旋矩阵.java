import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    int[][] matrix;
    List<Integer> ans = new ArrayList<>();
    int n, m;
    int[][] direct = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = 0;
        this.matrix = matrix;
        n = matrix.length; m = matrix[0].length;
        for(;i < (n + 1) / 2 && j < (m + 1) / 2;++i,++j){
            System.out.printf("start: %d, %d\n", i, j);
            oneCycle(i, j);
        }
        return ans;
    }

    private void oneCycle(int i, int j){
        int x = i, y = j;
        int dx = Integer.MIN_VALUE, dy = Integer.MIN_VALUE;
        int[][] vertexs = new int[][]{{x, y}, {x, m - 1 - y}, {n - 1 - x, m - 1 - y}, {n - 1 - x, y}};
        // 只存在一列
        boolean conda = Arrays.equals(vertexs[0], vertexs[1]);
        // 只存在一行
        boolean condb = Arrays.equals(vertexs[0], vertexs[3]);
        if(conda && condb){
            System.out.println("both");
            ans.add(matrix[x][y]);
            return;
        }
        if(conda){
            System.out.println("conda");
            for(int k = vertexs[0][0];k <= vertexs[3][0];++k){
                ans.add(matrix[k][y]);
            }
            return;
        }
        if(condb){
            System.out.println("condb");
            for(int k = vertexs[0][1];k <= vertexs[1][1];++k){
                ans.add(matrix[x][k]);
            }
            return;
        }
        do{
            // System.out.printf("%d, %d\n", x, y);
            ans.add(matrix[x][y]);
            for(int k = 0;k < 4;++k){
                if(x == vertexs[k][0] && y == vertexs[k][1]){
                    dx = direct[k][0];
                    dy = direct[k][1];
                }
            }
            x += dx; y += dy;
            // System.out.printf("after: %d, %d\n", x, y);
        } while(x != i || y != j);
    }
}
// @lc code=end

